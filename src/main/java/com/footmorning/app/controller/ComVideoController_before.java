package com.footmorning.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.ComVideoDTO_before;
import com.footmorning.app.service.ComVideoService_before;

@Controller
@RequestMapping("/com/video/*")
public class ComVideoController_before {
	private static Logger Logger = LoggerFactory.getLogger(ComVideoController_before.class);
	
	@Autowired
	private ComVideoService_before service;
	
	/**
	 * �۾���
	 */
	@RequestMapping("comVideoRegister")
	public void registerGET(){}
	@RequestMapping(value="comVideoRegister", method=RequestMethod.POST)
	public String registerPOST(ComVideoDTO_before dto, RedirectAttributes rttr) throws Exception{
		
		service.register(dto);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/com/video/comVideoListAll";
	}
	
	/**
	 * ��ü���
	 */
	@RequestMapping("comVideoListAll")
	public void listAll(Model model) throws Exception{
		model.addAttribute("list", service.listAll());
	}
	
	/**
	 * ���б�
	 */
	@RequestMapping("comVideoRead")
	public void readGET(int no, Model model) throws Exception{
		ComVideoDTO_before dto = service.read(no);
		dto.setCom_video_count(Integer.toString(Integer.valueOf(dto.getCom_video_count()).intValue() + 1));
		service.update(dto);
		model.addAttribute(dto);
	}
	
	/**
	 * �����ϱ�
	 */
	@RequestMapping("comVideoUpdate")
	public void updateGET(int no, Model model) throws Exception{
		model.addAttribute(service.read(no));
	}
	@RequestMapping(value="comVideoUpdate", method=RequestMethod.POST)
	public String updatePOST(ComVideoDTO_before dto, Model model) throws Exception{
		service.update(dto);
		
		model.addAttribute(dto);
		return "/com/video/comVideoRead";
	}
	
	/**
	 * �����ϱ�
	 */
	@RequestMapping("comVideoDelete")
	public String deleteGET(int no) throws Exception{
		service.delete(no);
		return "redirect:/com/video/comVideoListAll";
	}
}