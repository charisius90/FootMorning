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
import com.footmorning.app.domain.MyclubAlbumDTO;
import com.footmorning.app.domain.MyclubAlbumReplyDTO;
import com.footmorning.app.service.MyclubAlbumService;
import com.footmorning.app.util.AlbumPageMaker;
import com.footmorning.app.util.AlbumSearchCriteria;

@Controller
public class MyclubAlbumController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	@Inject
	private MyclubAlbumService service;
	
	// Main
	@RequestMapping("/myclub/album/main")
	public String BoardMain(AlbumSearchCriteria cri, Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		
		ClubDTO dto = (ClubDTO)session.getAttribute("CLUB_KEY");

		
		cri.setClub_no(dto.getClub_no());
		model.addAttribute("list", service.listSearchCriteria(cri));


		AlbumPageMaker pageMaker = new AlbumPageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
		return "/myclub/myclubalbumboard/myclubAlbumBoardMain2";
	}
	
	// register (GET)
	@RequestMapping(value = "/myclub/album/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		return "myclub/myclubalbumboard/myclubAlbumBoardRegister";
	}
	
	// register (POST)
	@RequestMapping(value = "/myclub/album/register", method = RequestMethod.POST)
	public String registerComplete(MyclubAlbumDTO dto, RedirectAttributes rttr) throws Exception {
		service.register(dto);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/myclub/album/main";
	}
	
	// read
	@RequestMapping(value = "/myclub/album/read", method = RequestMethod.GET)
	public String read(Integer myclub_album_no, Model model) throws Exception {
		service.updateCount(myclub_album_no);
		model.addAttribute("dto", service.read(myclub_album_no));
		
		model.addAttribute("replydto", service.listAllReply(myclub_album_no));

		return "myclub/myclubalbumboard/myclubAlbumBoardRead";
	}
	
	// update
	@RequestMapping(value = "/myclub/album/update", method = RequestMethod.GET)
	public String update(Integer myclub_album_no, Model model) throws Exception {
		model.addAttribute("dto", service.read(myclub_album_no));
		
		return "myclub/myclubalbumboard/myclubAlbumBoardUpdate";
	}
	
	// updateComplete
	@RequestMapping(value = "/myclub/album/update", method = RequestMethod.POST)
	public String updateComplete(MyclubAlbumDTO dto, RedirectAttributes rttr) throws Exception {
		service.modify(dto);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/myclub/album/main";
	}
	
	// delete
	@RequestMapping("/myclub/album/delete")
	public String delete(Integer myclub_album_no, Model model) throws Exception {
		service.remove(myclub_album_no);

		return "redirect:/myclub/album/main";
	}
	
	@RequestMapping(value = "/myclub/albumReply/register", method = RequestMethod.POST)
	public String registerReply(Model model, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		String parent_no = req.getParameter("parent_no");
		String content = req.getParameter("myclub_album_re_content");
		int myclub_album_no = Integer.parseInt(req.getParameter("myclub_album_no"));

		int mem_no = Integer.parseInt(req.getParameter("mem_no"));
		String myclub_album_re_writer = req.getParameter("myclub_album_re_writer");

		MyclubAlbumReplyDTO dto = new MyclubAlbumReplyDTO();
		dto.setMyclub_album_no(myclub_album_no);
		dto.setMyclub_album_re_content(content);

		if (parent_no.equals("parent")) {
			dto.setMem_no(mem_no);
			dto.setMyclub_album_re_writer(myclub_album_re_writer);
			service.createReply(dto);
		} else {
			dto.setMem_no(mem_no);
			dto.setMyclub_album_re_writer(myclub_album_re_writer);
			System.out.println(dto.toString());
			MyclubAlbumReplyDTO dto2 = service.MyclubAlbumParentPos(Integer.parseInt(parent_no));
			service.updatePos(dto2);
			dto.setMyclub_album_re_pos(dto2.getMyclub_album_re_pos());
			dto.setMyclub_album_re_depth(dto2.getMyclub_album_re_depth());
			service.createReReply(dto);
		}

		req.setAttribute("replydto", service.listAllReply(myclub_album_no));
		
		return "/myclub/myclubalbumboard/json/myclubAlbumReplyJson";
	}

	@RequestMapping(value = "/myclub/albumReply/delete", method = RequestMethod.POST)
	public String deleteReply(HttpServletRequest req, Model model) throws Exception {

		int re_no = Integer.parseInt(req.getParameter("re_no"));

		MyclubAlbumReplyDTO dto = service.MyclubAlbumParentPos(re_no);
		
		dto.setMyclub_album_re_writer("999");
		dto.setMyclub_album_re_no(re_no);
		dto.setMyclub_album_re_content("해당 댓글은 이미 삭제되었습니다.");
		
		service.deleteReply(dto);

		req.setAttribute("result", true);
		req.setAttribute("re_no", re_no);
		req.setAttribute("depth", dto.getMyclub_album_re_depth());
		req.setAttribute("writer", dto.getMyclub_album_re_writer());
		
		return "/myclub/myclubalbumboard/json/myclubAlbumReplyDeleteJson";

	}
	
}
