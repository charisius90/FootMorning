package com.footmorning.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.MemberService;
import com.footmorning.app.util.ClubPageMaker;
import com.footmorning.app.util.SearchClubCriteria;

/**
 * @author 박수항
 */
@Controller
@RequestMapping("/club/*")
public class ClubController {
	@Autowired
	private ClubService service;
	@Autowired
	private MemberService memberService;
	
	// 회원 등급 파이널 변수 모음
	public static final String GRADE_ADMIN = "0"; // 서비스 운영진
	public static final String GRADE_MASTER = "1"; // 클럽마스터
	public static final String GRADE_MANAGER = "2"; // 클럽매니저
	public static final String GRADE_STAFF = "3"; // 클럽스탭
	public static final String GRADE_MEMBER = "4"; // 클럽소속회원
	public static final String GRADE_NORMAL = "5"; // 일반회원
	
	@RequestMapping("clubList")
	public void listGET(SearchClubCriteria clubcri, Model model){
		try {
			model.addAttribute("list", service.listSearchClubCriteria(clubcri));
			
			System.out.println(service.listSearchClubCriteria(clubcri).toString());
			
			ClubPageMaker cpageMaker = new ClubPageMaker();
			
			cpageMaker.setClubCri(clubcri);
			cpageMaker.setTotalCount(service.listSearchClubCount(clubcri));
			
			model.addAttribute("cpageMaker", cpageMaker);
		}
		catch (Exception err) {
			System.out.println("clubListAll : " + err);
		}
		
	}
	
	@RequestMapping("clubRegister")
	public void registerGET(){}
	
	@RequestMapping(value="clubRegister", method=RequestMethod.POST)
	public String registerPOST(ClubDTO dto, String mem_email, Model model, HttpServletRequest req){
		System.out.println("check : " + dto);
		service.insert(dto);

		MemberDTO member = null;
		try {
			member = memberService.getMemberInfo(mem_email);
			member.setMem_grade(GRADE_MASTER);
			memberService.updateMember(member);
			WebUtils.setSessionAttribute(req, "USER_KEY", member);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/myclub/myclubMain?no=" + member.getClub_no();
	}
	
}
