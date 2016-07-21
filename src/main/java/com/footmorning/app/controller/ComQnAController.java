package com.footmorning.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footmorning.app.service.ComQnAService;

/**
 * 커뮤니티 Q&A 게시판
 * @author 박수항
 */
@Controller
@RequestMapping("/com/qna/*")
public class ComQnAController {
	@Autowired
	private ComQnAService service;

	
	@RequestMapping("comQnARegister")
	public void registerGET(){}
	@RequestMapping(value="comQnARegister", method=RequestMethod.POST)
	public String registerPOST(){
		return "redirect:/com/qna/comQnAListAll";
	}
	
	@RequestMapping("comQnAListAll")
	public void listAll() throws Exception{
	}
	
	@RequestMapping("comQnARead")
	public void readGET() throws Exception{
	}
	
	@RequestMapping("comQnAUpdate")
	public void updateGET() throws Exception{}
	@RequestMapping(value="comQnAUpdate", method=RequestMethod.POST)
	public String updatePOST() throws Exception{
		return "/com/boast/comQnARead";
	}
	
	@RequestMapping("comQnADelete")
	public String deleteGET() throws Exception{
		return "redirect:/com/boast/comQnAListAll";
	}
}
