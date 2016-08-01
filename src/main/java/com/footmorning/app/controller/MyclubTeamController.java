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
import com.footmorning.app.domain.MyclubTeamDTO;
import com.footmorning.app.domain.MyclubTeamReplyDTO;
import com.footmorning.app.service.MyclubTeamService;
import com.footmorning.app.util.PageMaker;
import com.footmorning.app.util.SearchCriteria;

@Controller
public class MyclubTeamController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	@Inject
	private MyclubTeamService service;
	
	// Main
	@RequestMapping("/myclub/team/main")
	public String BoardMain(SearchCriteria cri, Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		
		ClubDTO dto = (ClubDTO)session.getAttribute("CLUB_KEY");

		
		cri.setClub_no(dto.getClub_no());
		model.addAttribute("list", service.listSearchCriteria(cri));


		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
		return "/myclub/myclubteamboard/myclubTeamBoardMain";
	}
	
	// register (GET)
	@RequestMapping(value = "/myclub/team/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		return "myclub/myclubteamboard/myclubTeamBoardRegister";
	}
	
	// register (POST)
	@RequestMapping(value = "/myclub/team/register", method = RequestMethod.POST)
	public String registerComplete(MyclubTeamDTO dto, RedirectAttributes rttr) throws Exception {
		service.register(dto);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/myclub/team/main";
	}
	
	// read
	@RequestMapping(value = "/myclub/team/read", method = RequestMethod.GET)
	public String read(Integer myclub_team_no, Model model) throws Exception {
		service.updateCount(myclub_team_no);
		model.addAttribute("dto", service.read(myclub_team_no));
		
		model.addAttribute("replydto", service.listAllReply(myclub_team_no));

		return "myclub/myclubteamboard/myclubTeamBoardRead";
	}
	
	// update
	@RequestMapping(value = "/myclub/team/update", method = RequestMethod.GET)
	public String update(Integer myclub_team_no, Model model) throws Exception {
		model.addAttribute("dto", service.read(myclub_team_no));
		
		return "myclub/myclubteamboard/myclubTeamBoardUpdate";
	}
	
	// updateComplete
	@RequestMapping(value = "/myclub/team/update", method = RequestMethod.POST)
	public String updateComplete(MyclubTeamDTO dto, RedirectAttributes rttr) throws Exception {
		service.modify(dto);

		rttr.addFlashAttribute("msg", "UPSUCCESS");

		return "redirect:/myclub/team/main";
	}
	
	// delete
	@RequestMapping("/myclub/team/delete")
	public String delete(Integer myclub_team_no, Model model, RedirectAttributes rttr) throws Exception {
		service.remove(myclub_team_no);

		rttr.addFlashAttribute("msg", "DELSUCCESS");

		return "redirect:/myclub/team/main";
	}
	
	@RequestMapping(value = "/myclub/teamReply/register", method = RequestMethod.POST)
	public String registerReply(Model model, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		String parent_no = req.getParameter("parent_no");
		String content = req.getParameter("myclub_team_re_content");
		int myclub_team_no = Integer.parseInt(req.getParameter("myclub_team_no"));

		int mem_no = Integer.parseInt(req.getParameter("mem_no"));
		String myclub_team_re_writer = req.getParameter("myclub_team_re_writer");

		MyclubTeamReplyDTO dto = new MyclubTeamReplyDTO();
		dto.setMyclub_team_no(myclub_team_no);
		dto.setMyclub_team_re_content(content);

		if (parent_no.equals("parent")) {
			dto.setMem_no(mem_no);
			dto.setMyclub_team_re_writer(myclub_team_re_writer);
			service.createReply(dto);
		} else {
			dto.setMem_no(mem_no);
			dto.setMyclub_team_re_writer(myclub_team_re_writer);
			System.out.println(dto.toString());
			MyclubTeamReplyDTO dto2 = service.MyclubTeamParentPos(Integer.parseInt(parent_no));
			service.updatePos(dto2);
			dto.setMyclub_team_re_pos(dto2.getMyclub_team_re_pos());
			dto.setMyclub_team_re_depth(dto2.getMyclub_team_re_depth());
			service.createReReply(dto);
		}

		req.setAttribute("replydto", service.listAllReply(myclub_team_no));
		
		return "/myclub/myclubteamboard/json/myclubTeamReplyJson";
	}

	@RequestMapping(value = "/myclub/teamReply/delete", method = RequestMethod.POST)
	public String deleteReply(HttpServletRequest req, Model model) throws Exception {

		int re_no = Integer.parseInt(req.getParameter("re_no"));

		MyclubTeamReplyDTO dto = service.MyclubTeamParentPos(re_no);
		System.out.println(dto.toString());
		
		
		dto.setMyclub_team_re_writer("999");
		dto.setMyclub_team_re_no(re_no);
		dto.setMyclub_team_re_content("해당 댓글은 이미 삭제되었습니다.");
		
		service.deleteReply(dto);

		req.setAttribute("result", true);
		req.setAttribute("re_no", re_no);
		req.setAttribute("depth", dto.getMyclub_team_re_depth());
		req.setAttribute("writer", dto.getMyclub_team_re_writer());
		
		return "/myclub/myclubteamboard/json/myclubTeamReplyDeleteJson";

	}
	
}
