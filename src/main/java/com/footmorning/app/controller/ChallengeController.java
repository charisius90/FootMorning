package com.footmorning.app.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.ChallengeDTO;
import com.footmorning.app.service.ChallengeService;

@Controller
public class ChallengeController {
	
	@Inject
	private ChallengeService service;

	@RequestMapping(value="/challenge/register",method=RequestMethod.POST)
	public String ChallengeRegister(ChallengeDTO dto,RedirectAttributes rttr) throws Exception{

		System.out.println(dto.toString());
		service.ChallengeRegister(dto);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/matching/main";
	}
}
