package com.footmorning.app.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.domain.ClubMemberDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.service.ClubMemberService;
import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.MainNoticeService;
import com.footmorning.app.service.MemberService;
import com.footmorning.app.util.ClubPageMaker;
import com.footmorning.app.util.RoleFeeder;
import com.footmorning.app.util.SearchClubCriteria;

/**
 * @author 박수항
 */
@Controller
@RequestMapping("/club/*")
public class ClubController {
	@Autowired
	private ClubService service;
	@Autowired
	private MemberService memberService;
	@Autowired
	private ClubMemberService clubMemberService;
	@Inject
	private MainNoticeService MainNoticeService;
	@Autowired
	RoleFeeder roles;
	
	// 회원 등급 파이널 변수 모음
	public static final String GRADE_ADMIN = "0"; // 서비스 운영진
	public static final String GRADE_MASTER = "1"; // 클럽마스터
	public static final String GRADE_MANAGER = "2"; // 클럽매니저
	public static final String GRADE_STAFF = "3"; // 클럽스탭
	public static final String GRADE_MEMBER = "4"; // 클럽소속회원
	public static final String GRADE_NORMAL = "5"; // 일반회원
	
	@RequestMapping("clubList")
	public void listGET(SearchClubCriteria clubcri, Model model) throws Exception{
		try {
			model.addAttribute("list", service.listSearchClubCriteria(clubcri));
			
			System.out.println(service.listSearchClubCriteria(clubcri).toString());
			
			ClubPageMaker cpageMaker = new ClubPageMaker();
			
			cpageMaker.setClubcri(clubcri);
			cpageMaker.setTotalCount(service.listSearchClubCount(clubcri));
			
			model.addAttribute("cpageMaker", cpageMaker);
		}
		catch (Exception err) {
			System.out.println("clubListAll : " + err);
		}
		//클럽목록
		model.addAttribute("club", service.listAll());
		//추천클럽 : 클럽인원수 리스트.
		model.addAttribute("popular", service.popularityListAll());
		//클럽공지사항 : 
		model.addAttribute("notice", MainNoticeService.listAll());
		
	}
	
	@RequestMapping("clubRegister")
	public void registerGET(Model model) throws Exception{
		
		model.addAttribute("club", service.listAll());
		//추천클럽 : 클럽인원수 리스트.
		model.addAttribute("popular", service.popularityListAll());
		//클럽공지사항 : 
		model.addAttribute("notice", MainNoticeService.listAll());
		
	}
	
	@RequestMapping(value="clubRegister", method=RequestMethod.POST)
	public String registerPOST(ClubDTO dto, String mem_email, Model model, HttpServletRequest req){
		MultipartFile uploadfile = dto.getUploadfile();
		String root = req.getSession().getServletContext().getRealPath("/");
		String savePath = root + "resources/upload/";
		String originalFileName = null;
        String storedFileName = null;
        
        File file = new File(savePath);
        if(file.exists() == false){
        	file.mkdirs();
        }
        
		if(uploadfile!=null){
			originalFileName = uploadfile.getOriginalFilename();
            storedFileName = System.currentTimeMillis() + "_" + originalFileName;
             
            file = new File(savePath + storedFileName);
            try {
				uploadfile.transferTo(file);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dto.setClub_image(file.getName());
		service.insert(dto);
		System.out.println("clubRegister : " + dto.toString());
		
		MemberDTO member = null;
		try {
			member = memberService.getMemberInfo(mem_email);
			member.setMem_grade(GRADE_MASTER);
			memberService.updateMember(member);
			
			Map map = new HashMap();
			map.put("mem_email", member.getMem_email());
			map.put("role", new SimpleGrantedAuthority(roles.ROLE_CLUB).toString());
			memberService.updateAuth(map);
			
			WebUtils.setSessionAttribute(req, "USER_KEY", member);
			
			// 클럽멤버 테이블에 마스터 추가
			ClubMemberDTO clubMember = new ClubMemberDTO();
			clubMember.setClub_no(member.getClub_no());
			clubMember.setMem_no(member.getMem_no());
			clubMember.setMem_gender(member.getMem_gender());
			clubMember.setMem_email(member.getMem_email());
			clubMember.setMem_phone(member.getMem_phone());
			clubMember.setMem_grade(member.getMem_grade());
			clubMember.setMem_name(member.getMem_name());
			clubMember.setMem_birth(member.getMem_birth());
			clubMember.setClub_mem_flag("TRUE");
			clubMemberService.insert(clubMember);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/myclub/myclubMain?no=" + member.getClub_no();
	}
	
	@RequestMapping(value="duplicationCheck", method=RequestMethod.POST)
	public @ResponseBody String duplicationCheck(String club_name) throws Exception {
		String result = null;
		ClubDTO club = service.getClubInfo(club_name);
		if(club!=null){
			result = "no";
		}
		else{
			result = "yes";
		}
		return result;
	}
	
}
