package com.footmorning.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myclubMgr/*")
public class MyclubMgrController {
	/**
	 * 기본정보관리
	 */
	@RequestMapping("myclubInfoMgr")
	public void myclubInfoMgr(){
		
	}
	
	/**
	 * 가입조건관리
	 */
	@RequestMapping("myclubJoinConditionMgr")
	public void myclubJoinConditionMgr(){
		
	}
	
	/**
	 * 클럽대문관리
	 */
	@RequestMapping("myclubClubMainMgr")
	public void myclubClubMainMgr(){
		
	}
	
	/**
	 * 클럽메뉴관리
	 */
	@RequestMapping("myclubClubMenuMgr")
	public void myclubClubMenuMgr(){
		
	}
	
	/**
	 * 클럽멤버관리
	 */
	@RequestMapping("myclubMemberMgr")
	public void myclubMemberMgr(){
		
	}
	
	/**
	 * 가입신청관리
	 */
	@RequestMapping("myclubRegisterMgr")
	public void myclubRegisterMgr(){
		
	}
	
	/**
	 * 등급/직책관리
	 */
	@RequestMapping("myclubMemberGradeMgr")
	public void myclubMemberGradeMgr(){
		
	}
	
	/**
	 * 탈퇴멤버관리
	 */
	@RequestMapping("myclubOutMemberMgr")
	public void myclubOutMemberMgr(){
		
	}
	
	/**
	 * 클럽폐쇄
	 */
	@RequestMapping("myclubClubClosingMgr")
	public void myclubClubClosingMgr(){
		
	}
	
	/**
	 * 클럽양도
	 */
	@RequestMapping("myclubClubTransferMgr")
	public void myclubClubTransferMgr(){
		
	}
}
