package com.footmorning.app.controller;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.service.MemberService;

/**
 * 
 * @author ±è¼Ò¿µ
 *
 */
@Controller
@RequestMapping("/mypage/*")
public class MyPageController {
	@Inject
	private MemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
	@RequestMapping("myPageProfile")
	public void mypageProfile(){
	}

	@RequestMapping(value="myPageProfile", method=RequestMethod.POST)
	public String mypageProfileUpdate(MemberDTO member, HttpServletRequest req) {
		logger.info("mypageProfile : " + member.toString());
		service.updateMember(member);
		MemberDTO dto = service.getMemberInfo(member.getMem_email());
		WebUtils.setSessionAttribute(req, "USER_KEY", dto);
		return "redirect:/mypage/myPageProfile";
	}
	
	@RequestMapping("myPageArticles")
	public void mypageArticles(){
	}
	
}
