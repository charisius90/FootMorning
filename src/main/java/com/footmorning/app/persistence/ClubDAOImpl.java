package com.footmorning.app.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ClubDTO;

/**
 * 
 * @author ¹Ú¼öÇ×
 *
 */
@Repository
public class ClubDAOImpl implements ClubDAO {
	
	@Autowired
	private SqlSession sqlSession;	
	private static final String NAMESPACE = "com.footmorning.mappers.clubMapper";

	@Override
	public String getTime() {
		return sqlSession.selectOne(NAMESPACE + ".getTime");
	}

	@Override
	public void insert(ClubDTO dto) {
		sqlSession.insert(NAMESPACE + ".insert", dto);
	}

	@Override
	public void update(ClubDTO dto) {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer no) {
		sqlSession.delete(NAMESPACE + ".delete", no);
	}

	@Override
	public ClubDTO getClubInfo(String name) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getClubInfo", name);
	}

	@Override
	public List<ClubDTO> listAll() throws Exception {
		System.out.println("clubdaoimpl called");
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public ClubDTO getWithNo(Integer no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getWithNo", no);
	}

}
