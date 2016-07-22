package com.footmorning.app.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.MemberDTO;

/**
 * 
 * @author ��ҿ�
 *
 */
@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
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
	public MemberDTO getMemberInfo(String mem_email) {
		return sqlSession.selectOne(NAMESPACE + ".getMemberInfo", mem_email);
	}

	@Override
	public MemberDTO getWithPW(String mem_email, String mem_pw) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mem_email", mem_email);
		paramMap.put("mem_pw", mem_pw);
		return sqlSession.selectOne(NAMESPACE + ".getWithPW", paramMap);
	}

	@Override
	public String getTime() {
		return sqlSession.selectOne(NAMESPACE + ".getTime");
	}

}
