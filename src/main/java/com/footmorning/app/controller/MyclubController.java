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
import org.springframework.web.util.WebUtils;

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
	public void myclubMain(HttpServletRequest req, Model model, int no) throws NumberFormatException, Exception{
		MemberDTO memberDto = (MemberDTO)WebUtils.getSessionAttribute(req, "USER_KEY");
		
		ClubDTO club = service.getWithNo(no);
		MemberDTO master = memberService.getWithNo(Integer.parseInt(club.getClub_master()));
		
		WebUtils.setSessionAttribute(req, "CLUB_KEY", club);
		model.addAttribute("MASTER", master);
	}
	
	@RequestMapping("myclubRecord")
	public void myclubRecord(){
		
	}
	
	@RequestMapping("myclubCashBook")
	public void myclubCashBook(){
		
	}
}
