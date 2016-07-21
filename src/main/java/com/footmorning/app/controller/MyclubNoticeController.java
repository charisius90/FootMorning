package com.footmorning.app.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyclubNoticeController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/myclub/main")
	public String home(Locale locale, Model model) {
		logger.info("메인", locale);
		
		return "myclub/myclubMain";
	}
	
	@RequestMapping("/myclub/notice/main")
	public String notice(Locale locale, Model model) {
		logger.info("공지사항", locale);
		
		return "/myclub/myclubNotice/myclubNoticeBoardMain";
	}
	
	@RequestMapping(value="/myclub/notice/register", method=RequestMethod.GET)
	public String register(Locale locale, Model model) {
		logger.info("등록", locale);
		
		return "myclub/myclubNotice/myclubNoticeBoardRegister";
	}
	
	@RequestMapping(value="/myclub/notice/register", method=RequestMethod.POST)
	public String registerComplete(Locale locale, Model model) {
		logger.info("등록", locale);
		
		return "myclub/myclubNotice/myclubNoticeBoardMain";
	}
	
	@RequestMapping("/myclub/notice/read")
	public String read(Locale locale, Model model) {
		logger.info("읽기", locale);
		
		return "myclub/myclubNotice/myclubNoticeBoardRead";
	}
	
	@RequestMapping(value="/myclub/notice/update", method=RequestMethod.GET)
	public String update(Locale locale, Model model) {
		logger.info("수정", locale);
		
		return "myclub/myclubNotice/myclubNoticeBoardUpdate";
	}
	
	@RequestMapping(value="/myclub/notice/update", method=RequestMethod.POST)
	public String updateComplete(Locale locale, Model model) {
		logger.info("수정", locale);
		
		return "myclub/myclubNotice/myclubNoticeBoardMain";
	}
	
	@RequestMapping("/myclub/notice/delete")
	public String delete(Locale locale, Model model) {
		logger.info("삭제", locale);
		
		return "myclub/myclubNotice/myclubNoticeBoardMain";
	}
	
	
}
