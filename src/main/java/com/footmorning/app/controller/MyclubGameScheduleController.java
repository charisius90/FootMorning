package com.footmorning.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
public class MyclubGameScheduleController {
	
	@Inject
	private MatchService service;
	
	@RequestMapping("/myclub/myclubGameSchedule")
	public String myclubGameSchedule(Model model, int club_no) throws Exception{
		System.out.println("클럽번호: " + club_no);
//		model.addAttribute("myList", service.myMatchListWithClubNo(club_no)); 
//		model.addAttribute("yourList", service.yourMatchListWithClubNo(club_no)); 
		
		model.addAttribute("list", service.matchListWithClubNo(club_no));
		
		List<MatchDTO> list = service.matchListWithClubNo(club_no);
		System.out.println("리스트 받아옴");
		for(int i=0; i<list.size(); i++){
			System.out.println(i+"번쨰 : " +list.get(i).toString());
		}
		return "/myclub/myclubGameSchedule";
	}
	
	@RequestMapping("/myclub/myclubCancleGame")
	public String myclubCancleGame(HttpServletRequest req) throws Exception{
		int game_no = Integer.parseInt(req.getParameter("game_no"));
		System.out.println("게임번호: " + game_no);
		
		service.matchDelete(game_no);
		req.setAttribute("result", true);
		
		return "/myclub/json/myclubCancleGameJson";
	}
}
