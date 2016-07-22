package com.footmorning.app.controller;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author 김소영
 *
 */
@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Inject
	private MemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("memberLogin")
	public void login(HttpServletRequest req, String LAST_PAGE){
//		WebUtils.setSessionAttribute(req, "LAST_PAGE", LAST_PAGE);
	}

	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public String loginComplete(@Valid MemberDTO member, BindingResult result, HttpServletRequest req) {
//		String LAST_PAGE = (String)WebUtils.getSessionAttribute(req, "LAST_PAGE");
		if(result.hasErrors()){
			return "/member/memberLogin";
		}
		
		try {
			MemberDTO dto = service.getWithPW(member.getMem_email(), member.getMem_pw());
			WebUtils.setSessionAttribute(req, "USER_KEY", dto);
		}
		catch (Exception err) {
			result.reject("login");
			return "/member/memberLogin";
		}
		return "index";
	}
	
	@RequestMapping("memberLogout")
	public String logout(HttpServletRequest req){
		HttpSession session = req.getSession();
		
		// 최종 접속 시간 저장
		MemberDTO dto = (MemberDTO)session.getAttribute("USER_KEY");
		dto.setMem_logdate(service.getTime());
		service.updateMember(dto);
		
		// 로그아웃
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping("memberSignUp")
	public void signup(){}
	
	@RequestMapping(value="memberSignUp", method=RequestMethod.POST)
	public String signupComplete(MemberDTO member, String mem_pw_check, HttpServletRequest req){
		logger.info("signupComplete : " + member.toString() + ", " + mem_pw_check);
		
		if(member.getMem_pw().equals(mem_pw_check)){
			try{
				service.insertMember(member);
			}
			catch(Exception err){
				System.out.println("existing member");
				return "/member/memberSignUp";
			}
			MemberDTO dto = service.getMemberInfo(member.getMem_email());
			WebUtils.setSessionAttribute(req, "USER_KEY", dto);
			return "redirect:/";
		}
		
		return "/member/memberSignUp";
	}
	
	@RequestMapping("memberSearchPW")
	public void searchPW(){
	}
	
	@Autowired
	private MemberValidation valid;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(valid);
	}
}
