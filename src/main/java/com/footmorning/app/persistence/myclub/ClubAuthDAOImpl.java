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
	public ClubAuthDTO getAuthMaster(Integer no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getAuthMaster", no);
	}

	@Override
	public ClubAuthDTO getAuthMgr(Integer no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getAuthMgr", no);
	}

	@Override
	public ClubAuthDTO getAuthStaff(Integer no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getAuthStaff", no);
	}

	@Override
	public ClubAuthDTO getAuthMember(Integer no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getAuthMember", no);
	}
	
	@Override
	public ClubAuthDTO getAuthUser(Integer no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getAuthUser", no);
	}

}
