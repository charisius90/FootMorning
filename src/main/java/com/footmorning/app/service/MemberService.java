package com.footmorning.app.service;

import com.footmorning.app.domain.MemberDTO;

public interface MemberService {
	public String getTime();
	public void insertMember(MemberDTO dto);
	public void updateMember(MemberDTO dto);
	public void deleteMember(Integer mem_no);
	public MemberDTO getMemberInfo(String mem_email);
	public MemberDTO getWithPW(String mem_email, String mem_pw);
}
