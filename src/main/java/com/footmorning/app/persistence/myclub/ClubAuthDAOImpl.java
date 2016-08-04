package com.footmorning.app.persistence.myclub;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ClubAuthDTO;
import com.footmorning.app.persistence.ClubAuthDAO;

@Repository
public class ClubAuthDAOImpl implements ClubAuthDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "com.footmorning.mappers.clubAuthMapper";

	
	@Override
	public void insert(ClubAuthDTO dto) throws Exception {
		sqlSession.selectList(NAMESPACE + ".insert", dto);
	}

	@Override
	public void update(ClubAuthDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(ClubAuthDTO dto) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", dto);
	}

	@Override
	public List<ClubAuthDTO> listAuthMaster(Integer no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAuthMaster", no);
	}

	@Override
	public List<ClubAuthDTO> listAuthMgr(Integer no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAuthMgr", no);
	}

	@Override
	public List<ClubAuthDTO> listAuthStaff(Integer no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAuthStaff", no);
	}

	@Override
	public List<ClubAuthDTO> listAuthMember(Integer no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAuthMember", no);
	}

}
