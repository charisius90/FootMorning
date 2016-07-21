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
		
		return "myteam/myteam";
	}
	
	@RequestMapping("/myclub/notice")
	public String notice(Locale locale, Model model) {
		logger.info("공지사항", locale);
		
		return "myteam/myteamNotice/notice_board";
	}
	
	@RequestMapping("/myclub/notice/register")
	public String register(Locale locale, Model model) {
		logger.info("등록", locale);
		
		return "myteam/myteamNotice/notice_post";
	}
	
	@RequestMapping("/myclub/notice/read")
	public String read(Locale locale, Model model) {
		logger.info("등록", locale);
		
		return "myteam/myteamNotice/notice_Read";
	}
}
