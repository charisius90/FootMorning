package com.footmorning.app.controller;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.service.ComBoastService;
import com.footmorning.app.service.ComDiscussionKorService;
import com.footmorning.app.service.ComDiscussionWorldService;
import com.footmorning.app.service.ComFreeService;
import com.footmorning.app.service.ComGalleryService;
import com.footmorning.app.service.ComQnAService;
import com.footmorning.app.service.ComVideoService;
import com.footmorning.app.service.MemberService;
import com.footmorning.app.service.MyclubAlbumService;
import com.footmorning.app.service.MyclubFreeService;
import com.footmorning.app.service.MyclubNoticeService;
import com.footmorning.app.service.MyclubTeamService;
import com.footmorning.app.service.MyclubVideoService;

@Controller
@RequestMapping("/mypage/*")
public class MyPageController {
	@Inject
	private MemberService service;
	@Inject
	private ComBoastService comboastservice;
	@Inject
	private ComDiscussionKorService comdiscussionkorservice;
	@Inject
	private ComDiscussionWorldService comdiscussionworldservice;
	@Inject
	private ComFreeService comfreeservice;
	@Inject
	private ComGalleryService comgalleryservice;
	@Inject
	private ComVideoService comvideoservice;
	@Inject
	private ComQnAService comqnaservice;
	@Inject
	private MyclubAlbumService myclubalbumservice;
	@Inject
	private MyclubFreeService myclubfreeservice;
	@Inject
	private MyclubNoticeService myclubnoticeservice;
	@Inject
	private MyclubTeamService myclubteamservice;
	@Inject
	private MyclubVideoService myclubvideoservice;
	
	
	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
	/**
	 * 회원정보 페이지
	 * @author 김소영
	 */
	@RequestMapping("myPageProfile")
	public void myPageProfile(){
	}

	@RequestMapping(value="myPageProfile", method=RequestMethod.POST)
	public String myPageProfileUpdate(MemberDTO member, HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		MemberDTO dto = (MemberDTO)session.getAttribute("USER_KEY");
		dto.setMem_name(member.getMem_name());
		dto.setMem_birth(member.getMem_birth());
		dto.setMem_gender(member.getMem_gender());
		dto.setMem_phone(member.getMem_phone());
		dto.setMem_addr(member.getMem_addr());
		
		service.updateMember(dto);
		logger.info("mypageProfileUpdate : " + dto.toString());
		
		WebUtils.setSessionAttribute(req, "USER_KEY", dto);
		
		return "redirect:/mypage/myPageProfile";
	}
	
	/**
	 * 내가 작성한 글 페이지
	 * @author 박규채
	 */
	@RequestMapping("myPageArticles")
	public void myPageArticles(Model model, HttpServletRequest req){
		try {
			HttpSession session = req.getSession();
			
			MemberDTO dto = (MemberDTO)session.getAttribute("USER_KEY");
			System.out.println(dto.getMem_no());
			
			
			model.addAttribute("comboast", comboastservice.listMypostAll(Integer.parseInt(dto.getMem_no())));
			model.addAttribute("comkor", comdiscussionkorservice.listMypostAll(Integer.parseInt(dto.getMem_no())));
			model.addAttribute("comworld", comdiscussionworldservice.listMypostAll(Integer.parseInt(dto.getMem_no())));
			model.addAttribute("comfree", comfreeservice.listMypostAll(Integer.parseInt(dto.getMem_no())));
			model.addAttribute("comgallery", comgalleryservice.listMypostAll(Integer.parseInt(dto.getMem_no())));
			model.addAttribute("comqna", comqnaservice.listMypostAll(Integer.parseInt(dto.getMem_no())));
			model.addAttribute("comvideo", comvideoservice.listMypostAll(Integer.parseInt(dto.getMem_no())));

			model.addAttribute("myclubalbum", myclubalbumservice.listMypostAll(Integer.parseInt(dto.getMem_no())));
			model.addAttribute("myclubfree", myclubfreeservice.listMypostAll(Integer.parseInt(dto.getMem_no())));
			model.addAttribute("myclubnotice", myclubnoticeservice.listMypostAll(Integer.parseInt(dto.getMem_no())));
			
			System.out.println(myclubnoticeservice.listMypostAll(Integer.parseInt(dto.getMem_no())).toString());
			
			model.addAttribute("myclubteam", myclubteamservice.listMypostAll(Integer.parseInt(dto.getMem_no())));
			model.addAttribute("myclubvideo", myclubvideoservice.listMypostAll(Integer.parseInt(dto.getMem_no())));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 비밀번호 변경 페이지
	 * @author 김소영
	 */
	@RequestMapping("myPagePW")
	public void myPagePW(){
	}
	
	@RequestMapping(value="myPagePW", method=RequestMethod.POST)
	public String myPagePwUpdate(String mem_oldPw, String mem_newPw, String mem_newPw_check, HttpServletRequest req, RedirectAttributes rttr){
		HttpSession session = req.getSession();
		
		MemberDTO dto = (MemberDTO)session.getAttribute("USER_KEY");
		if(mem_oldPw.equals(dto.getMem_pw())){
			if(mem_newPw.equals(mem_newPw_check)){
				dto.setMem_pw(mem_newPw);
				service.updateMember(dto);
				session.invalidate();
				logger.info("myPagePwUpdate : " + dto.getMem_pw());
				return "redirect:/member/memberLogin";
			}
			else{
				rttr.addFlashAttribute("msg", "새 비밀번호를 확인하세요.");
				return "redirect:/mypage/myPagePW";
			}
		}
		rttr.addFlashAttribute("msg", "현재 비밀번호를 잘못 입력하셨습니다.");
		return "redirect:/mypage/myPagePW";
	}
	
}
