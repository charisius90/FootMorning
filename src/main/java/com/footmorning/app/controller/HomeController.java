package com.footmorning.app.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.ComBoastService;
import com.footmorning.app.service.ComGalleryService;
import com.footmorning.app.service.MainNoticeService;

/**
 * 손승한 homeController
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private ComBoastService ComBoastService;
	
	@Inject
	private ComGalleryService ComGalleryService;
	
	@Inject
	private ClubService ClubService;
	
	@Inject
	private MainNoticeService MainNoticeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
		//클럽자랑
		model.addAttribute("boast", ComBoastService.listAll());
		//갤러리
		model.addAttribute("gallery", ComGalleryService.listAll());
		//클럽목록
		model.addAttribute("club", ClubService.listAll());
		//추천클럽 : 클럽인원수 리스트.
		model.addAttribute("popular", ClubService.popularityListAll());
		//클럽공지사항 : 
		model.addAttribute("notice", MainNoticeService.listAll());
		
		return "index";
	}
//	
//	@RequestMapping(value="/",method=RequestMethod.GET)
//	public String sidebar(Locale locale,Model model) throws Exception{
//		
//		
//		return "/include/clubsidebar";
//		
//	}
}
