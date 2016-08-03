package com.footmorning.app.controller;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.MatchService;
import com.footmorning.app.service.MemberService;
import com.footmorning.app.util.Email;
import com.footmorning.app.util.EmailSender;
import com.footmorning.app.util.MemberValidation;

/**
 * 
 * @author 김소영, 박수항
 *
 */
@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Inject
	private MemberService service;
	
	@Inject
	private ClubService clubService;
	
	@Inject
	private MatchService matchService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("memberLogin")
	public void login(HttpServletRequest req){}

	@RequestMapping("memberLoginSuccess")
	public String loginSuccess(@Valid MemberDTO member, BindingResult result, HttpServletRequest req) {
		try {
			String email = SecurityContextHolder.getContext().getAuthentication().getName();
			
			MemberDTO dto = service.getMemberInfo(email);
			
			WebUtils.setSessionAttribute(req, "USER_KEY", dto);
			
			if(dto.getClub_no() != null){
				int club_no = Integer.parseInt(dto.getClub_no());
				WebUtils.setSessionAttribute(req, "CLUB_KEY", clubService.getWithNo(club_no));
				WebUtils.setSessionAttribute(req, "MATCH_KEY", matchService.matchListWithClubNoUnconnect(club_no));
			}
			
			// 최종 접속 시간 업데이트
			dto.setMem_logdate(service.getTime());
			service.updateMember(dto);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping("memberLoginFailure")
	public String loginFailure(@Valid MemberDTO member, BindingResult result, HttpServletRequest req) {
		if(result.hasErrors()){
			return "/member/memberLogin";
		}

		result.reject("login");
		return "/member/memberLogin";
	}
	
//	@RequestMapping("memberLogout")
//	public String logout(HttpServletRequest req){
//		// 세션 닫기
//		HttpSession session = req.getSession();
//		session.invalidate();
//		
//		return "redirect:/";
//	}
	
	@RequestMapping("memberSignUp")
	public void signup(){}
	
	@RequestMapping(value="memberSignUp", method=RequestMethod.POST)
	public String signupComplete(MemberDTO member, String mem_pw_check, HttpServletRequest req){
//	public String signupComplete(@Valid MemberDTO member, BindingResult result, String mem_pw_check, HttpServletRequest req){
		logger.info("signupComplete : " + member.toString() + ", " + mem_pw_check);
		if(member.getMem_pw().equals(mem_pw_check)){
			try{
				service.insertMember(member);
			}
			catch(Exception err){
				System.out.println("MemberController signupComplete : " + err);
				return "/member/memberSignUp";
			}
			
			try {
				MemberDTO dto = service.getMemberInfo(member.getMem_email());
				WebUtils.setSessionAttribute(req, "USER_KEY", dto);
			}
			catch (Exception e) {
				e.printStackTrace();
				return "/member/memberSignUp";
			}
			return "redirect:/";
		}
		
		return "/member/memberSignUp";
	}
	
	@RequestMapping("memberSearchPW")
	public void searchPW(){
	}
	
	/**
	 * 비밀번호 찾기 페이지(임시비밀번호 생성 후 이메일 전송)
	 * @author 김소영
	 */
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private Email email;

	@RequestMapping(value="memberSearchPW", method=RequestMethod.POST)
	public ModelAndView sendEmail(MemberDTO dto, ModelMap model) throws Exception {
	    ModelAndView mav;
        String mem_email = dto.getMem_email();
        String mem_phone = dto.getMem_phone();
        
        if(service.getPW(mem_email, mem_phone) != null) {
        	// 임시비밀번호 생성(영문+숫자 8자리 조합)
        	String mem_pw_new = RandomStringUtils.randomAlphanumeric(8);
        	// 임시비밀번호로 DB수정
        	MemberDTO member = service.getMemberInfo(mem_email);
        	member.setMem_pw(mem_pw_new);
        	service.updateMember(member);
        	String mem_name = member.getMem_name();
        	// 이메일 발송
            email.setContent("임시비밀번호는 "+mem_pw_new+" 입니다.");
            email.setReceiver(mem_email);
            email.setSubject(mem_name + "님 비밀번호 찾기 메일입니다.");
            emailSender.SendEmail(email);
            
            mav= new ModelAndView("redirect:/member/memberLogin");
            return mav;
        }else {
            mav=new ModelAndView("redirect:/member/memberLogin");
            return mav;
        }
	}
	
	@Autowired
	private MemberValidation valid;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(valid);
	}
}
