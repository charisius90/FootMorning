package com.footmorning.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.MemberService;

@Controller
@RequestMapping("/club/*")
public class ClubController {
	@Autowired
	private ClubService service;
	@Autowired
	private MemberService memberService;
	
	public static final String GRADE_ADMIN = "0";
	public static final String GRADE_MASTER = "1";
	public static final String GRADE_MANAGER = "2";
	public static final String GRADE_STAFF = "3";
	public static final String GRADE_NORMAL = "4";
	
	@RequestMapping("clubList")
	public void listGET(Model model){
		try {
			model.addAttribute("list", service.listAll());
		}
		catch (Exception err) {
			System.out.println("clubListAll : " + err);
		}
	}
	
	@RequestMapping("clubRegister")
	public void registerGET(){}
	
	@RequestMapping(value="clubRegister", method=RequestMethod.POST)
	public String registerPOST(ClubDTO dto, String mem_email, Model model){
		System.out.println("check : " + dto);
		service.insert(dto);
		
		// 클럽 등록자 회원등급은 클럽마스터로 변경
		try {
			MemberDTO member = memberService.getMemberInfo(mem_email);
			member.setMem_grade(GRADE_MASTER);
			memberService.updateMember(member);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Map<String, String> map = new HashMap<>();
//		map.put("mem_email", mem_email);
//		map.put("club_name", dto.getName());
//		rttr.addFlashAttribute("data", map);
//		model.addAllAttributes(map);
		return "redirect:/club/clubList";
	}
	
//	@RequestMapping("registerSuccess")
//	public String registerSuccess(String club_name, String mem_email, String data){
//		try {
//			System.out.println("1 : " + club_name + " / 2 : " + mem_email + ", " + data);
//			ClubDTO clubDTO = service.getClubInfo(club_name);
//			System.out.println("clubDTO : " + clubDTO);
//			MemberDTO memberDTO = memberService.getMemberInfo(mem_email);
//			memberDTO.setClub_no(clubDTO.getNo());
//			memberDTO.setMem_grade(GRADE_MASTER);
//			memberService.updateMember(memberDTO);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			return "/club/clubRegister";
//		}
//		return "/club/clubList";
//	}
}
