package com.footmorning.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.ComBoastReplyDTO;
import com.footmorning.app.service.ComBoastReplyService;

/**
 * 커뮤니티 자랑게시판 리플 컨트롤러
 * @author 김소영
 *
 */
@Controller
@RequestMapping("/com/boast/*")
public class ComBoastReplyController {
	private static Logger logger = LoggerFactory.getLogger(ComBoastReplyController.class);
	
	@Autowired
	private ComBoastReplyService service;
	
	@RequestMapping("comBoastReplyRegister")
	public void registerGET(){}
	
	@RequestMapping(value = "/com/boast/comBoastReplyRegister", method = RequestMethod.POST)
	public String registerPOST(ComBoastReplyDTO dto, RedirectAttributes rttr) throws Exception {

		service.register(dto);

		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/com/boast/comBoastRead";
	}
	
	@RequestMapping("comBoastReplyListAll")
	public void listAll(Model model) throws Exception{
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping("comBoastReplyRead")
	public void readGET(int no, Model model) throws Exception{
		ComBoastReplyDTO dto = service.read(no);
		service.update(dto);
		model.addAttribute(dto);
	}
	
	@RequestMapping("comBoastReplyDelete")
	public String deleteGET(int no) throws Exception{
		service.delete(no);
		return "redirect:/com/boast/comBoastReplyListAll";
	}
}
