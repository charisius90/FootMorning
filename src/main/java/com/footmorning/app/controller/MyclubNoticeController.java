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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.MyclubNoticeDTO;
import com.footmorning.app.domain.MyclubNoticeReplyDTO;
import com.footmorning.app.service.MyclubNoticeService;
import com.footmorning.app.util.PageMaker;
import com.footmorning.app.util.SearchCriteria;

@Controller
public class MyclubNoticeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private MyclubNoticeService service;

	@RequestMapping("/myclub/notice/main")
	public String notice(SearchCriteria cri, Model model) throws Exception {

		model.addAttribute("list", service.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();

		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
		// System.out.println(service.listAll().toString());
		return "/myclub/myclubNotice/myclubNoticeBoardMain";
		// 앨범은 myclubNoticeBoardMain2
		// return "/myclub/myclubNotice/myclubNoticeBoardMain2";
	}

	@RequestMapping(value = "/myclub/notice/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		// logger.info("등록", locale);

		return "myclub/myclubNotice/myclubNoticeBoardRegister";
	}

	@RequestMapping(value = "/myclub/notice/register", method = RequestMethod.POST)
	public String registerComplete(MyclubNoticeDTO dto, RedirectAttributes rttr) throws Exception {
		// logger.info("등록 완료 : " + dto.toString());
		service.register(dto);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/myclub/notice/main";
	}

	/**
	 * 승한 read get
	 * 
	 * @param bno
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/myclub/notice/read", method = RequestMethod.GET)
	public String read(Integer myclub_notice_no, Model model) throws Exception {
		model.addAttribute("dto", service.read(myclub_notice_no));

		model.addAttribute("replydto", service.listAllReply(myclub_notice_no));

		return "myclub/myclubNotice/myclubNoticeBoardRead";
	}

	/**
	 * 승한 업데이트 get
	 * 
	 * @param bno
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/myclub/notice/update", method = RequestMethod.GET)
	public String update(Integer myclub_notice_no, Model model) throws Exception {
		model.addAttribute("dto", service.read(myclub_notice_no));
		System.out.println(service.read(myclub_notice_no).toString());
		return "myclub/myclubNotice/myclubNoticeBoardUpdate";
	}

	/**
	 * 
	 * 승한 update post
	 * 
	 * @param dto
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/myclub/notice/update", method = RequestMethod.POST)
	public String updateComplete(MyclubNoticeDTO dto, RedirectAttributes rttr) throws Exception {
		System.out.println("수정: " + dto.toString());
		service.modify(dto);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/myclub/notice/main";
	}

	/**
	 * 승한 delete get
	 * 
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

	/**
	 * 승한,병현 reply add post
	 * 
	 * @param dto
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/myclub/noticeReply/register", method = RequestMethod.POST)
	public String registerReply(Model model, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		System.out.println("controller called...");
		String parent_no = req.getParameter("parent_no");
		String content = req.getParameter("myclub_notice_re_content");
		int myclub_notice_no = Integer.parseInt(req.getParameter("myclub_notice_no"));

		// 추후 세션
		int mem_no = Integer.parseInt(req.getParameter("mem_no"));
		String myclub_notice_re_writer = req.getParameter("myclub_notice_re_writer");

		// DTO객체생성후 주입
		MyclubNoticeReplyDTO dto = new MyclubNoticeReplyDTO();
		dto.setMyclub_notice_no(myclub_notice_no);
		dto.setMyclub_notice_re_content(content);

		if (parent_no.equals("parent")) {
			dto.setMem_no(mem_no);
			dto.setMyclub_notice_re_writer(myclub_notice_re_writer);
			System.out.println(dto.toString());
			service.createReply(dto);
		} else {
			dto.setMem_no(mem_no);
			dto.setMyclub_notice_re_writer(myclub_notice_re_writer);
			System.out.println(dto.toString());
			MyclubNoticeReplyDTO dto2 = service.MyclubNoticeParentPos(Integer.parseInt(parent_no));
			// System.out.println("parent data called.. : "+dto2.toString());
			// service.updatePos(dto2.getMyclub_notice_re_pos());
			service.updatePos(dto2);
			dto.setMyclub_notice_re_pos(dto2.getMyclub_notice_re_pos());
			dto.setMyclub_notice_re_depth(dto2.getMyclub_notice_re_depth());
			service.createReReply(dto);
		}

		// 테스트
		// System.out.println(service.listAllReply(myclub_notice_no).toString());

		// 댓글리스트
		req.setAttribute("replydto", service.listAllReply(myclub_notice_no));

		return "/myclub/myclubNotice/json/myclubNoticeReplyJson";
	}

	/**
	 * 승한,병현 리플삭제
	 * 
	 * @param req
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/myclub/noticeReply/delete", method = RequestMethod.POST)
	public String deleteReply(HttpServletRequest req, Model model) throws Exception {

		int re_no = Integer.parseInt(req.getParameter("re_no"));
		// System.out.println(re_no);

		// 부모 info
		MyclubNoticeReplyDTO dto = service.MyclubNoticeParentPos(re_no);

		// 삭제시 dto set
		dto.setMyclub_notice_re_writer("999");
		dto.setMyclub_notice_re_no(re_no);
		dto.setMyclub_notice_re_content("해당 댓글은 이미 삭제되었습니다.");

		// System.out.println(dto.toString());
		// 삭제 호출
		service.deleteReply(dto);

		req.setAttribute("result", true);
		req.setAttribute("re_no", re_no);
		req.setAttribute("depth", dto.getMyclub_notice_re_depth());
		req.setAttribute("writer", dto.getMyclub_notice_re_writer());

		System.out.println("dto writer:" + dto.getMyclub_notice_re_writer());
		return "/myclub/myclubNotice/json/myclubNoticeReplyDeleteJson";

	}

}
