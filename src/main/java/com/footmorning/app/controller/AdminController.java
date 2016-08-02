package com.footmorning.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.MemberService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private MemberService memberService;
	@Autowired
	private ClubService clubService;
	
	
	/**
	 * 관리 홈
	 */
	@RequestMapping("adminMain")
	public void adminHome(){}
	
	/**
	 * 전체 직원 관리
	 */
	@RequestMapping("adminEmpAll")
	public void adminInquriyMgr(){}
	
	/**
	 * 직원 등록
	 */
	@RequestMapping("adminEmpAdd")
	public void adminInquriyAdd(){}
	
	/**
	 * 전체 회원 관리
	 */
	@RequestMapping("adminMemberAll")
	public void adminMemberAll(Model model){
		try{
			model.addAttribute("list", memberService.listAll());
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 회원 신고 접수 관리
	 */
	@RequestMapping("adminMemberDeclaration")
	public void adminMemberDeclaration(){}
	
	/**
	 * 회원 신고 접수 관리 (새 창)
	 */
	@RequestMapping("adminMemberDeclarationPopup")
	public void adminMemberDeclarationPopup(){}
	
	/**
	 * 전체 클럽 관리
	 */
	@RequestMapping("adminClubAll")
	public void adminClubAll(Model model){
		try {
			model.addAttribute("list", clubService.listAll());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 클럽 신고 접수 관리
	 */
	@RequestMapping("adminClubDeclaration")
	public void adminClubDeclaration(){}
	
	/**
	 * 클럽 신고 접수 관리 (새 창)
	 */
	@RequestMapping("adminClubDeclarationPopup")
	public void adminClubDeclarationPopup(){}
	
	/**
	 * 전체 커뮤니티 게시판 관리
	 */
	@RequestMapping("adminCommunityAll")
	public void adminCommunityAll(){}
	
	/**
	 * 커뮤니티 신고 접수 관리
	 */
	@RequestMapping("adminCommunityDeclaration")
	public void adminCommunityDeclaration(){}
	
	/**
	 * 커뮤니티 신고 접수 관리 (새 창)
	 */
	@RequestMapping("adminCommunityDeclarationPopup")
	public void adminCommunityDeclarationPopup(){}
	
	/**
	 * 커뮤니티 QnA 관리
	 */
	@RequestMapping("adminCommunityQnA")
	public void adminCommunityQnA(){}
	
	/**
	 * 커뮤니티 QnA 관리 (새 창)
	 */
	@RequestMapping("adminCommunityQnAPopup")
	public void adminCommunityQnAPopup(){}
	
	/**
	 * 꾸미기 광고 관리
	 */
	@RequestMapping("adminAd")
	public void adminAdMgr(){}
	
	/**
	 * 꾸미기 디자인 관리
	 */
	@RequestMapping("adminDesign")
	public void adminDesignMgr(){}
}
