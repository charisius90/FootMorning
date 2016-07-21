package com.footmorning.app.persistence;

import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.MemberDTO;

/**
 * 
 * @author ±è¼Ò¿µ
 *
 */

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Override
	public void insertMember(MemberDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMember(String mem_no) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCorrectPW(String mem_email, String mem_pw) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MemberDTO getMemberInfo(String mem_email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMember(String mem_email) {
		// TODO Auto-generated method stub
		return false;
	}

}
