package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.MemberDTO;

/**
 * 
 * @author ��ҿ�
 *
 */

public interface MemberDAO {
	public String getTime();
	public List<MemberDTO> listAll() throws Exception;
	public void insertMember(MemberDTO dto);
	public void updateMember(MemberDTO dto);
	public void deleteMember(Integer mem_no);
	public MemberDTO getMemberInfo(String mem_email) throws Exception;
	public MemberDTO getWithPW(String mem_email, String mem_pw) throws Exception;
	public MemberDTO getWithNo(Integer mem_no) throws Exception;
	public String getPW(String mem_email, String mem_phone);
	public int getWithClubno(Integer club_no);
}
