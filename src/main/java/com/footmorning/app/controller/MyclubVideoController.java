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
import com.footmorning.app.domain.MyclubVideoDTO;
import com.footmorning.app.domain.MyclubVideoReplyDTO;
import com.footmorning.app.service.MyclubVideoService;
import com.footmorning.app.util.AlbumPageMaker;
import com.footmorning.app.util.AlbumSearchCriteria;

@Controller
public class MyclubVideoController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	@Inject
	private MyclubVideoService service;
	
	// Main
	@RequestMapping("/myclub/video/main")
	public String BoardMain(AlbumSearchCriteria cri, Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		
		ClubDTO dto = (ClubDTO)session.getAttribute("CLUB_KEY");
		System.out.println("지금 클럽:"+dto.getClub_no());
		System.out.println("클럽 이름:"+dto.getClub_name());
		cri.setClub_no(dto.getClub_no());
		model.addAttribute("list", service.listSearchCriteria(cri));
//		System.out.println("첫번째:"+service.listSearchCriteria(cri).get(0).getMyclub_video_main_thumnail());
//		System.out.println("두번째:"+service.listSearchCriteria(cri).get(1).getMyclub_video_main_thumnail());
		
		AlbumPageMaker pageMaker = new AlbumPageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
		return "/myclub/myclubvideoboard/myclubVideoBoardMain2";
	}
	
	// register (GET)
	@RequestMapping(value = "/myclub/video/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		return "myclub/myclubvideoboard/myclubVideoBoardRegister";
	}
	
	// register (POST)
	@RequestMapping(value = "/myclub/video/register", method = RequestMethod.POST)
	public String registerComplete(MyclubVideoDTO dto, RedirectAttributes rttr) throws Exception {
		String videoContent = dto.getMyclub_video_content();
		String[] splitCount = videoContent.split("<source src=");
		dto.setMyclub_video_count(splitCount.length -1);
		service.register(dto);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/myclub/video/main";
	}
	
	// read
	@RequestMapping(value = "/myclub/video/read", method = RequestMethod.GET)
	public String read(Integer myclub_video_no, Model model) throws Exception {
		service.updateCount(myclub_video_no);
		model.addAttribute("dto", service.read(myclub_video_no));
		
		model.addAttribute("replydto", service.listAllReply(myclub_video_no));

		return "myclub/myclubvideoboard/myclubVideoBoardRead";
	}
	
	// update
	@RequestMapping(value = "/myclub/video/update", method = RequestMethod.GET)
	public String update(Integer myclub_video_no, Model model) throws Exception {
		model.addAttribute("dto", service.read(myclub_video_no));
		
		return "myclub/myclubvideoboard/myclubVideoBoardUpdate";
	}
	
	// updateComplete
	@RequestMapping(value = "/myclub/video/update", method = RequestMethod.POST)
	public String updateComplete(MyclubVideoDTO dto, RedirectAttributes rttr) throws Exception {
		service.modify(dto);

		rttr.addFlashAttribute("msg", "UPSUCCESS");

		return "redirect:/myclub/video/main";
	}
	
	// delete
	@RequestMapping("/myclub/video/delete")
	public String delete(Integer myclub_video_no, Model model, RedirectAttributes rttr) throws Exception {
		service.remove(myclub_video_no);

		rttr.addFlashAttribute("msg", "DELSUCCESS");

		return "redirect:/myclub/video/main";
	}
	
	@RequestMapping(value = "/myclub/videoReply/register", method = RequestMethod.POST)
	public String registerReply(Model model, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		String parent_no = req.getParameter("parent_no");
		String content = req.getParameter("myclub_video_re_content");
		int myclub_video_no = Integer.parseInt(req.getParameter("myclub_video_no"));

		int mem_no = Integer.parseInt(req.getParameter("mem_no"));
		String myclub_video_re_writer = req.getParameter("myclub_video_re_writer");

		MyclubVideoReplyDTO dto = new MyclubVideoReplyDTO();
		dto.setMyclub_video_no(myclub_video_no);
		dto.setMyclub_video_re_content(content);

		if (parent_no.equals("parent")) {
			dto.setMem_no(mem_no);
			dto.setMyclub_video_re_writer(myclub_video_re_writer);
			service.createReply(dto);
		} else {
			dto.setMem_no(mem_no);
			dto.setMyclub_video_re_writer(myclub_video_re_writer);
			System.out.println(dto.toString());
			MyclubVideoReplyDTO dto2 = service.MyclubVideoParentPos(Integer.parseInt(parent_no));
			service.updatePos(dto2);
			dto.setMyclub_video_re_pos(dto2.getMyclub_video_re_pos());
			dto.setMyclub_video_re_depth(dto2.getMyclub_video_re_depth());
			service.createReReply(dto);
		}

		req.setAttribute("replydto", service.listAllReply(myclub_video_no));
		
		return "/myclub/myclubvideoboard/json/myclubVideoReplyJson";
	}

	@RequestMapping(value = "/myclub/videoReply/delete", method = RequestMethod.POST)
	public String deleteReply(HttpServletRequest req, Model model) throws Exception {

		int re_no = Integer.parseInt(req.getParameter("re_no"));

		MyclubVideoReplyDTO dto = service.MyclubVideoParentPos(re_no);
		
		dto.setMyclub_video_re_writer("999");
		dto.setMyclub_video_re_no(re_no);
		dto.setMyclub_video_re_content("해당 댓글은 이미 삭제되었습니다.");
		
		service.deleteReply(dto);

		req.setAttribute("result", true);
		req.setAttribute("re_no", re_no);
		req.setAttribute("depth", dto.getMyclub_video_re_depth());
		req.setAttribute("writer", dto.getMyclub_video_re_writer());
		
		return "/myclub/myclubvideoboard/json/myclubVideoReplyDeleteJson";

	}
	
}
