package com.footmorning.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.relation.Role;
import javax.management.relation.RoleStatus;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.ComBoastService;
import com.footmorning.app.service.ComDiscussionKorService;
import com.footmorning.app.service.ComDiscussionWorldService;
import com.footmorning.app.service.ComFreeService;
import com.footmorning.app.service.ComGalleryService;
import com.footmorning.app.service.ComQnAService;
import com.footmorning.app.service.ComVideoService;
import com.footmorning.app.service.MemberService;
import com.footmorning.app.util.AlbumPageMaker;
import com.footmorning.app.util.AlbumSearchCriteria;
import com.footmorning.app.util.ClubPageMaker;
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
	
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	
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
	
	@RequestMapping(value="adminEmpAdd", method=RequestMethod.POST)
	public String adminInquriyAddPsot(MemberDTO dto, RedirectAttributes rttr){
		try {
		
			memberService.insertMember(dto);
		
			MemberDTO member;

			member = memberService.getMemberInfo(dto.getMem_email());
			member.setMem_grade("0");
			memberService.updateMember(member);
			
			Map map = new HashMap();
			map.put("mem_email", member.getMem_email());
			map.put("role", new SimpleGrantedAuthority(ROLE_ADMIN).toString());
			memberService.updateAuth(map);
		
			rttr.addFlashAttribute("msg", "SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/admin/adminEmpAdd";
	}
	
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
	public void adminCommunityAll(SearchCriteria cri, Model model, String selectType){
		try {
			
			PageMaker pageMaker = new PageMaker();
			
			System.out.println(selectType);
			
			System.out.println(cri.toString());
			
			int total = 0;

			if(selectType == null){
				
				pageMaker.setCri(cri);
				model.addAttribute("pageMaker", pageMaker);
				return;
			}
			
			// 자랑
			if(selectType.equals("boast")){
				System.out.println("boast 게시판");
				model.addAttribute("listcomboast", comboastService.listSearchCri(cri));
				
				System.out.println(comboastService.listSearchCri(cri).toString());
				total = comboastService.listSearchCount(cri);
				
				model.addAttribute("total", total);
				
				pageMaker.setCri(cri);
				pageMaker.setTotalCount(total);
					
				model.addAttribute("pageMaker", pageMaker);
			}
			// 갤러리
			else if(selectType.equals("gallery")){
				System.out.println("gallery 게시판");
				
				model.addAttribute("listgallery", comgalleryService.listAdmin(cri));
				
				total = comgalleryService.listAdminCount(cri);
				
				model.addAttribute("total", total);
				
				pageMaker.setCri(cri);
				pageMaker.setTotalCount(total);
					
				model.addAttribute("pageMaker", pageMaker);
			}
			// 동영상
			else if(selectType.equals("video")){
				System.out.println("video 게시판");
				
				model.addAttribute("listvideo", comvideoService.listAdmin(cri));
				
				total = comvideoService.listAdminCount(cri);
				
				model.addAttribute("total", total);
				
				pageMaker.setCri(cri);
				pageMaker.setTotalCount(total);
					
				model.addAttribute("pageMaker", pageMaker);
			}
			// 국내
			else if(selectType.equals("kor")){
				System.out.println("kor 게시판");
				model.addAttribute("listkor", comdiscussionkorService.listSearchCriteria(cri));
				
				total = comdiscussionkorService.listSearchCount(cri);
				
				model.addAttribute("total", total);
				
				pageMaker.setCri(cri);
				pageMaker.setTotalCount(total);
					
				model.addAttribute("pageMaker", pageMaker);
			}
			// 해외
			else if(selectType.equals("world")){
				System.out.println("world 게시판");
				model.addAttribute("listworld", comdiscussionworldService.listSearchCriteria(cri));
				
				System.out.println(comdiscussionworldService.listSearchCriteria(cri).toString());
				
				total = comdiscussionworldService.listSearchCount(cri);
				
				model.addAttribute("total", total);
				
				pageMaker.setCri(cri);
				pageMaker.setTotalCount(total);
					
				model.addAttribute("pageMaker", pageMaker);
			}
			// 자유
			else if(selectType.equals("free")){
				System.out.println("free 게시판");
				model.addAttribute("listfree", comfreeService.listSearchCriteria(cri));
				
				total = comfreeService.listSearchCount(cri);
				
				model.addAttribute("total", total);
				
				pageMaker.setCri(cri);
				pageMaker.setTotalCount(total);
					
				model.addAttribute("pageMaker", pageMaker);
			}
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	/**
	 *  전체 커뮤니티 게시판 관리(글삭제)
	 */
//	@RequestMapping(value="adminCommunityAll", method=RequestMethod.POST)
//	public void adminCommunityDelete(@RequestBody List<Map<String, Object>> chkArr){
//		
//		for(Map map : chkArr){
//			System.out.println(map);
//		}
//		
//	}
	
	
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
