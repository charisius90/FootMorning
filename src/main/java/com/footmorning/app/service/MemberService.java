package com.footmorning.app.service;

import java.util.List;
import java.util.Map;

import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.util.SearchCriteria;

public interface MemberService {
	public String getTime();
	public List<MemberDTO> listAll() throws Exception;
	public void updateAuth(Map map);
	public void updateLogdate(MemberDTO dto);
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
