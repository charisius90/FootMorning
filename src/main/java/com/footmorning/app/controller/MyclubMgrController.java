package com.footmorning.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.domain.ClubMemberDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.service.ClubMemberService;
import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.MemberService;

@Controller
@RequestMapping("/myclubMgr/*")
public class MyclubMgrController {
	@Autowired
	private ClubService service;
	@Autowired
	private ClubMemberService clubMemberService;
	@Autowired
	private MemberService memberService;
	
	// 회원 등급 파이널 변수 모음
	public static final String GRADE_ADMIN = "0"; // 서비스 운영진
	public static final String GRADE_MASTER = "1"; // 클럽마스터
	public static final String GRADE_MANAGER = "2"; // 클럽매니저
	public static final String GRADE_STAFF = "3"; // 클럽스탭
	public static final String GRADE_MEMBER = "4"; // 클럽소속회원
	public static final String GRADE_NORMAL = "5"; // 일반회원
	
	/**
	 * @박수항
	 * 가입신청 테스트용(컨트롤러 위치 변경해야함)
	 */
	@RequestMapping(value="clubRequest", method=RequestMethod.POST)
	public String requestPOST(ClubMemberDTO dto){
		System.out.println(dto);
		clubMemberService.insert(dto);
		return "redirect:/myclub/myclubMain?no=" + dto.getClub_no();
	}
	
	/**
	 * 기본정보 변경 페이지
	 */
	@RequestMapping("myclubMgrInfo")
	public String myclubInfoMgr(HttpServletRequest req){
		MemberDTO member = (MemberDTO)WebUtils.getSessionAttribute(req, "USER_KEY");
		ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
		
		// 회원등급
		int grade = Integer.parseInt(member.getMem_grade());
		// 자기 클럽 관리페이지 이동 요청인지 확인
		boolean flag = member.getClub_no().equals(club.getClub_no());
		if(grade<3 && flag){
			return "/myclubMgr/myclubMgrInfo";
		}
		
		return "/myclub/myclubMain";
	}
	
	@RequestMapping(value="myclubMgrInfo", method=RequestMethod.POST)
	public String myclubInfoMgrComplete(ClubDTO dto, HttpServletRequest req){
		System.out.println("myclubMgrInfo : " + dto);
		if(dto.getClub_image()==null){
			try {
				ClubDTO club = service.getClubInfo(dto.getClub_name());
				dto.setClub_image(club.getClub_image());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		service.update(dto);
		WebUtils.setSessionAttribute(req, "CLUB_KEY", dto);
		
		return "redirect:/myclubMgr/myclubMgrInfo";
	}
	
	/**
	 * 가입조건관리
	 */
	@RequestMapping("myclubMgrJoinCondition")
	public void myclubMgrJoinCondition(){
		
	}
	
//	/**
//	 * 클럽대문관리
//	 */
//	@RequestMapping("myclubMgrMain")
//	public void myclubMgrMain(){
//		
//	}
//	
//	/**
//	 * 클럽메뉴관리
//	 */
//	@RequestMapping("myclubMgrMenu")
//	public void myclubMgrMenu(){
//		
//	}
	
	/**
	 * 클럽멤버관리
	 */
	@RequestMapping("myclubMgrMember")
	public void myclubMgrMember(HttpServletRequest req, Model model){
		try {
			ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
			model.addAttribute("list", clubMemberService.listMember(Integer.parseInt(club.getClub_no())));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="myclubMgrMember", method=RequestMethod.POST)
	public @ResponseBody List myclubMgrMemberComplete(@RequestBody List<Map<String, Object>> list){
        
		ClubMemberDTO dto = null;
		MemberDTO member = null;
		for(Map map : list){
			try {
				// club_member 테이블 grade 수정
				dto = clubMemberService.getWithMemno(Integer.parseInt((String)map.get("mem_no")));
				dto.setMem_grade((String)map.get("mem_grade"));
				clubMemberService.update(dto);
				
				// member 테이블 grade 수정
				member = memberService.getWithNo(Integer.parseInt((String)map.get("mem_no")));
				member.setMem_grade((String)map.get("mem_grade"));
				memberService.updateMember(member);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
        return list;
//		return "redirect:/myclubMgr/myclubMgrMember";
	}

	
	/**
	 * 가입신청관리
	 */
	@RequestMapping("myclubMgrRegister")
	public void myclubMgrRegister(HttpServletRequest req, Model model){
		try {
			ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
			model.addAttribute("req", clubMemberService.listRequest(Integer.parseInt(club.getClub_no())));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="myclubMgrRegister", method=RequestMethod.POST)
	public String myclubMgrRegisterComplete(@RequestParam(value="mem_no") List<String> memberList, String type, Model model){
		// 가입신청승인
		if(type.equals("approval")){
			for(String mem_no : memberList){
				try{
					// 클럽멤버 테이블에 삽입
					ClubMemberDTO clubMember = clubMemberService.getWithMemno(Integer.parseInt(mem_no));
					clubMember.setClub_mem_flag("TRUE");
					clubMember.setMem_grade(GRADE_MEMBER);
		            clubMemberService.update(clubMember);
		            
		            // 멤버 테이블에 클럽번호, 등급, 클럽가입일 컬럼 업데이트
		            MemberDTO member = memberService.getWithNo(Integer.parseInt(mem_no));
		            member.setClub_no(clubMember.getClub_no());
		            member.setMem_grade(GRADE_MEMBER);
		            member.setMem_club_regdate(clubMember.getClub_mem_regdate());
		            memberService.updateMember(member);
				}
				catch(Exception e){
					 e.printStackTrace();
				}
			}
		}
		// 가입신청거절
		else{
			for(String mem_no : memberList){
				try{
					ClubMemberDTO clubMember = clubMemberService.getWithMemno(Integer.parseInt(mem_no));
					clubMemberService.delete(clubMember);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return "redirect:/myclubMgr/myclubMgrRegister";
	}
	
	
	/**
	 * 직책/등급관리
	 */
	@RequestMapping("myclubMgrMemberGrade")
	public void myclubMgrMemberGrade(){
		
	}
	
	/**
	 * 탈퇴관리
	 */
	@RequestMapping("myclubMgrOutMember")
	public void myclubMgrOutMember(HttpServletRequest req, Model model){
		try {
			ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
			model.addAttribute("list", clubMemberService.listMember(Integer.parseInt(club.getClub_no())));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 클럽폐쇄
	 */
	@RequestMapping("myclubMgrClosing")
	public void myclubMgrClosing(){
		
	}
	
	/**
	 * 클럽양도
	 */
	@RequestMapping("myclubMgrTransfer")
	public void myclubMgrTransfer(){
		
	}
}
