package com.footmorning.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.ComQnADTO;
import com.footmorning.app.service.ComQnAService;

/**
 * 커뮤니티 Q&A 게시판
 * @author 박수항
 */
@Controller
@RequestMapping("/com/qna/*")
public class ComQnAController {
	private static Logger logger = LoggerFactory.getLogger(ComQnAController.class);
	
	
	@Autowired
	private ComQnAService service;

	
	@RequestMapping("comQnARegister")
	public void registerGET(){}
	
	@RequestMapping(value="comQnARegister", method=RequestMethod.POST)
	public String registerPOST(ComQnADTO dto, RedirectAttributes rttr) throws Exception{
		dto.setCom_qna_count("0");

		service.register(dto);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/com/qna/comQnAListAll";
	}
	
	@RequestMapping("comQnAListAll")
	public void listAll(Model model) throws Exception{
		model.addAttribute("list",service.listAll());
	}
	
	@RequestMapping("comQnARead")
	public void readGET(int no, Model model) throws Exception{
		ComQnADTO dto = service.read(no);
		dto.setCom_qna_count(Integer.toString(Integer.valueOf(dto.getCom_qna_count()).intValue()+ 1));
		service.update(dto);
		model.addAttribute(dto);
	}
	
	@RequestMapping("comQnAUpdate")
	public void updateGET(int no, Model model) throws Exception{
		model.addAttribute(service.read(no));
	}
	@RequestMapping(value="comQnAUpdate", method=RequestMethod.POST)
	public String updatePOST(ComQnADTO dto, Model model) throws Exception{
		service.update(dto);
		
		model.addAttribute(dto);
		return "/com/qna/comQnARead";
	}
	
	@RequestMapping("comQnADelete")
	public String deleteGET(int no) throws Exception{
		service.delete(no);
		return "redirect:/com/qna/comQnAListAll";
	}
}
