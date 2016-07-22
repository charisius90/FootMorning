package com.footmorning.app.controller;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footmorning.app.domain.MemberDTO;

/**
 * 
 * @author ±è¼Ò¿µ
 *
 */
@Controller
@RequestMapping("/mypage/*")
public class MyPageController {
	/*@Inject
	private MypageService service;*/
	
	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
	@RequestMapping("myPageProfile")
	public void mypageProfile(){
	}

	@RequestMapping(value="myPageProfile", method=RequestMethod.POST)
	public String mypageProfileUpdate(MemberDTO member) {
		return "redirect:/mypage/myPageProfile";
	}
	
	@RequestMapping("myPageArticles")
	public void mypageArticles(){
	}
	
}
