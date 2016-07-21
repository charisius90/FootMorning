package com.footmorning.app.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.MemberDTO;

/**
 * 
 * @author ±è¼Ò¿µ
 *
 */

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession sqlSession;	
	private static final String NAMESPACE = "com.footmorning.mappers.memberMapper";
	
	@Override
	public void insertMember(MemberDTO dto) {
		sqlSession.insert(NAMESPACE + ".insertMember");
	}

	@Override
	public void updateMember(MemberDTO dto) {
		sqlSession.update(NAMESPACE + ".updateMember");
	}

	@Override
	public void deleteMember(String mem_no) {
		sqlSession.delete(NAMESPACE + ".deleteMember");
	}

	@Override
	public boolean isCorrectPW(String mem_email, String mem_pw) {
		return false;
	}

	@Override
	public MemberDTO getMemberInfo(String mem_email) {
		return null;
	}

	@Override
	public boolean isMember(String mem_email) {
		return false;
	}

}
