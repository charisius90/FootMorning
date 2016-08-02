package com.footmorning.app.persistence;

import java.util.HashMap;
import java.util.List;
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
	public MemberDTO getMemberInfo(String mem_email) throws Exception{
		MemberDTO dto = sqlSession.selectOne(NAMESPACE + ".getMemberInfo", mem_email);
		
		if(dto == null){
			throw new Exception();
		}
		
		return dto; 
	}

	@Override
	public MemberDTO getWithPW(String mem_email, String mem_pw) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mem_email", mem_email);
		paramMap.put("mem_pw", mem_pw);
		
		MemberDTO dto = sqlSession.selectOne(NAMESPACE + ".getWithPW", paramMap);
		
		if(dto == null){
			throw new Exception();
		}
		
		return dto;
	}
	
	@Override
	public String getPW(String mem_email, String mem_phone) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mem_email", mem_email);
		paramMap.put("mem_phone", mem_phone);
		return sqlSession.selectOne(NAMESPACE + ".getPW", paramMap);
	}

	@Override
	public String getTime() {
		return sqlSession.selectOne(NAMESPACE + ".getTime");
	}

	@Override
	public int getWithClubno(Integer club_no) {
		return sqlSession.selectOne(NAMESPACE + ".getWithClubno", club_no);
	}

	@Override
	public MemberDTO getWithNo(Integer mem_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getWithNo", mem_no);
	}

	@Override
	public List<MemberDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

}
