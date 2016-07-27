package com.footmorning.app.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.MyclubNoticeDTO;
import com.footmorning.app.service.MyclubNoticeService;
import com.footmorning.app.util.PageMaker;
import com.footmorning.app.util.SearchCriteria;

@Controller
public class MyclubNoticeController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private MyclubNoticeService service;
	
	@RequestMapping("/myclub/notice/main")
	public String notice(SearchCriteria cri,Model model) throws Exception {
	      
		model.addAttribute("list", service.listSearchCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
	    
	    pageMaker.setCri(cri);
	    pageMaker.setTotalCount(service.listSearchCount(cri));
		
	    model.addAttribute("pageMaker", pageMaker);
//	      System.out.println(service.listAll().toString());
	      return "/myclub/myclubNotice/myclubNoticeBoardMain";
//	      	¾Ù¹üÀº myclubNoticeBoardMain2
//	      return "/myclub/myclubNotice/myclubNoticeBoardMain2";
	 }
	
	@RequestMapping(value="/myclub/notice/register", method=RequestMethod.GET)
	public String register(Locale locale, Model model) {
//		logger.info("µî·Ï", locale);
		
		return "myclub/myclubNotice/myclubNoticeBoardRegister";
	}
	
	@RequestMapping(value="/myclub/notice/register", method=RequestMethod.POST)
	 public String registerComplete(MyclubNoticeDTO dto, RedirectAttributes rttr) throws Exception {
//	      logger.info("µî·Ï ¿Ï·á : " + dto.toString());
	      service.register(dto);
	      
	      rttr.addFlashAttribute("msg", "SUCCESS");
	      
	      return "redirect:/myclub/notice/main";
	}
	
	   /**
	    * ½ÂÇÑ read get
	    * @param bno
	    * @param model
	    * @return
	    * @throws Exception
	    */
	   @RequestMapping(value="/myclub/notice/read",method = RequestMethod.GET)
	   public String read(Integer myclub_notice_no, Model model) throws Exception {
	      model.addAttribute("dto",service.read(myclub_notice_no));
	      service.updateCount(myclub_notice_no);
	      
	      return "myclub/myclubNotice/myclubNoticeBoardRead";
	   }
	   
	   /**
	    * ½ÂÇÑ ¾÷µ¥ÀÌÆ® get
	    * @param bno
	    * @param model
	    * @return
	    * @throws Exception
	    */
	   @RequestMapping(value="/myclub/notice/update", method=RequestMethod.GET)
	   public String update(Integer myclub_notice_no, Model model) throws Exception {
	      model.addAttribute("dto",service.read(myclub_notice_no));
	      
	      return "myclub/myclubNotice/myclubNoticeBoardUpdate";
	   }
	   
	   /**
	    * 
	    * ½ÂÇÑ update post
	    * @param dto
	    * @param rttr
	    * @return
	    * @throws Exception
	    */
	   @RequestMapping(value="/myclub/notice/update", method=RequestMethod.POST)
	   public String updateComplete(MyclubNoticeDTO dto, RedirectAttributes rttr) throws Exception {
		   System.out.println("¼öÁ¤: " + dto.toString());
	      service.modify(dto);
	      
	      rttr.addFlashAttribute("msg", "SUCCESS");
	      
	      return "redirect:/myclub/notice/main";
	   }
	   
	   /**
	    * ½ÂÇÑ delete get
	    * @param bno
	    * @param model
	    * @return
	    * @throws Exception
	    */
	   @RequestMapping("/myclub/notice/delete")
	   public String delete(Integer myclub_notice_no, Model model) throws Exception {
	      service.remove(myclub_notice_no);
	      
	      return "redirect:/myclub/notice/main";
	   }
	
	
}
