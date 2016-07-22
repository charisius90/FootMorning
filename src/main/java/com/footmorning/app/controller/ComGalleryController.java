package com.footmorning.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.ComGalleryDTO;
import com.footmorning.app.service.ComGalleryService;

@Controller
@RequestMapping("/com/gallery/*")
public class ComGalleryController {
	private static Logger Logger = LoggerFactory.getLogger(ComGalleryController.class);
	
	@Autowired
	private ComGalleryService service;
	
	/**
	 * 글쓰기
	 */
	@RequestMapping("comGalleryRegister")
	public void registerGET(){}
	@RequestMapping(value="comGalleryRegister", method=RequestMethod.POST)
	public String registerPOST(ComGalleryDTO dto, RedirectAttributes rttr) throws Exception{
		
		service.register(dto);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/com/gallery/comFreeListAll";
	}
	
	/**
	 * 전체목록
	 */
	@RequestMapping("comGalleryListAll")
	public void listAll(Model model) throws Exception{
		model.addAttribute("list", service.listAll());
	}
	
	/**
	 * 글읽기
	 */
	@RequestMapping("comGalleryRead")
	public void readGET(int no, Model model) throws Exception{
		ComGalleryDTO dto = service.read(no);
		dto.setCom_gallery_count(Integer.toString(Integer.valueOf(dto.getCom_gallery_count()).intValue() + 1));
		service.update(dto);
		model.addAttribute(dto);
	}
	
	/**
	 * 수정하기
	 */
	@RequestMapping("comGalleryUpdate")
	public void updateGET(int no, Model model) throws Exception{
		model.addAttribute(service.read(no));
	}
	@RequestMapping(value="comGalleryUpdate", method=RequestMethod.POST)
	public String updatePOST(ComGalleryDTO dto, Model model) throws Exception{
		service.update(dto);
		
		model.addAttribute(dto);
		return "/com/gallery/comGalleryRead";
	}
	
	/**
	 * 삭제하기
	 */
	@RequestMapping("comGalleryDelete")
	public String deleteGET(int no) throws Exception{
		service.delete(no);
		return "redirect:/com/gallery/comGalleryListAll";
	}
}