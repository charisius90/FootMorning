package com.footmorning.app.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.persistence.MemberDAO;
import com.footmorning.app.util.SearchCriteria;

/**
 * 
 * @author ��ҿ�
 *
 */

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO memberDAO; 
	
	@Override
	public void insertMember(MemberDTO dto) {
		memberDAO.insertMember(dto);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		memberDAO.updateMember(dto);
	}

	@Override
	public void deleteMember(Integer mem_no) {
		memberDAO.deleteMember(mem_no);
	}

	@Override
	public MemberDTO getMemberInfo(String mem_email) throws Exception{
		return memberDAO.getMemberInfo(mem_email);
	}
	
	@Override
	public MemberDTO getWithPW(String mem_email, String mem_pw) throws Exception{
		return memberDAO.getWithPW(mem_email, mem_pw);
	}

	@Override
	public String getTime() {
		return memberDAO.getTime();
	}

	@Override
	public String getPW(String mem_email, String mem_phone) {
		return memberDAO.getPW(mem_email, mem_phone);
	}

	@Override
	public int getWithClubno(Integer club_no) {
		return memberDAO.getWithClubno(club_no);
	}

	@Override
	public MemberDTO getWithNo(Integer mem_no) throws Exception {
		return memberDAO.getWithNo(mem_no);
	}

	@Override
	public List<MemberDTO> listAll() throws Exception {
		return memberDAO.listAll();
	}

	@Override
	public List<MemberDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return memberDAO.listSearchCriteria(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return memberDAO.listSearchCount(cri);
	}

}
