package com.footmorning.app.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.ComGalleryReplyDTO;
import com.footmorning.app.domain.ComVideoDTO;
import com.footmorning.app.domain.ComVideoReplyDTO;
import com.footmorning.app.service.ComVideoService;
import com.footmorning.app.util.AlbumPageMaker;
import com.footmorning.app.util.AlbumSearchCriteria;



@Controller
public class ComVideoController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	@Inject
	private ComVideoService service;
	
	// Main
	@RequestMapping("/com/video/main")
	public String BoardMain(AlbumSearchCriteria cri, Model model) throws Exception {
		
		model.addAttribute("list", service.listSearchCriteria(cri));


		AlbumPageMaker pageMaker = new AlbumPageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
		
		return "/com/video/VideoBoardMain2";
	}
	
	// register (GET)
	@RequestMapping(value = "/com/video/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		return "/com/video/VideoBoardRegister";
	}
	
	// register (POST)
	@RequestMapping(value = "/com/video/register", method = RequestMethod.POST)
	public String registerComplete(ComVideoDTO dto, RedirectAttributes rttr) throws Exception {
		service.create(dto);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/com/video/main";
	}
	
	// read
	@RequestMapping(value = "/com/video/read", method = RequestMethod.GET)
	public String read(Integer com_video_no, Model model) throws Exception {
		service.updateCount(com_video_no);
		model.addAttribute("dto", service.read(com_video_no));
		
		model.addAttribute("replydto", service.listAllReply(com_video_no));

		return "/com/video/VideoBoardRead";
	}
	
	// update
	@RequestMapping(value = "/com/video/update", method = RequestMethod.GET)
	public String update(Integer com_video_no, Model model) throws Exception {
		model.addAttribute("dto", service.read(com_video_no));
		
		System.out.println(service.read(com_video_no));
		
		return "/com/video/VideoBoardUpdate";
	}
	
	// updateComplete
	@RequestMapping(value = "/com/video/update", method = RequestMethod.POST)
	public String updateComplete(ComVideoDTO dto, RedirectAttributes rttr) throws Exception {
		service.update(dto);

		rttr.addFlashAttribute("msg", "UPSUCCESS");

		return "redirect:/com/video/main";
	}
	
	// delete
	@RequestMapping("/com/video/delete")
	public String delete(Integer com_video_no, Model model,  RedirectAttributes rttr) throws Exception {
		service.delete(com_video_no);

		rttr.addFlashAttribute("msg", "DELSUCCESS");

		return "redirect:/com/video/main";
	}
	
	@RequestMapping(value = "/com/videoReply/register", method = RequestMethod.POST)
	public String registerReply(Model model, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		String parent_no = req.getParameter("parent_no");
		String content = req.getParameter("com_video_re_content");
		int com_video_no = Integer.parseInt(req.getParameter("com_video_no"));

		int mem_no = Integer.parseInt(req.getParameter("mem_no"));
		String com_video_re_writer = req.getParameter("com_video_re_writer");

		ComVideoReplyDTO dto = new ComVideoReplyDTO();
		dto.setCom_video_no(com_video_no);
		dto.setCom_video_re_content(content);

		if (parent_no.equals("parent")) {
			dto.setMem_no(mem_no);
			dto.setCom_video_re_writer(com_video_re_writer);
			service.createReply(dto);
		} else {
			dto.setMem_no(mem_no);
			dto.setCom_video_re_writer(com_video_re_writer);
			System.out.println(dto.toString());
			ComVideoReplyDTO dto2 = service.ComVideoParentPos(Integer.parseInt(parent_no));
			service.updatePos(dto2);
			dto.setCom_video_re_pos(dto2.getCom_video_re_pos());
			dto.setCom_video_re_depth(dto2.getCom_video_re_depth());
			service.createReReply(dto);
		}

		req.setAttribute("replydto", service.listAllReply(com_video_no));
		
		return "/com/video/json/VideoReplyJson";
	}

	@RequestMapping(value = "/com/videoReply/delete", method = RequestMethod.POST)
	public String deleteReply(HttpServletRequest req, Model model) throws Exception {

		int re_no = Integer.parseInt(req.getParameter("re_no"));

		ComVideoReplyDTO dto = service.ComVideoParentPos(re_no);
		
		dto.setCom_video_re_writer("999");
		dto.setCom_video_re_no(re_no);
		dto.setCom_video_re_content("해당 댓글은 이미 삭제되었습니다.");
		
		service.deleteReply(dto);

		req.setAttribute("result", true);
		req.setAttribute("re_no", re_no);
		req.setAttribute("depth", dto.getCom_video_re_depth());
		req.setAttribute("writer", dto.getCom_video_re_writer());
		
		return "/com/video/json/VideoReplyDeleteJson";

	}
	
}
