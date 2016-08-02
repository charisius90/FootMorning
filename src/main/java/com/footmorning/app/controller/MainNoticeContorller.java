package com.footmorning.app.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.MainNoticeDTO;
import com.footmorning.app.domain.MainNoticeReplyDTO;
import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.MainNoticeService;
import com.footmorning.app.util.PageMaker;
import com.footmorning.app.util.SearchCriteria;

/**
 * Ŀ�´�Ƽ �ڶ��Խ��� ��Ʈ�ѷ�
 * @author �ڼ���
 *
 */
@Controller
public class MainNoticeContorller {
	private static Logger logger = LoggerFactory.getLogger(MainNoticeContorller.class);
	
	@Inject
	private MainNoticeService service;
	
	@Inject
	private ClubService ClubService;
	
	@Inject
	private MainNoticeService MainNoticeService;
	
	
	@RequestMapping("/club/notice/main")
	public String notice(SearchCriteria cri, Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		
//		ClubDTO dto = (ClubDTO)session.getAttribute("CLUB_KEY");
//		cri.setClub_no(dto.getClub_no());
		model.addAttribute("list", service.listSearchCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
		// System.out.println(service.listAll().toString());
		
		//클럽목록
		model.addAttribute("club", ClubService.listAll());
		//추천클럽 : 클럽인원수 리스트.
		model.addAttribute("popular", ClubService.popularityListAll());
		//클럽공지사항 : 
		model.addAttribute("notice", MainNoticeService.listAll());
		
		return "/club/notice/NoticeMain";
		// �ٹ��� myclubNoticeBoardMain2
		// return "/myclub/myclubNotice/myclubNoticeBoardMain2";
	}

	@RequestMapping(value = "/club/notice/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) throws Exception {
		// logger.info("���", locale);
		
		//클럽목록
		model.addAttribute("club", ClubService.listAll());
		//추천클럽 : 클럽인원수 리스트.
		model.addAttribute("popular", ClubService.popularityListAll());
		//클럽공지사항 : 
		model.addAttribute("notice", MainNoticeService.listAll());

		return "/club/notice/NoticeRegister";
	}

	@RequestMapping(value = "/club/notice/register", method = RequestMethod.POST)
	public String registerComplete(MainNoticeDTO dto, RedirectAttributes rttr) throws Exception {
		// logger.info("��� �Ϸ� : " + dto.toString());
		service.register(dto);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/club/notice/main";
	}

	/**
	 * ���� read get
	 * 
	 * @param bno
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/club/notice/read", method = RequestMethod.GET)
	public String read(Integer main_notice_no, Model model) throws Exception {
		service.updateCount(main_notice_no);
		
		model.addAttribute("dto", service.read(main_notice_no));

		model.addAttribute("replydto", service.listAllReply(main_notice_no));
		
		//클럽목록
		model.addAttribute("club", ClubService.listAll());
		//추천클럽 : 클럽인원수 리스트.
		model.addAttribute("popular", ClubService.popularityListAll());
		//클럽공지사항 : 
		model.addAttribute("notice", MainNoticeService.listAll());

		return "/club/notice/NoticeRead";
	}

	/**
	 * ���� ������Ʈ get
	 * 
	 * @param bno
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/club/notice/update", method = RequestMethod.GET)
	public String update(Integer main_notice_no, Model model) throws Exception {
		model.addAttribute("dto", service.read(main_notice_no));
		System.out.println(service.read(main_notice_no).toString());
		
		//클럽목록
		model.addAttribute("club", ClubService.listAll());
		//추천클럽 : 클럽인원수 리스트.
		model.addAttribute("popular", ClubService.popularityListAll());
		//클럽공지사항 : 
		model.addAttribute("notice", MainNoticeService.listAll());
		
		
		return "/club/notice/NoticeUpdate";
	}

	/**
	 * 
	 * ���� update post
	 * 
	 * @param dto
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/club/notice/update", method = RequestMethod.POST)
	public String updateComplete(MainNoticeDTO dto, RedirectAttributes rttr) throws Exception {
		System.out.println("����: " + dto.toString());
		service.modify(dto);

		rttr.addFlashAttribute("msg", "UPSUCCESS");

		return "redirect:/club/notice/main";
	}

	/**
	 * ���� delete get
	 * 
	 * @param bno
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/club/notice/delete")
	public String delete(Integer main_notice_no, RedirectAttributes rttr) throws Exception {
		service.remove(main_notice_no);
		
		rttr.addFlashAttribute("msg", "DELSUCCESS");

		return "redirect:/club/notice/main";
	}

	/**
	 * ����,���� reply add post
	 * 
	 * @param dto
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/club/noticeReply/register", method = RequestMethod.POST)
	public String registerReply(Model model, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		System.out.println("controller called...");
		String parent_no = req.getParameter("parent_no");
		String content = req.getParameter("main_notice_re_content");
		int main_notice_no = Integer.parseInt(req.getParameter("main_notice_no"));

		// ���� ����
		int mem_no = Integer.parseInt(req.getParameter("mem_no"));
		String main_notice_re_writer = req.getParameter("main_notice_re_writer");

		// DTO��ü������ ����
		MainNoticeReplyDTO dto = new MainNoticeReplyDTO();
		dto.setMain_notice_no(main_notice_no);
		dto.setMain_notice_re_content(content);

		if (parent_no.equals("parent")) {
			dto.setMem_no(mem_no);
			dto.setMain_notice_re_writer(main_notice_re_writer);
			System.out.println(dto.toString());
			service.createReply(dto);
		} else {
			dto.setMem_no(mem_no);
			dto.setMain_notice_re_writer(main_notice_re_writer);
			System.out.println(dto.toString());
			MainNoticeReplyDTO dto2 = service.MyclubNoticeParentPos(Integer.parseInt(parent_no));
			// System.out.println("parent data called.. : "+dto2.toString());
			// service.updatePos(dto2.getMain_notice_re_pos());
			service.updatePos(dto2);
			dto.setMain_notice_re_pos(dto2.getMain_notice_re_pos());
			dto.setMain_notice_re_depth(dto2.getMain_notice_re_depth());
			service.createReReply(dto);
		}

		// �׽�Ʈ
		// System.out.println(service.listAllReply(main_notice).toString());

		// ��۸���Ʈ
		req.setAttribute("replydto", service.listAllReply(main_notice_no));

		return "/club/notice/json/mainNoticeReplyJson";
	}

	/**
	 * ����,���� ���û���
	 * 
	 * @param req
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/club/noticeReply/delete", method = RequestMethod.POST)
	public String deleteReply(HttpServletRequest req, Model model) throws Exception {

		int re_no = Integer.parseInt(req.getParameter("re_no"));
		// System.out.println(re_no);

		// �θ� info
		MainNoticeReplyDTO dto = service.MyclubNoticeParentPos(re_no);

		// ������ dto set
		dto.setMain_notice_re_writer("999");
		dto.setMain_notice_re_no(re_no);
		dto.setMain_notice_re_content("해당 댓글은 이미 삭제되었습니다.");

		// System.out.println(dto.toString());
		// ���� ȣ��
		service.deleteReply(dto);

		req.setAttribute("result", true);
		req.setAttribute("re_no", re_no);
		req.setAttribute("depth", dto.getMain_notice_re_depth());
		req.setAttribute("writer", dto.getMain_notice_re_writer());

		System.out.println("dto writer:" + dto.getMain_notice_re_writer());
		return "/club/notice/json/mainNoticeReplyDeletejson";

	}

}
