package com.footmorning.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.ComDiscussionKorDTO;
import com.footmorning.app.service.ComDiscussionKorService;

@Controller
@RequestMapping("/com/discussionkor/*")
public class ComDiscussionKorController {
	private static Logger Logger = LoggerFactory.getLogger(ComDiscussionKorController.class);
	
	@Autowired
	private ComDiscussionKorService service;
	
	/**
	 * 글쓰기
	 */
	@RequestMapping("comDiscussionKorRegister")
	public void registerGET(){}
	
	@RequestMapping(value="comDiscussionKorRegister", method=RequestMethod.POST)
	public String registerPOST(ComDiscussionKorDTO dto, RedirectAttributes rttr) throws Exception{
		
		service.register(dto);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/com/discussionkor/comDiscussionKorListAll";
	}
	
	/**
	 * 전체목록
	 */
	@RequestMapping("comDiscussionKorListAll")
	public void listAll(Model model) throws Exception{
		model.addAttribute("list", service.listAll());
	}
	
	/**
	 * 글읽기
	 */
	@RequestMapping("comDiscussionKorRead")
	public void readGET(int no, Model model) throws Exception{
		ComDiscussionKorDTO dto = service.read(no);
		dto.setCom_discussion_kor_count(Integer.toString(Integer.valueOf(dto.getCom_discussion_kor_count()).intValue()+ 1));
		service.update(dto);
		model.addAttribute(dto);
	}
	
	/**
	 * 수정하기
	 */
	@RequestMapping("comDiscussionKorUpdate")
	public void updateGET(int no, Model model) throws Exception{
		model.addAttribute(service.read(no));
	}
	@RequestMapping(value="comDiscussionKorUpdate", method=RequestMethod.POST)
	public String updatePOST(ComDiscussionKorDTO dto, Model model) throws Exception{
		service.update(dto);
		
		model.addAttribute(dto);
		return "/com/discussionkor/comDiscussionKorRead";
	}
	
	/**
	 * 삭제하기
	 */
	@RequestMapping("comDiscussionKorDelete")
	public String deleteGET(int no) throws Exception{
		service.delete(no);
		return "redirect:/com/discussionkor/comDiscussionKorListAll";
	}
}