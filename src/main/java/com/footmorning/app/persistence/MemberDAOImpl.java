package com.footmorning.app.persistence;

import java.util.HashMap;
import java.util.Map;

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
		sqlSession.insert(NAMESPACE + ".insertMember", dto);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		sqlSession.update(NAMESPACE + ".updateMember", dto);
	}

	@Override
	public void deleteMember(Integer mem_no) {
		sqlSession.delete(NAMESPACE + ".deleteMember", mem_no);
	}

	@Override
	public boolean isCorrectPW(String mem_email, String mem_pw) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mem_email", mem_email);
		paramMap.put("mem_pw", mem_pw);
		return sqlSession.selectOne(NAMESPACE + ".isCorrectPW", paramMap);
	}

	@Override
	public MemberDTO getMemberInfo(String mem_email) {
		return sqlSession.selectOne(NAMESPACE + ".getMemberInfo", mem_email);
	}

	@Override
	public boolean isMember(String mem_email) {
		return sqlSession.selectOne(NAMESPACE + ".isMember", mem_email);
	}

}
