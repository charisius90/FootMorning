package com.footmorning.app.controller;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.service.MemberService;
import com.footmorning.app.util.MemberValidation;

/**
 * 
 * @author ±è¼Ò¿µ
 *
 */

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Inject
	private MemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/memberLogin")
	public void login(){
	}

	@RequestMapping(value="/memberLogin", method=RequestMethod.POST)
	public String loginComplete(@Valid MemberDTO dto, BindingResult result, HttpServletRequest req) {
		return "index";
	}
	
	@RequestMapping("/memberLogout")
	public String logout(HttpServletRequest req){
		req.getSession().invalidate();
		return "index";
	}
	
	@RequestMapping("/memberSignUp")
	public void signup(){
	}
	
	@RequestMapping(value="/memberSignUp", method=RequestMethod.POST)
	public String signupComplete(){
		return "index";
	}
	
	@RequestMapping("/memberSearchID")
	public void searchID(){
	}
	
	@RequestMapping("/memberSearchPW")
	public void searchPW(){
	}
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(new MemberValidation());
	}
}
