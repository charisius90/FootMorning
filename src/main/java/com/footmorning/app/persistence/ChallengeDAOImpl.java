package com.footmorning.app.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ChallengeDTO;

@Repository
public class ChallengeDAOImpl implements ChallengeDAO {
	
	private static final String NAMESPASE="com.footmorning.mappers.ChallengeMapper";
	
	@Inject
	private SqlSession SqlSession;
	
	@Override
	public void ChallengRegister(ChallengeDTO dto) throws Exception {
		
		SqlSession.insert(NAMESPASE+".register", dto);
		
	}

}
