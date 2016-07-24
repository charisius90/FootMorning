package com.footmorning.app.controller;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
 * @author 김소영
 *
 */
@Controller
@RequestMapping("/mypage/*")
public class MyPageController {
	@Inject
	private MemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
	@RequestMapping("myPageProfile")
	public void myPageProfile(){
	}

	@RequestMapping(value="myPageProfile", method=RequestMethod.POST)
	public String myPageProfileUpdate(MemberDTO member, HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		MemberDTO dto = (MemberDTO)session.getAttribute("USER_KEY");
		dto.setMem_name(member.getMem_name());
		dto.setMem_birth(member.getMem_birth());
		dto.setMem_gender(member.getMem_gender());
		dto.setMem_phone(member.getMem_phone());
		dto.setMem_addr(member.getMem_addr());
		
		service.updateMember(dto);
		logger.info("mypageProfileUpdate : " + dto.toString());
		
		return "redirect:/mypage/myPageProfile";
	}
	
	@RequestMapping("myPageArticles")
	public void myPageArticles(){
	}
	
	@RequestMapping("myPagePW")
	public void myPagePW(){
	}
	
	@RequestMapping(value="myPagePW", method=RequestMethod.POST)
	public String myPagePwUpdate(String mem_oldPw, String mem_newPw, String mem_newPw_check, HttpServletRequest req){
		HttpSession session = req.getSession();
		
		MemberDTO dto = (MemberDTO)session.getAttribute("USER_KEY");
		if(mem_oldPw.equals(dto.getMem_pw())){
			if(mem_newPw.equals(mem_newPw_check)){
				dto.setMem_pw(mem_newPw);
				service.updateMember(dto);
				session.invalidate();
				logger.info("myPagePwUpdate : " + dto.getMem_pw());
				return "redirect:/member/memberLogin";
			}
			else{
				System.out.println("새 비밀번호를 확인하세요.");
				return "/mypage/myPagePW";
			}
		}
		System.out.println("현재 비밀번호가 틀렸습니다.");
		return "/mypage/myPagePW";
	}
	
}
