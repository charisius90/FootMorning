package com.footmorning.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.MemberService;

/**
 * 
 * @author 김소영
 *
 */
@Controller
@RequestMapping("/myclub/*")
public class MyclubController {
	@Autowired
	private ClubService service;
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MyclubController.class);
	
	@RequestMapping("myclubMain")
	public void myclubMain(HttpServletRequest req, Model model) throws NumberFormatException, Exception{
		HttpSession session = req.getSession();
		MemberDTO memberDto = (MemberDTO) session.getAttribute("USER_KEY");
		
		// 클럽번호로 클럽정보 가져오기
		int club_no = Integer.parseInt(memberDto.getClub_no());
		ClubDTO myclubDto = service.getWithNo(club_no);
		// 클럽장의 이름 
		MemberDTO masterDto = memberService.getWithNo(Integer.parseInt(myclubDto.getClub_master()));
		String club_master_name = masterDto.getMem_name();
		// 클럽회원수
		int club_member_count = memberService.getWithClubno(club_no);
		
		model.addAttribute("myclubDto", myclubDto);
		model.addAttribute("club_member_count", club_member_count);
		model.addAttribute("club_master_name", club_master_name);
	}
	
	@RequestMapping("myclubRecord")
	public void myclubRecord(){
		
	}
	
	@RequestMapping("myclubCashBook")
	public void myclubCashBook(){
		
	}
}
