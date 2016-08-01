package com.footmorning.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.footmorning.app.domain.ClubConfigDTO;
import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.domain.ClubMemberDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.service.ClubConfigService;
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
	private ClubConfigService clubConfigService;
	@Autowired
	private MemberService memberService;

	/**
	 * 회원 등급 파이널 변수 모음
	 * @Author 박수항
	 */
	public static final String GRADE_ADMIN = "0"; // 서비스 운영진
	public static final String GRADE_MASTER = "1"; // 클럽마스터
	public static final String GRADE_MANAGER = "2"; // 클럽매니저
	public static final String GRADE_STAFF = "3"; // 클럽스탭
	public static final String GRADE_MEMBER = "4"; // 클럽소속회원
	public static final String GRADE_NORMAL = "5"; // 일반회원
	
	/**
	 * 회원 가입신청 조건 파이널 변수 모음
	 * @Author 박수항
	 */
	public static final String CONFIG_REJECT_FROM_TRUE = "1000-01-01"; // 항상 허용
	public static final String CONFIG_REJECT_TO_TRUE = "1000-01-01"; // 항상 허용
	public static final String CONFIG_REJECT_FROM_FALSE = "1000-01-01"; // 항상 거부
	public static final String CONFIG_REJECT_TO_FALSE = "9999-12-31"; // 항상 거부
	public static final String CONFIG_BIRTH_FROM_ALL = "1000-01-01"; // 모든 연령 허용
	public static final String CONFIG_BIRTH_TO_ALL = "9999-12-31"; // 모든 연령 허용
	
	
	/**
	 * 클럽 가입신청 파이널 변수
	 * @Author 박수항
	 */
	public static final String CLUB_MEM_FLAG_DEFAULT = "FALSE"; // 이게 가입 신청서라는 표시를 하는 플래그
	/**
	 * @Author 박수항
	 * 가입신청 테스트용(컨트롤러 위치 변경해야함)
	 */
	@RequestMapping(value="clubRequest", method=RequestMethod.POST)
	public String requestPOST(ClubMemberDTO dto){
		System.out.println(dto);
		dto.setClub_mem_flag(CLUB_MEM_FLAG_DEFAULT);
		clubMemberService.insert(dto);
		return "redirect:/myclub/myclubMain?no=" + dto.getClub_no();
	}
	
	/**
	 * 기본정보 변경 페이지
	 * @Author 박수항
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
	 * @Author 박수항
	 */
	@RequestMapping("myclubMgrJoinCondition")
	public void myclubMgrJoinCondition(HttpServletRequest req, Model model){
		try {
			ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
			model.addAttribute("CONFIG", clubConfigService.getWithClubNo(Integer.parseInt(club.getClub_no())));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="myclubMgrJoinCondition", method=RequestMethod.POST)
	public String myclubMgrJoinConditionComplete(HttpServletRequest req, ClubConfigDTO config, String sign, String age){
		sign =  sign.toUpperCase();
		if(sign.equals("TRUE")){
			config.setConfig_reject_from(CONFIG_REJECT_FROM_TRUE);
			config.setConfig_reject_to(CONFIG_REJECT_TO_TRUE);
		}
		else if(sign.equals("FALSE")){
			config.setConfig_reject_from(CONFIG_REJECT_FROM_FALSE);
			config.setConfig_reject_to(CONFIG_REJECT_TO_FALSE);
		}
		
		if(age.toUpperCase().equals("ALL")){
			config.setConfig_birth_from(CONFIG_BIRTH_FROM_ALL);
			config.setConfig_birth_to(CONFIG_BIRTH_TO_ALL);
		}
		
		clubConfigService.update(config);
		return "redirect:/myclubMgr/myclubMgrJoinCondition";
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
	 * @Author 김소영, 박수항
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
	 * @Author 김소영
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
	 * @Author 김소영
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
	
	@RequestMapping(value="myclubMgrOutMember", method=RequestMethod.POST)
	public String myclubMgrOutMemberComplete(@RequestParam(value="mem_no") List<String> memberList, RedirectAttributes rttr){
		for(String mem_no : memberList){
			try{
				ClubMemberDTO clubMember = clubMemberService.getWithMemno(Integer.parseInt(mem_no));
				clubMemberService.delete(clubMember);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		rttr.addFlashAttribute("data", memberList.size());

		return "redirect:/myclubMgr/myclubMgrOutMember";
	}
	
	/**
	 * 클럽폐쇄
	 * @Author 김소영
	 */
	@RequestMapping("myclubMgrClosing")
	public void myclubMgrClosing(){}
	
	@RequestMapping(value="myclubMgrClosing", method=RequestMethod.POST)
	public String myclubMgrClosingComplete(HttpServletRequest req, Model model){
		try{
			ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
			service.delete(Integer.parseInt((club.getClub_no())));
			HttpSession session = req.getSession();
			session.removeAttribute("CLUB_KEY");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	/**
	 * 클럽양도
	 */
	@RequestMapping("myclubMgrTransfer")
	public void myclubMgrTransfer(HttpServletRequest req, Model model){
		try {
			ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
			model.addAttribute("list", clubMemberService.listMember(Integer.parseInt(club.getClub_no())));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="myclubMgrTransfer", method=RequestMethod.POST)
	public String myclubMgrTransferComplete(){
		return "redirect:/myclubMgr/myclubMgrTransfer";
	}
}
