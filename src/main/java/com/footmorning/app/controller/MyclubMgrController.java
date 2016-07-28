package com.footmorning.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.service.ClubService;

@Controller
@RequestMapping("/myclubMgr/*")
public class MyclubMgrController {
	@Autowired
	private ClubService service;
	
	/**
	 * 기본정보 변경 페이지
	 */
	@RequestMapping("myclubMgrInfo")
	public String myclubInfoMgr(HttpServletRequest req){
		MemberDTO member = (MemberDTO)WebUtils.getSessionAttribute(req, "USER_KEY");
		ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
		
		// 회원등급
		int grade = Integer.parseInt(member.getMem_grade());
		// 자기 클럽 관리페이지 이동 요청인지 확인
		boolean flag = member.getClub_no().equals(club.getClub_no());
		if(grade<3 && flag){
			return "/myclubMgr/myclubMgrInfo";
		}
		
		return "/myclub/myclubMain";
	}
	
	@RequestMapping(value="myclubMgrInfo", method=RequestMethod.POST)
	public void myclubInfoMgrComplete(ClubDTO dto){
		System.out.println("myclubMgrInfo : " + dto);
		service.update(dto);
	}
	
	/**
	 * 가입조건관리
	 */
	@RequestMapping("myclubMgrJoinCondition")
	public void myclubMgrJoinCondition(){
		
	}
	
	/**
	 * 클럽대문관리
	 */
	@RequestMapping("myclubMgrMain")
	public void myclubMgrMain(){
		
	}
	
	/**
	 * 클럽메뉴관리
	 */
	@RequestMapping("myclubMgrMenu")
	public void myclubMgrMenu(){
		
	}
	
	/**
	 * 클럽멤버관리
	 */
	@RequestMapping("myclubMgrMember")
	public void myclubMgrMember(){
		
	}
	
	/**
	 * 가입신청관리
	 */
	@RequestMapping("myclubMgrRegister")
	public void myclubMgrRegister(){
		
	}
	
	/**
	 * 직책/등급관리
	 */
	@RequestMapping("myclubMgrMemberGrade")
	public void myclubMgrMemberGrade(){
		
	}
	
	/**
	 * 탈퇴멤버관리
	 */
	@RequestMapping("myclubMgrOutMember")
	public void myclubMgrOutMember(){
		
	}
	
	/**
	 * 클럽폐쇄
	 */
	@RequestMapping("myclubMgrClosing")
	public void myclubMgrClosing(){
		
	}
	
	/**
	 * 클럽양도
	 */
	@RequestMapping("myclubMgrTransfer")
	public void myclubMgrTransfer(){
		
	}
}
