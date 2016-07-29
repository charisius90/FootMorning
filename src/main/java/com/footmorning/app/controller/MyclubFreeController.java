package com.footmorning.app.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.domain.MyclubFreeDTO;
import com.footmorning.app.domain.MyclubFreeReplyDTO;
import com.footmorning.app.service.MyclubFreeService;
import com.footmorning.app.util.PageMaker;
import com.footmorning.app.util.SearchCriteria;

@Controller
public class MyclubFreeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	@Inject
	private MyclubFreeService service;
	
	// Main
	@RequestMapping("/myclub/free/main")
	public String BoardMain(SearchCriteria cri, Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		
		ClubDTO dto = (ClubDTO)session.getAttribute("CLUB_KEY");

		
		cri.setClub_no(dto.getClub_no());
		model.addAttribute("list", service.listSearchCriteria(cri));


		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
		return "/myclub/myclubfreeboard/myclubFreeBoardMain";
	}
	
	// register (GET)
	@RequestMapping(value = "/myclub/free/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		return "myclub/myclubfreeboard/myclubFreeBoardRegister";
	}
	
	// register (POST)
	@RequestMapping(value = "/myclub/free/register", method = RequestMethod.POST)
	public String registerComplete(MyclubFreeDTO dto, RedirectAttributes rttr) throws Exception {
		service.register(dto);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/myclub/free/main";
	}
	
	// read
	@RequestMapping(value = "/myclub/free/read", method = RequestMethod.GET)
	public String read(Integer myclub_free_no, Model model) throws Exception {
		service.updateCount(myclub_free_no);
		model.addAttribute("dto", service.read(myclub_free_no));
		
		model.addAttribute("replydto", service.listAllReply(myclub_free_no));

		return "myclub/myclubfreeboard/myclubFreeBoardRead";
	}
	
	// update
	@RequestMapping(value = "/myclub/free/update", method = RequestMethod.GET)
	public String update(Integer myclub_free_no, Model model) throws Exception {
		model.addAttribute("dto", service.read(myclub_free_no));
		
		return "myclub/myclubfreeboard/myclubFreeBoardUpdate";
	}
	
	// updateComplete
	@RequestMapping(value = "/myclub/free/update", method = RequestMethod.POST)
	public String updateComplete(MyclubFreeDTO dto, RedirectAttributes rttr) throws Exception {
		service.modify(dto);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/myclub/free/main";
	}
	
	// delete
	@RequestMapping("/myclub/free/delete")
	public String delete(Integer myclub_free_no, Model model) throws Exception {
		service.remove(myclub_free_no);

		return "redirect:/myclub/free/main";
	}
	
	@RequestMapping(value = "/myclub/freeReply/register", method = RequestMethod.POST)
	public String registerReply(Model model, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		String parent_no = req.getParameter("parent_no");
		String content = req.getParameter("myclub_free_re_content");
		int myclub_free_no = Integer.parseInt(req.getParameter("myclub_free_no"));

		int mem_no = Integer.parseInt(req.getParameter("mem_no"));
		String myclub_free_re_writer = req.getParameter("myclub_free_re_writer");

		MyclubFreeReplyDTO dto = new MyclubFreeReplyDTO();
		dto.setMyclub_free_no(myclub_free_no);
		dto.setMyclub_free_re_content(content);

		if (parent_no.equals("parent")) {
			dto.setMem_no(mem_no);
			dto.setMyclub_free_re_writer(myclub_free_re_writer);
			service.createReply(dto);
		} else {
			dto.setMem_no(mem_no);
			dto.setMyclub_free_re_writer(myclub_free_re_writer);
			System.out.println(dto.toString());
			MyclubFreeReplyDTO dto2 = service.MyclubFreeParentPos(Integer.parseInt(parent_no));
			service.updatePos(dto2);
			dto.setMyclub_free_re_pos(dto2.getMyclub_free_re_pos());
			dto.setMyclub_free_re_depth(dto2.getMyclub_free_re_depth());
			service.createReReply(dto);
		}

		req.setAttribute("replydto", service.listAllReply(myclub_free_no));
		
		return "/myclub/myclubfreeboard/json/myclubFreeReplyJson";
	}

	@RequestMapping(value = "/myclub/freeReply/delete", method = RequestMethod.POST)
	public String deleteReply(HttpServletRequest req, Model model) throws Exception {

		int re_no = Integer.parseInt(req.getParameter("re_no"));

		MyclubFreeReplyDTO dto = service.MyclubFreeParentPos(re_no);

		dto.setMyclub_free_re_writer("999");
		dto.setMyclub_free_re_no(re_no);
		dto.setMyclub_free_re_content("해당 댓글은 이미 삭제되었습니다.");

		service.deleteReply(dto);

		req.setAttribute("result", true);
		req.setAttribute("re_no", re_no);
		req.setAttribute("depth", dto.getMyclub_free_re_depth());
		req.setAttribute("writer", dto.getMyclub_free_re_writer());
		
		return "/myclub/myclubfreeboard/json/myclubFreeReplyDeleteJson";

	}
	
}
