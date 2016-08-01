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

import com.footmorning.app.domain.ComGalleryDTO;
import com.footmorning.app.domain.ComGalleryReplyDTO;
import com.footmorning.app.service.ComGalleryService;
import com.footmorning.app.util.AlbumPageMaker;
import com.footmorning.app.util.AlbumSearchCriteria;


@Controller
public class ComGalleryController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	
	
	@Inject
	private ComGalleryService service;
	
	// Main
	@RequestMapping("/com/gallery/main")
	public String BoardMain(AlbumSearchCriteria cri, Model model) throws Exception {
		
		model.addAttribute("list", service.listSearchCriteria(cri));


		AlbumPageMaker pageMaker = new AlbumPageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
		
		return "/com/gallery/GalleryBoardMain2";
	}
	
	// register (GET)
	@RequestMapping(value = "/com/gallery/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		return "/com/gallery/GalleryBoardRegister";
	}
	
	// register (POST)
	@RequestMapping(value = "/com/gallery/register", method = RequestMethod.POST)
	public String registerComplete(ComGalleryDTO dto, RedirectAttributes rttr) throws Exception {
		service.create(dto);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/com/gallery/main";
	}
	
	// read
	@RequestMapping(value = "/com/gallery/read", method = RequestMethod.GET)
	public String read(Integer com_gallery_no, Model model) throws Exception {
		service.updateCount(com_gallery_no);
		model.addAttribute("dto", service.read(com_gallery_no));
		
		model.addAttribute("replydto", service.listAllReply(com_gallery_no));

		return "/com/gallery/GalleryBoardRead";
	}
	
	// update
	@RequestMapping(value = "/com/gallery/update", method = RequestMethod.GET)
	public String update(Integer com_gallery_no, Model model) throws Exception {
		model.addAttribute("dto", service.read(com_gallery_no));
		
		return "/com/gallery/GalleryBoardUpdate";
	}
	
	// updateComplete
	@RequestMapping(value = "/com/gallery/update", method = RequestMethod.POST)
	public String updateComplete(ComGalleryDTO dto, RedirectAttributes rttr) throws Exception {
		service.update(dto);

		rttr.addFlashAttribute("msg", "UPSUCCESS");

		return "redirect:/com/gallery/main";
	}
	
	// delete
	@RequestMapping("/com/gallery/delete")
	public String delete(Integer com_gallery_no, Model model, RedirectAttributes rttr) throws Exception {
		service.delete(com_gallery_no);
		
		rttr.addFlashAttribute("msg", "DELSUCCESS");
		
		return "redirect:/com/gallery/main";
	}
	
	@RequestMapping(value = "/com/galleryReply/register", method = RequestMethod.POST)
	public String registerReply(Model model, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		String parent_no = req.getParameter("parent_no");
		String content = req.getParameter("com_gallery_re_content");
		int com_gallery_no = Integer.parseInt(req.getParameter("com_gallery_no"));

		int mem_no = Integer.parseInt(req.getParameter("mem_no"));
		String com_gallery_re_writer = req.getParameter("com_gallery_re_writer");

		ComGalleryReplyDTO dto = new ComGalleryReplyDTO();
		dto.setCom_gallery_no(com_gallery_no);
		dto.setCom_gallery_re_content(content);

		if (parent_no.equals("parent")) {
			dto.setMem_no(mem_no);
			dto.setCom_gallery_re_writer(com_gallery_re_writer);
			service.createReply(dto);
		} else {
			dto.setMem_no(mem_no);
			dto.setCom_gallery_re_writer(com_gallery_re_writer);
			System.out.println(dto.toString());
			ComGalleryReplyDTO dto2 = service.ComGalleryParentPos(Integer.parseInt(parent_no));
			service.updatePos(dto2);
			dto.setCom_gallery_re_pos(dto2.getCom_gallery_re_pos());
			dto.setCom_gallery_re_depth(dto2.getCom_gallery_re_depth());
			service.createReReply(dto);
		}

		req.setAttribute("replydto", service.listAllReply(com_gallery_no));
		
		return "/com/gallery/json/GalleryReplyJson";
	}

	@RequestMapping(value = "/com/galleryReply/delete", method = RequestMethod.POST)
	public String deleteReply(HttpServletRequest req, Model model) throws Exception {

		int re_no = Integer.parseInt(req.getParameter("re_no"));

		ComGalleryReplyDTO dto = service.ComGalleryParentPos(re_no);
		
		dto.setCom_gallery_re_writer("999");
		dto.setCom_gallery_re_no(re_no);
		dto.setCom_gallery_re_content("해당 댓글은 이미 삭제되었습니다.");
		
		service.deleteReply(dto);

		req.setAttribute("result", true);
		req.setAttribute("re_no", re_no);
		req.setAttribute("depth", dto.getCom_gallery_re_depth());
		req.setAttribute("writer", dto.getCom_gallery_re_writer());
		
		return "/com/gallery/json/GalleryReplyDeleteJson";

	}
	
}
