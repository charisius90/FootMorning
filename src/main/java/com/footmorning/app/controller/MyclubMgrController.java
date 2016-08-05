package com.footmorning.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.footmorning.app.domain.ClubAuthDTO;
import com.footmorning.app.domain.ClubConfigDTO;
import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.domain.ClubMemberDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.service.ClubAuthService;
import com.footmorning.app.service.ClubConfigService;
import com.footmorning.app.service.ClubMemberService;
import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.MemberService;
import com.footmorning.app.util.ClubCriteria;
import com.footmorning.app.util.ClubPageMaker;
import com.footmorning.app.util.PageMaker;
import com.footmorning.app.util.SearchClubCriteria;
import com.footmorning.app.util.SearchCriteria;

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
	@Autowired
	private ClubAuthService clubAuthService;

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
			MultipartFile uploadfile = dto.getUploadfile();
			String root = req.getSession().getServletContext().getRealPath("/");
			String savePath = root + "resources/upload/";
			String originalFileName = null;
			String storedFileName = null;
			
			File file = new File(savePath);
			if(file.exists() == false){
				file.mkdirs();
			}
			
			if(uploadfile!=null){
				originalFileName = uploadfile.getOriginalFilename();
				storedFileName = System.currentTimeMillis() + "_" + originalFileName;
				
				file = new File(savePath + storedFileName);
				try {
					uploadfile.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dto.setClub_image(file.getName());
			}
			else{
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
	public void myclubMgrMember(SearchClubCriteria clubcri, HttpServletRequest req, Model model){
		try {
			ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
			
			clubcri.setClub_no(club.getClub_no());
			model.addAttribute("list", clubMemberService.listSearchClubMemberCriteria(clubcri));
			
			ClubPageMaker cpageMaker = new ClubPageMaker();
			cpageMaker.setClubcri(clubcri);
			cpageMaker.setTotalCount(clubMemberService.listSearchClubMemberCount(clubcri));
			
			model.addAttribute("pageMaker", cpageMaker);
			
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
	public void myclubMgrRegister(SearchClubCriteria clubcri, HttpServletRequest req, Model model){
		try {
			ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
			
			System.out.println(clubcri.toString());
			
			clubcri.setClub_no(club.getClub_no());
			model.addAttribute("req", clubMemberService.listClubRequest(clubcri));
			
			System.out.println("가입신청자 : "+clubMemberService.listClubRequest(clubcri));
			
			ClubPageMaker cpageMaker = new ClubPageMaker();
			cpageMaker.setClubcri(clubcri);
			cpageMaker.setTotalCount(clubMemberService.listClubRequestCount(clubcri));
			
			model.addAttribute("pageMaker", cpageMaker);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="myclubMgrRegister", method=RequestMethod.POST)
	public String myclubMgrRegisterComplete(@RequestParam(value="mem_no") List<String> memberList, String type, Model model, HttpServletRequest req){
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
		            member.setMem_club_regdate(memberService.getTime());
		            memberService.updateMember(member);
		            
		            // 클럽테이블에 클럽회원수+1
		            ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
		            club.setClub_mem_count(Integer.toString((Integer.parseInt((club.getClub_mem_count()))+1)));
		            service.update(club);
		            WebUtils.setSessionAttribute(req, "CLUB_KEY", club);
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
	public void myclubMgrMemberGrade(HttpServletRequest req, Model model){
		try {
			int no = Integer.parseInt(((ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY")).getClub_no());
			Map<String, ClubAuthDTO> map = new HashMap<>();
			map.put("AUTH_MASTER", clubAuthService.getAuthMaster(no));
			map.put("AUTH_MGR", clubAuthService.getAuthMgr(no));
			map.put("AUTH_STAFF", clubAuthService.getAuthStaff(no));
			map.put("AUTH_MEMBER", clubAuthService.getAuthMember(no));
			map.put("AUTH_USER", clubAuthService.getAuthUser(no));
			model.addAllAttributes(map);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="myclubMgrMemberGrade", method=RequestMethod.POST)
	public @ResponseBody String myclubMgrMemberGradeComplete(@RequestBody List<Map<String, Object>> list, int no){
		
		try {
			ClubAuthDTO masterAuth = clubAuthService.getAuthMaster(no);
			ClubAuthDTO mgrAuth = clubAuthService.getAuthMgr(no);
			ClubAuthDTO staffAuth = clubAuthService.getAuthStaff(no);
			ClubAuthDTO memberAuth = clubAuthService.getAuthMember(no);
			ClubAuthDTO userAuth = clubAuthService.getAuthUser(no);
			
			int index = 0;
			for(Map<String, Object> map : list){
				switch(index){
				case 0:
					masterAuth.setAuth_access(((Integer)map.get("auth_access")).toString());
					masterAuth.setAuth_cash(((Integer)map.get("auth_cash")).toString());
					masterAuth.setAuth_club(((Integer)map.get("auth_club")).toString());
					masterAuth.setAuth_info(((Integer)map.get("auth_info")).toString());
					masterAuth.setAuth_member(((Integer)map.get("auth_member")).toString());
					masterAuth.setAuth_mod(((Integer)map.get("auth_mod")).toString());
					break;
				case 1:
					mgrAuth.setAuth_access(((Integer)map.get("auth_access")).toString());
					mgrAuth.setAuth_cash(((Integer)map.get("auth_cash")).toString());
					mgrAuth.setAuth_club(((Integer)map.get("auth_club")).toString());
					mgrAuth.setAuth_info(((Integer)map.get("auth_info")).toString());
					mgrAuth.setAuth_member(((Integer)map.get("auth_member")).toString());
					mgrAuth.setAuth_mod(((Integer)map.get("auth_mod")).toString());
					break;
				case 2:
					staffAuth.setAuth_access(((Integer)map.get("auth_access")).toString());
					staffAuth.setAuth_cash(((Integer)map.get("auth_cash")).toString());
					staffAuth.setAuth_club(((Integer)map.get("auth_club")).toString());
					staffAuth.setAuth_info(((Integer)map.get("auth_info")).toString());
					staffAuth.setAuth_member(((Integer)map.get("auth_member")).toString());
					staffAuth.setAuth_mod(((Integer)map.get("auth_mod")).toString());
					break;
				case 3:
					memberAuth.setAuth_access(((Integer)map.get("auth_access")).toString());
					memberAuth.setAuth_cash(((Integer)map.get("auth_cash")).toString());
					memberAuth.setAuth_club(((Integer)map.get("auth_club")).toString());
					memberAuth.setAuth_info(((Integer)map.get("auth_info")).toString());
					memberAuth.setAuth_member(((Integer)map.get("auth_member")).toString());
					memberAuth.setAuth_mod(((Integer)map.get("auth_mod")).toString());
					break;
				case 4:
					userAuth.setAuth_mod(((Integer)map.get("auth_mod")).toString());
					break;
				}
				index++;
			}
			
			clubAuthService.update(masterAuth);
			clubAuthService.update(mgrAuth);
			clubAuthService.update(staffAuth);
			clubAuthService.update(memberAuth);
			clubAuthService.update(userAuth);
			
			return "SUCCESS";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "FAILURE";
		}
	}
	
	/**
	 * 탈퇴관리
	 * @Author 김소영
	 */
	@RequestMapping("myclubMgrOutMember")
	public void myclubMgrOutMember(SearchClubCriteria clubcri, HttpServletRequest req, Model model){
		try {
			ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
			
			clubcri.setClub_no(club.getClub_no());
			model.addAttribute("list", clubMemberService.listSearchClubMemberCriteria(clubcri));
			
			ClubPageMaker cpageMaker = new ClubPageMaker();
			cpageMaker.setClubcri(clubcri);
			cpageMaker.setTotalCount(clubMemberService.listSearchClubMemberCount(clubcri));
			
			model.addAttribute("pageMaker", cpageMaker);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="myclubMgrOutMember", method=RequestMethod.POST)
	public String myclubMgrOutMemberComplete(@RequestParam(value="mem_no") List<String> memberList, RedirectAttributes rttr, HttpServletRequest req){
		for(String mem_no : memberList){
			try{
				// 클럽멤버테이블에서 삭제
				ClubMemberDTO clubMember = clubMemberService.getWithMemno(Integer.parseInt(mem_no));
				clubMemberService.delete(clubMember);
				
				// 멤버테이블에서 클럽번호와 클럽가입일 삭제, 회원등급 수정
				MemberDTO member = memberService.getWithNo(Integer.parseInt((mem_no)));
				member.setClub_no(null);
				member.setMem_grade(GRADE_NORMAL);
				member.setMem_club_regdate(null);
				memberService.updateMember(member);
				
				// 클럽테이블에 클럽회원수-1
				ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
	            club.setClub_mem_count(Integer.toString((Integer.parseInt((club.getClub_mem_count()))-1)));
	            service.update(club);
	            WebUtils.setSessionAttribute(req, "CLUB_KEY", club);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		// 삭제된 인원수 반환
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
	public String myclubMgrClosingComplete(String club_name, String mem_email, String mem_pw, HttpServletRequest req, RedirectAttributes rttr){
		try{
			HttpSession session = req.getSession();
			ClubDTO club = (ClubDTO)session.getAttribute("CLUB_KEY");
			MemberDTO member = memberService.getWithPW(mem_email, mem_pw);
			
			// 클럽명이 맞는지 확인
			if(club.getClub_name().equals(club_name)){
				// 입력한 정보와 관리자의 정보가 일치하지 않을 경우
				if(member == null || !(club.getClub_master().equals(member.getMem_no()))){
					rttr.addFlashAttribute("msg", "관리자 E-Mail 또는 비밀번호가 일치하지 않습니다.");
				}
				// 입력한 정보가 일치할 경우 클럽 폐쇄
				else{
					// 클럽테이블에서 삭제, 세션에 저장된 클럽키도 삭제
					service.delete(Integer.parseInt((club.getClub_no())));
					session.removeAttribute("CLUB_KEY");
					
					MemberDTO newMemInfo = memberService.getMemberInfo(mem_email);
					WebUtils.setSessionAttribute(req, "USER_KEY", newMemInfo);
					
					rttr.addFlashAttribute("msg", "클럽이 폐쇄되었습니다.");
					return "redirect:/";
				}
			}
			// 클럽명이 다른 경우
			else{
				rttr.addFlashAttribute("msg", "클럽명이 일치하지 않습니다.");
			}
		}
		catch(Exception e){
			rttr.addFlashAttribute("msg", "관리자 E-Mail 또는 비밀번호가 일치하지 않습니다.");
		}
		return "redirect:/myclubMgr/myclubMgrClosing";
	}
	
	/**
	 * 클럽양도
	 * @Author 김소영
	 */
	@RequestMapping("myclubMgrTransfer")
	public void myclubMgrTransfer(SearchClubCriteria clubcri,HttpServletRequest req, Model model){
		try {
			ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
			
			clubcri.setClub_no(club.getClub_no());
			model.addAttribute("list", clubMemberService.listSearchClubMemberCriteria(clubcri));
			
			ClubPageMaker cpageMaker = new ClubPageMaker();
			cpageMaker.setClubcri(clubcri);
			cpageMaker.setTotalCount(clubMemberService.listSearchClubMemberCount(clubcri));
			
			model.addAttribute("pageMaker", cpageMaker);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="myclubMgrTransfer", method=RequestMethod.POST)
	public String myclubMgrTransferComplete(String mem_no , RedirectAttributes rttr, HttpServletRequest req){
		try{
			// 선택된 회원에게 마스터 등급 부여
			ClubMemberDTO clubMember = clubMemberService.getWithMemno(Integer.parseInt((mem_no)));
			clubMember.setMem_grade(GRADE_MASTER);
			clubMemberService.update(clubMember);
			
			MemberDTO newMasterInfo = memberService.getWithNo(Integer.parseInt((clubMember.getMem_no())));
			newMasterInfo.setMem_grade(GRADE_MASTER);
			memberService.updateMember(newMasterInfo);
			
			// 클럽테이블의 마스터 정보에 선택된 회원의 회원번호와 이름으로 수정 
			ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
			club.setClub_master(clubMember.getMem_no());
			club.setClub_master_name(clubMember.getMem_name());
			service.update(club);
			WebUtils.setSessionAttribute(req, "CLUB_KEY", club);

			// 기존 마스터의 회원등급을 클럽소속회원으로 수정
			MemberDTO oldMasterInfo = (MemberDTO)WebUtils.getSessionAttribute(req, "USER_KEY");
			oldMasterInfo.setMem_grade(GRADE_MEMBER);
			memberService.updateMember(oldMasterInfo);
			WebUtils.setSessionAttribute(req, "USER_KEY", oldMasterInfo);
			
			ClubMemberDTO dto = clubMemberService.getWithMemno(Integer.parseInt((oldMasterInfo.getMem_no())));
			dto.setMem_grade(GRADE_MEMBER);
			clubMemberService.update(dto);
			
			rttr.addFlashAttribute("msg", "클럽이 양도되었습니다.");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/myclubMgr/myclubMgrTransfer";
	}
}
