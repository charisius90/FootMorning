package com.footmorning.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.ComBoastDTO;
import com.footmorning.app.service.ComBoastService;

/**
 * 커뮤니티 자랑게시판 컨트롤러
 * @author 박수항
 *
 */
@Controller
@RequestMapping("/com/boast/*")
public class ComBoastController {
	private static Logger logger = LoggerFactory.getLogger(ComBoastController.class);
	
	@Autowired
	private ComBoastService service;
	
	/**
	 * 글쓰기
	 */
	@RequestMapping("comBoastRegister")
	public void registerGET(){}
	@RequestMapping(value="/com/boast/comBoastRegister", method=RequestMethod.POST)
	public String registerPOST(ComBoastDTO dto, RedirectAttributes rttr) throws Exception{
		logger.info("registerPOST : " + dto.toString());
		
		service.register(dto);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listAll";
	}
	
	/**
	 * 전체목록
	 */
	@RequestMapping(value="comBoastListAll")
	public void listAll(Model model) throws Exception{
		model.addAttribute("list", service.listAll());
	}
	
	/**
	 * 글읽기
	 */
	@RequestMapping("comBoastRead")
	public void readGET(int bno, Model model) throws Exception{
		model.addAttribute(service.read(bno));
	}
	
	/**
	 * 수정하기
	 */
	@RequestMapping("comBoastUpdate")
	public void updateGET(int bno, Model model) throws Exception{
		model.addAttribute(service.read(bno));
	}
	@RequestMapping(value="comBoastUpdate", method=RequestMethod.POST)
	public String updatePOST(ComBoastDTO dto, Model model) throws Exception{
		logger.info("modifyPOST : " + dto);
		
		service.update(dto);
		model.addAttribute(dto);
		return "/com/boast/comBoastRead";
	}
	
	/**
	 * 삭제하기
	 */
	@RequestMapping("comBoastDelete")
	public String deleteGET(int bno) throws Exception{
		service.delete(bno);
		return "redirect:/com/boast/comBoastListAll";
	}
}
