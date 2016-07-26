package com.footmorning.app.persistence;

import com.footmorning.app.domain.MemberDTO;

/**
 * 
 * @author ��ҿ�
 *
 */

public interface MemberDAO {
	public String getTime();
	public void insertMember(MemberDTO dto);
	public void updateMember(MemberDTO dto);
	public void deleteMember(Integer mem_no);
	public MemberDTO getMemberInfo(String mem_email);
	public MemberDTO getWithPW(String mem_email, String mem_pw);
	public String getPW(String mem_email, String mem_phone);
}
