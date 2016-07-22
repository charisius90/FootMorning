package com.footmorning.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.ComVideoDTO;
import com.footmorning.app.service.ComVideoService;

@Controller
@RequestMapping("/com/video/*")
public class ComVideoController {
	private static Logger Logger = LoggerFactory.getLogger(ComVideoController.class);
	
	@Autowired
	private ComVideoService service;
	
	/**
	 * 글쓰기
	 */
	@RequestMapping("comVideoRegister")
	public void registerGET(){}
	@RequestMapping(value="comVideoRegister", method=RequestMethod.POST)
	public String registerPOST(ComVideoDTO dto, RedirectAttributes rttr) throws Exception{
		
		service.register(dto);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/com/video/comVideoListAll";
	}
	
	/**
	 * 전체목록
	 */
	@RequestMapping("comVideoListAll")
	public void listAll(Model model) throws Exception{
		model.addAttribute("list", service.listAll());
	}
	
	/**
	 * 글읽기
	 */
	@RequestMapping("comVideoRead")
	public void readGET(int no, Model model) throws Exception{
		ComVideoDTO dto = service.read(no);
		dto.setCom_video_count(Integer.toString(Integer.valueOf(dto.getCom_video_count()).intValue() + 1));
		service.update(dto);
		model.addAttribute(dto);
	}
	
	/**
	 * 수정하기
	 */
	@RequestMapping("comVideoUpdate")
	public void updateGET(int no, Model model) throws Exception{
		model.addAttribute(service.read(no));
	}
	@RequestMapping(value="comVideoUpdate", method=RequestMethod.POST)
	public String updatePOST(ComVideoDTO dto, Model model) throws Exception{
		service.update(dto);
		
		model.addAttribute(dto);
		return "/com/video/comVideoRead";
	}
	
	/**
	 * 삭제하기
	 */
	@RequestMapping("comVideoDelete")
	public String deleteGET(int no) throws Exception{
		service.delete(no);
		return "redirect:/com/video/comVideoListAll";
	}
}