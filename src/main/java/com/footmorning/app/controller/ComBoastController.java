package com.footmorning.app.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Ŀ�´�Ƽ �ڶ��Խ��� ��Ʈ�ѷ�
 * @author �ڼ���
 *
 */
@Controller
public class ComBoastController {
	private static Logger logger = LoggerFactory.getLogger(ComBoastController.class);
	
	@Autowired
	private ComBoastService sevice;
	
	/**
	 * �۾���
	 */
	@RequestMapping("/com/boast/comBoastRegister")
	public void registerGET(){}
	@RequestMapping(value="/com/boast/comBoastRegister", method=RequestMethod.POST)
	public String registerPOST(ComBoastDTO dto, RedirectAttributes rttr) throws Exception{
		logger.info("registerPOST : " + dto.toString());
		
		service.register(dto);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listAll";
	}
	
	/**
	 * ��ü���
	 */
	@RequestMapping(value="/com/boast/comBoastListAll")
	public void listAll(Model model) throws Exception{
		model.addAttribute("list", service.listAll());
	}
	
	/**
	 * ���б�
	 */
	@RequestMapping("/com/boast/comBoastRead")
	public void readGET(int bno, Model model) throws Exception{
		model.addAttribute(service.read(bno));
	}
	
	/**
	 * �����ϱ�
	 */
	@RequestMapping("/com/boast/comBoastUpdate")
	public void updateGET(int bno, Model model) throws Exception{
		model.addAttribute(service.read(bno));
	}
	@RequestMapping(value="/com/boast/comBoastUpdate", method=RequestMethod.POST)
	public String updatePOST(ComBoastDTO dto, Model model) throws Exception{
		logger.info("modifyPOST : " + dto);
		
		service.modify(dto);
		model.addAttribute(dto);
		return "/com/boast/comBoastRead";
	}
	
	/**
	 * �����ϱ�
	 */
	@RequestMapping("/com/boast/comBoastDelete")
	public String deleteGET(int bno) throws Exception{
		service.delete(bno);
		return "redirect:/com/boast/comBoastListAll";
	}
}
