package com.footmorning.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.ComDiscussionWorldDTO;
import com.footmorning.app.service.ComDiscussionWorldService;

@Controller
@RequestMapping("/com/discussionworld/*")
public class ComDiscussionWorldController {
	private static Logger Logger = LoggerFactory.getLogger(ComDiscussionWorldController.class);
	
	@Autowired
	private ComDiscussionWorldService service;
	
	/**
	 * 글쓰기
	 */
	@RequestMapping("comDisscssionWorldRegister")
	public void registerGET(){}
	@RequestMapping(value="comDiscussionWorldRegister", method=RequestMethod.POST)
	public String registerPOST(ComDiscussionWorldDTO dto, RedirectAttributes rttr) throws Exception{
		
		service.register(dto);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/com/discussionworld/comDiscussionWorldListAll";
	}
	
	/**
	 * 전체목록
	 */
	@RequestMapping("comDiscussionWorldListAll")
	public void listAll(Model model) throws Exception{
		model.addAttribute("list", service.listAll());
	}
	
	/**
	 * 글읽기
	 */
	@RequestMapping("comDiscussionWorldRead")
	public void readGET(int no, Model model) throws Exception{
		ComDiscussionWorldDTO dto = service.read(no);
		dto.setCom_discussion_world_count(Integer.toString(Integer.valueOf(dto.getCom_discussion_world_count()).intValue()+ 1));
		service.update(dto);
		model.addAttribute(dto);
	}
	
	/**
	 * 수정하기
	 */
	@RequestMapping("comDiscussionWorldUpdate")
	public void updateGET(int no, Model model) throws Exception{
		model.addAttribute(service.read(no));
	}
	@RequestMapping(value="comDiscussionWorldUpdate", method=RequestMethod.POST)
	public String updatePOST(ComDiscussionWorldDTO dto, Model model) throws Exception{
		service.update(dto);
		
		model.addAttribute(dto);
		return "/com/discussionworld/comDiscussionWorldRead";
	}
	
	/**
	 * 삭제하기
	 */
	@RequestMapping("comDiscussionWorldDelete")
	public String deleteGET(int no) throws Exception{
		service.delete(no);
		return "redirect:/com/discussionworld/comDiscussionWorldListAll";
	}
}