package com.footmorning.app.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.ComQnADTO;
import com.footmorning.app.domain.ComQnAReplyDTO;
import com.footmorning.app.service.ComQnAService;
import com.footmorning.app.util.PageMaker;
import com.footmorning.app.util.SearchCriteria;

/**
 * Ŀ�´�Ƽ Q&A �Խ���
 * @author �ڼ���
 */
@Controller
public class ComQnAController {
	private static Logger logger = LoggerFactory.getLogger(ComQnAController.class);
	
	
	@Autowired
	private ComQnAService service;

	
	@RequestMapping("/com/qna/main")
	public String notice(SearchCriteria cri, Model model, HttpServletRequest req) throws Exception {
//		HttpSession session = req.getSession();
		
//		ClubDTO dto = (ClubDTO)session.getAttribute("CLUB_KEY");

		
//		cri.setClub_no(dto.getClub_no());
		model.addAttribute("list", service.listSearchCriteria(cri));


		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
		// System.out.println(service.listAll().toString());
		return "/com/qna/comQnAMain";
		// �ٹ��� myclubNoticeBoardMain2
		// return "/myclub/myclubNotice/myclubNoticeBoardMain2";
	}

	@RequestMapping(value = "/com/qna/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		// logger.info("���", locale);

		return "/com/qna/comQnARegister";
	}

	@RequestMapping(value = "/com/qna/register", method = RequestMethod.POST)
	public String registerComplete(ComQnADTO dto, RedirectAttributes rttr) throws Exception {
		// logger.info("��� �Ϸ� : " + dto.toString());
		System.out.println(dto.toString());
		service.register(dto);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/com/qna/main";
	}

	/**
	 * ���� read get
	 * 
	 * @param bno
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/com/qna/read", method = RequestMethod.GET)
	public String read(Integer com_qna_no, Model model) throws Exception {
		service.updateCount(com_qna_no);
		
		model.addAttribute("dto", service.read(com_qna_no));

		model.addAttribute("replydto", service.listAllReply(com_qna_no));

		return "/com/qna/comQnARead";
	}

	/**
	 * ���� ������Ʈ get
	 * 
	 * @param bno
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/com/qna/update", method = RequestMethod.GET)
	public String update(Integer com_qna_no, Model model) throws Exception {
		model.addAttribute("dto", service.read(com_qna_no));
		System.out.println(service.read(com_qna_no).toString());
		return "/com/qna/comQnAUpdate";
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
	@RequestMapping(value = "/com/qna/update", method = RequestMethod.POST)
	public String updateComplete(ComQnADTO dto, RedirectAttributes rttr) throws Exception {
		System.out.println("����: " + dto.toString());
		service.modify(dto);

		rttr.addFlashAttribute("msg", "UPSUCCESS");

		return "redirect:/com/qna/main";
	}

	/**
	 * ���� delete get
	 * 
	 * @param bno
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/com/qna/delete")
	public String delete(Integer com_qna_no, RedirectAttributes rttr) throws Exception {
		service.remove(com_qna_no);
		rttr.addFlashAttribute("msg", "DELSUCCESS");

		return "redirect:/com/qna/main";
	}

	/**
	 * ����,���� reply add post
	 * 
	 * @param dto
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/com/qnaReply/register", method = RequestMethod.POST)
	public String registerReply(Model model, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		System.out.println("controller called...");
		String parent_no = req.getParameter("parent_no");
		String content = req.getParameter("com_qna_re_content");
		int com_qna_no = Integer.parseInt(req.getParameter("com_qna_no"));

		// ���� ����
		int mem_no = Integer.parseInt(req.getParameter("mem_no"));
		String com_qna_re_writer = req.getParameter("com_qna_re_writer");

		// DTO��ü������ ����
		ComQnAReplyDTO dto = new ComQnAReplyDTO();
		dto.setCom_qna_no(com_qna_no);
		dto.setCom_qna_re_content(content);

		if (parent_no.equals("parent")) {
			dto.setMem_no(mem_no);
			dto.setCom_qna_re_writer(com_qna_re_writer);
			System.out.println("parent"+dto.toString());
			service.createReply(dto);
		} else {
			dto.setMem_no(mem_no);
			dto.setCom_qna_re_writer(com_qna_re_writer);
			System.out.println("child..dto:"+dto.toString());
			ComQnAReplyDTO dto2 = service.MyclubNoticeParentPos(Integer.parseInt(parent_no));
			// System.out.println("parent data called.. : "+dto2.toString());
			// service.updatePos(dto2.getCom_qna_re_pos());
			service.updatePos(dto2);
			dto.setCom_qna_re_pos(dto2.getCom_qna_re_pos());
			dto.setCom_qna_re_depth(dto2.getCom_qna_re_depth());
			service.createReReply(dto);
		}

		// �׽�Ʈ
		// System.out.println(service.listAllReply(com_qna_no).toString());

		// ��۸���Ʈ
		req.setAttribute("replydto", service.listAllReply(com_qna_no));

		return "/com/qna/json/comQnAReplyJson";
		
	}

	/**
	 * ����,���� ���û���
	 * 
	 * @param req
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/com/qnaReply/delete", method = RequestMethod.POST)
	public String deleteReply(HttpServletRequest req, Model model) throws Exception {

		int re_no = Integer.parseInt(req.getParameter("re_no"));
		// System.out.println(re_no);

		// �θ� info
		ComQnAReplyDTO dto = service.MyclubNoticeParentPos(re_no);

		// ������ dto set
		dto.setCom_qna_re_writer("999");
		dto.setCom_qna_re_no(re_no);
		dto.setCom_qna_re_content("해당 댓글은 이미 삭제되었습니다.");

		// System.out.println(dto.toString());
		// ���� ȣ��
		service.deleteReply(dto);

		req.setAttribute("result", true);
		req.setAttribute("re_no", re_no);
		req.setAttribute("depth", dto.getCom_qna_re_depth());
		req.setAttribute("writer", dto.getCom_qna_re_writer());

		System.out.println("dto writer:" + dto.getCom_qna_re_writer());
		return "/com/qna/json/comQnADeleteJson";

	}
}
