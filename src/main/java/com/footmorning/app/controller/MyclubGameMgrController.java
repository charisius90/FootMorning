package com.footmorning.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footmorning.app.domain.MatchDTO;
import com.footmorning.app.service.ChallengeService;
import com.footmorning.app.service.MatchService;

@Controller
public class MyclubGameMgrController {
	
	@Inject
	private ChallengeService service;
	@Inject
	private MatchService service2;
	
	@RequestMapping("/myclubMgr/myclubChallengeMgr")
	public String myclubChallengeMgrMain(Model model, int no) throws Exception{
		model.addAttribute("sendList", service.SendChallengeListAll(no)); 
		model.addAttribute("reciveList", service.ReciveChallengeListAll(no)); 
		
		return "/myclubMgr/myclubChallengeMgr";
	}
	
	// 도전장 수락시
	@RequestMapping(value="/myclubMgr/yesChallenge", method=RequestMethod.POST)
	public String myclubChallengeMgrYes(HttpServletRequest req)  throws Exception{
		int challenge_no = Integer.parseInt(req.getParameter("challenge_no"));
		
		MatchDTO matchDto = new MatchDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		matchDto.setGame_no(Integer.parseInt(req.getParameter("game_no")));
		matchDto.setGame_date(sdf.parse(req.getParameter("game_date")));
		matchDto.setGame_time(req.getParameter("game_time"));
		matchDto.setGame_addr(req.getParameter("game_addr"));
		matchDto.setGame_flag("AWAY");
		matchDto.setClub_no(Integer.parseInt(req.getParameter("club_no")));
		matchDto.setClub_ability(Integer.parseInt(req.getParameter("club_ability")));
		
		System.out.println(matchDto.toString());
		service.yesChallenge(challenge_no);
		service2.matchReciveRegister(matchDto);
		
		req.setAttribute("result", true);
		
		return"/myclubMgr/json/myclubChallengeFlagJson";
	}
	
	// 초대장 수락시
	@RequestMapping(value="/myclubMgr/inviteChallenge", method=RequestMethod.POST)
	public String myclubChallengeMgrInvite(HttpServletRequest req)  throws Exception{
		int challenge_no = Integer.parseInt(req.getParameter("challenge_no"));
		
		MatchDTO matchDto = new MatchDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		matchDto.setGame_no(Integer.parseInt(req.getParameter("game_no")));
		matchDto.setGame_date(sdf.parse(req.getParameter("game_date")));
		matchDto.setGame_time(req.getParameter("game_time"));
		matchDto.setGame_addr(req.getParameter("game_addr"));
		matchDto.setGame_flag("INVITE");
		matchDto.setClub_no(Integer.parseInt(req.getParameter("club_no")));
		matchDto.setClub_ability(Integer.parseInt(req.getParameter("club_ability")));
		
		System.out.println(matchDto.toString());
		service.yesChallenge(challenge_no);
		service2.matchReciveRegister(matchDto);
		
		req.setAttribute("result", true);
		
		return"/myclubMgr/json/myclubChallengeFlagJson";
	}
	
	// 도전장 거절시
	@RequestMapping(value="/myclubMgr/noChallenge", method=RequestMethod.POST)
	public String myclubChallengeMgrNo(HttpServletRequest req)  throws Exception{
		int challenge_no = Integer.parseInt(req.getParameter("challenge_no"));
		
		req.setAttribute("result", service.noChallenge(challenge_no));
		
		return"/myclubMgr/json/myclubChallengeFlagJson";
	}
}
