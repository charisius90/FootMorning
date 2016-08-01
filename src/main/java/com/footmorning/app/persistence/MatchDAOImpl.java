package com.footmorning.app.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.MatchDTO;

@Repository
public class MatchDAOImpl implements MatchDAO {
	
	private static final String NAMESPASE="com.footmorning.mappers.MatchMapper";
	
	@Inject
	private SqlSession SqlSession;

	@Override
	public void matchRegister(MatchDTO dto) throws Exception {
		SqlSession.insert(NAMESPASE+".register", dto);
	}

	@Override
	public List<MatchDTO> matchListAll() throws Exception {
		
		return SqlSession.selectList(NAMESPASE+".listAll");
	}

}
