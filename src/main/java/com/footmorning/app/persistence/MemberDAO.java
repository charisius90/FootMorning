package com.footmorning.app.persistence;

import com.footmorning.app.domain.MemberDTO;

/**
 * 
 * @author ±è¼Ò¿µ
 *
 */

public interface MemberDAO {
	public void insertMember(MemberDTO dto);
	public void updateMember(MemberDTO dto);
	public void deleteMember(String mem_no);
	public boolean isCorrectPW(String mem_email, String mem_pw);
	public MemberDTO getMemberInfo(String mem_email);
	public boolean isMember(String mem_email);
}
