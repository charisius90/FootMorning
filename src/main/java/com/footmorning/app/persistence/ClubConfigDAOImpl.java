package com.footmorning.app.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ClubConfigDTO;

@Repository
public class ClubConfigDAOImpl implements ClubConfigDAO {
	@Autowired
	private SqlSession sqlSession;	
	private static final String NAMESPACE = "com.footmorning.mappers.clubConfigMapper";

	@Override
	public String getTime() {
		return sqlSession.selectOne(NAMESPACE + ".getTime");
	}

	@Override
	public void insert(ClubConfigDTO dto) {
		sqlSession.insert(NAMESPACE + ".insert", dto);
	}

	@Override
	public void update(ClubConfigDTO dto) {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer no) {
		sqlSession.update(NAMESPACE + ".delete", no);
	}

	@Override
	public ClubConfigDTO getWithClubNo(Integer no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getWithClubNo", no);
	}

	@Override
	public List<ClubConfigDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

}
