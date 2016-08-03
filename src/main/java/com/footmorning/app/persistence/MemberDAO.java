package com.footmorning.app.persistence;

import java.util.List;
import java.util.Map;

import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.util.SearchCriteria;

/**
 * 
 * @author박수항
 *
 */

public interface MemberDAO {
	public String getTime();
	public List<MemberDTO> listAll() throws Exception;
	public void insertAuth(Map map);
	public void insertMember(MemberDTO dto);
	public void updateMember(MemberDTO dto);
	public void deleteMember(Integer mem_no);
	public MemberDTO getMemberInfo(String mem_email) throws Exception;
	public MemberDTO getWithPW(String mem_email, String mem_pw) throws Exception;
	public MemberDTO getWithNo(Integer mem_no) throws Exception;
	public String getPW(String mem_email, String mem_phone);
	public int getWithClubno(Integer club_no);
	public List<MemberDTO> listSearchCriteria(SearchCriteria cri) throws Exception;
	public int listSearchCount(SearchCriteria cri) throws Exception;
}
