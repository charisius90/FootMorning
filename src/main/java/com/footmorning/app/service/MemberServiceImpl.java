package com.footmorning.app.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.persistence.MemberDAO;

/**
 * 
 * @author ±è¼Ò¿µ
 *
 */

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO dao; 
	
	@Override
	public void insertMember(MemberDTO dto) {
		dao.insertMember(dto);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		dao.updateMember(dto);
	}

	@Override
	public void deleteMember(String mem_no) {
		dao.deleteMember(mem_no);
	}

	@Override
	public boolean isCorrectPW(String mem_email, String mem_pw) {
		return dao.isCorrectPW(mem_email, mem_pw);
	}

	@Override
	public MemberDTO getMemberInfo(String mem_email) {
		return dao.getMemberInfo(mem_email);
	}

	@Override
	public boolean isMember(String mem_email) {
		return dao.isMember(mem_email);
	}

}
