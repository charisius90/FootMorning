package com.footmorning.app.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.domain.MatchDTO;
import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.MainNoticeService;
import com.footmorning.app.service.MatchService;

@Controller
public class MatchingController {
	
	@Inject
	private MatchService service;
	
	@Inject
	private ClubService ClubService;
	
	@Inject
	private MainNoticeService MainNoticeService;
	
	@RequestMapping("/matching/main")
	public String matchingMain(Model model, HttpServletRequest req) throws Exception{
		model.addAttribute("list",service.matchListAll()); 
		
		//클럽목록
		model.addAttribute("club", ClubService.listAll());
		//추천클럽 : 클럽인원수 리스트.
		model.addAttribute("popular", ClubService.popularityListAll());
		//클럽공지사항 : 
		model.addAttribute("notice", MainNoticeService.listAll());
		
		return "/matching/matchingPage";
	}
	
	@RequestMapping(value="/matching/register",method=RequestMethod.GET)
	public String matchingRegisterMove(Model model) throws Exception{
		//클럽목록
		model.addAttribute("club", ClubService.listAll());
		//추천클럽 : 클럽인원수 리스트.
		model.addAttribute("popular", ClubService.popularityListAll());
		//클럽공지사항 : 
		model.addAttribute("notice", MainNoticeService.listAll());
		return"/matching/matchingRegisterPage";
	}
	
	@RequestMapping(value="/matching/register",method=RequestMethod.POST)
	public String matchingRegister(MatchDTO dto, HttpServletRequest req, Model model)  throws Exception{
		service.matchRegister(dto);
		
		WebUtils.setSessionAttribute(req, "MATCH_KEY", service.matchListWithClubNoUnconnect(dto.getClub_no()));
		return"redirect:/matching/main";
	}
	
}
