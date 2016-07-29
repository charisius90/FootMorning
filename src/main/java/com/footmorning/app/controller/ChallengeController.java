package com.footmorning.app.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footmorning.app.domain.ChallengeDTO;
import com.footmorning.app.service.ChallengeService;

@Controller
public class ChallengeController {
	
	@Inject
	private ChallengeService service;

	@RequestMapping(value="/challenge/register",method=RequestMethod.POST)
	public String ChallengeRegister(ChallengeDTO dto,HttpServletRequest req,Model model) throws Exception{
		
//		ChallengeDTO dto =new ChallengeDTO();
//		dto.setSender_club_no(Integer.parseInt(req.getParameter("sender_club_no")));
//		dto.setReceiver_club_no(Integer.parseInt(req.getParameter("receiver_club_no")));
//		dto.setChallenge_content(req.getParameter("challenge_content"));
//		dto.setGame_no(Integer.parseInt(req.getParameter("game_no")));
//		dto.setGame_flag(req.getParameter("game_flag"));
//		dto.setClub_ability(Integer.parseInt(req.getParameter("club_ability")));
		System.out.println(dto.toString());
		service.ChallengRegister(dto);
		return "redirect:/matching/main";
	}
}
