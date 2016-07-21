package com.footmorning.app.service;

import com.footmorning.app.domain.MemberDTO;

public interface MemberService {
	public void insertMember(MemberDTO dto);
	public void updateMember(MemberDTO dto);
	public void deleteMember(String mem_no);
	public boolean isCorrectPW(String mem_email, String mem_pw);
	public MemberDTO getMemberInfo(String mem_email);
	public boolean isMember(String mem_email);
}
