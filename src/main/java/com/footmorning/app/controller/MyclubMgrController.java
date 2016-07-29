package com.footmorning.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

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
	
	/**
	 * 클럽대문관리
	 */
	@RequestMapping("myclubMgrMain")
	public void myclubMgrMain(){
		
	}
	
	/**
	 * 클럽메뉴관리
	 */
	@RequestMapping("myclubMgrMenu")
	public void myclubMgrMenu(){
		
	}
	
	/**
	 * 클럽멤버관리
	 */
	@RequestMapping("myclubMgrMember")
	public void myclubMgrMember(){
		
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
		if(type.equals("approval")){
			for(String mem_no : memberList){
				try{
					ClubMemberDTO clubMember = clubMemberService.getWithMemno(Integer.parseInt(mem_no));
					clubMember.setClub_mem_flag("TRUE");
		            clubMemberService.update(clubMember);
				}
				catch(Exception e){
					 e.printStackTrace();
				}
			}
		}
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
	 * 탈퇴멤버관리
	 */
	@RequestMapping("myclubMgrOutMember")
	public void myclubMgrOutMember(){
		
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
