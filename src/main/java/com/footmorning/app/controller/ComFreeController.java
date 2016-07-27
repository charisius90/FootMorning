package com.footmorning.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.ComFreeDTO;
import com.footmorning.app.service.ComFreeService;

@Controller
@RequestMapping("/com/free/*")
public class ComFreeController {
	private static Logger Logger = LoggerFactory.getLogger(ComFreeController.class);
	
	@Autowired
	private ComFreeService service;
	
	/**
	 * 글쓰기
	 */
	@RequestMapping("comFreeRegister")
	public void registerGET(){}
	@RequestMapping(value="comFreeRegister", method=RequestMethod.POST)
	public String registerPOST(ComFreeDTO dto, RedirectAttributes rttr) throws Exception{
		dto.setCom_free_count("0");
		
		service.register(dto);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/com/free/comFreeListAll";
	}
	
	/**
	 * 전체목록
	 */
	@RequestMapping("comFreeListAll")
	public void listAll(Model model) throws Exception{
		model.addAttribute("list", service.listAll());
	}
	
	/**
	 * 글읽기
	 */
	@RequestMapping("comFreeRead")
	public void readGET(int no, Model model) throws Exception{
		ComFreeDTO dto = service.read(no);
		dto.setCom_free_count(Integer.toString(Integer.valueOf(dto.getCom_free_count()).intValue() + 1));
		service.update(dto);
		model.addAttribute(dto);
	}
	
	/**
	 * 수정하기
	 */
	@RequestMapping("comFreeUpdate")
	public void updateGET(int no, Model model) throws Exception{
		model.addAttribute(service.read(no));
	}
	@RequestMapping(value="comFreeUpdate", method=RequestMethod.POST)
	public String updatePOST(ComFreeDTO dto, Model model) throws Exception{
		service.update(dto);
		model.addAttribute(dto);
		return "/com/free/comFreeRead";
	}
	
	/**
	 * 삭제하기
	 */
	@RequestMapping("comFreeDelete")
	public String deleteGET(int no) throws Exception{
		service.delete(no);
		return "redirect:/com/free/comFreeListAll";
	}
}