package com.footmorning.app.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footmorning.app.domain.MatchDTO;
import com.footmorning.app.service.MatchService;

@Controller
public class MatchingController {
	
	@Inject
	private MatchService service;
	
	@RequestMapping("/matching/main")
	public String matchingMain(Model model) throws Exception{
		
		model.addAttribute("list",service.matchListAll()); 
		
		return "/matching/matchingPage";
	}
	
	@RequestMapping(value="/matching/register",method=RequestMethod.GET)
	public String matchingRegisterMove(){
		System.out.println("이동성공");
		return"/matching/matchingRegisterPage";
	}
	
	@RequestMapping(value="/matching/register",method=RequestMethod.POST)
	public String matchingRegister(MatchDTO dto, HttpServletRequest req,Model model){
//		System.out.println(dto.toString());
		try {
			service.matchRegister(dto);
		} catch (Exception e) {
			System.out.println("matchingfailed...");
		}
		
		return"redirect:/matching/main";
	}
}
