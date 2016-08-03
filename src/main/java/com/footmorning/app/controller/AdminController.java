package com.footmorning.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.ComBoastService;
import com.footmorning.app.service.ComDiscussionKorService;
import com.footmorning.app.service.ComDiscussionWorldService;
import com.footmorning.app.service.ComFreeService;
import com.footmorning.app.service.ComGalleryService;
import com.footmorning.app.service.ComQnAService;
import com.footmorning.app.service.ComVideoService;
import com.footmorning.app.service.MemberService;
import com.footmorning.app.util.PageMaker;
import com.footmorning.app.util.SearchCriteria;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private MemberService memberService;
	@Autowired
	private ClubService clubService;
	@Autowired
	private ComBoastService comboastService;
	@Autowired
	private ComDiscussionKorService comdiscussionkorService;
	@Autowired
	private ComDiscussionWorldService comdiscussionworldService;
	@Autowired
	private ComFreeService comfreeService;
	@Autowired
	private ComGalleryService comgalleryService;
	@Autowired
	private ComVideoService comvideoService;
	@Autowired
	private ComQnAService comqnaService;
	
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
	public void adminMemberAll(SearchCriteria cri, Model model){
		try{
			model.addAttribute("list", memberService.listSearchCriteria(cri));
			
			int total = memberService.listSearchCount(cri);
			
			model.addAttribute("total", total);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(total);
			
			model.addAttribute("pageMaker", pageMaker);
			
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
	public void adminClubAll(SearchCriteria cri, Model model){
		try {
			model.addAttribute("list", clubService.listAll());
			
			model.addAttribute("list", clubService.listSearchCriteria(cri));
			
			int total = clubService.listSearchCount(cri);
			
			model.addAttribute("total", total);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(total);
			
			model.addAttribute("pageMaker", pageMaker);
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
	public void adminCommunityAll(SearchCriteria cri, Model model, HttpServletRequest req){
		try {
			String select = req.getParameter("select");
			System.out.println(select);
			
			int total = 0;
			
			if(true){
				model.addAttribute("listcomboast", comboastService.listSearchCriteria(cri));
				
				total = memberService.listSearchCount(cri);
				
				model.addAttribute("total", total);
			}
//			else if(){
//				model.addAttribute("listkor", comdiscussionkorService.listSearchCriteria(cri));
//				
//				total = memberService.listSearchCount(cri);
//				
//				model.addAttribute("total", total);
//			}
//			else if(){
//				model.addAttribute("listcomworld", comdiscussionworldService.listSearchCriteria(cri));
//				
//				total = memberService.listSearchCount(cri);
//				
//				model.addAttribute("total", total);
//			}
//			else if(){
//				model.addAttribute("listfree", comfreeService.listSearchCriteria(cri));
//				
//				total = memberService.listSearchCount(cri);
//				
//				model.addAttribute("total", total);
//			}
//			else if(){
//				model.addAttribute("listgallery", comgalleryService.listSearchCriteria(cri));
//				
//				total = memberService.listSearchCount(cri);
//				
//				model.addAttribute("total", total);
//			}
//			else if(){
//				model.addAttribute("listvideo", comvideoService.listSearchCriteria(cri));
//				
//				total = memberService.listSearchCount(cri);
//				
//				model.addAttribute("total", total);
//			}
			
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(total);
			
			model.addAttribute("pageMaker", pageMaker);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	/**
	 * 커뮤니티 신고 접수 관리
	 */
	@RequestMapping("adminCommunityDeclaration")
	public void adminCommunityDeclaration(SearchCriteria cri, Model model){
		try {
//			model.addAttribute("list", );
			
			int total =0;
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(total);
			
			model.addAttribute("pageMaker", pageMaker);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 커뮤니티 신고 접수 관리 (새 창)
	 */
	@RequestMapping("adminCommunityDeclarationPopup")
	public void adminCommunityDeclarationPopup(){}
	
	/**
	 * 커뮤니티 QnA 관리
	 */
	@RequestMapping("adminCommunityQnA")
	public void adminCommunityQnA(SearchCriteria cri, Model model){
		try {
			model.addAttribute("list", comqnaService.listSearchCriteria(cri));
			
			int total = comqnaService.listSearchCount(cri);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(total);
			
			model.addAttribute("pageMaker", pageMaker);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
