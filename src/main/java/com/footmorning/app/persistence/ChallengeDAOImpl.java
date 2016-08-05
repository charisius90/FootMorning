package com.footmorning.app.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ChallengeDTO;

@Repository
public class ChallengeDAOImpl implements ChallengeDAO {

	private static final String NAMESPASE = "com.footmorning.mappers.ChallengeMapper";

	@Inject
	private SqlSession SqlSession;

	@Override
	public List<ChallengeDTO> validateUserClubNo(ChallengeDTO dto) throws Exception {
		return SqlSession.selectList(NAMESPASE + ".checkChallenge", dto);
	}

	@Override
	public void ChallengeRegister(ChallengeDTO dto) throws Exception {
		SqlSession.insert(NAMESPASE + ".register", dto);
	}

	@Override
	public List<ChallengeDTO> SendChallengeListAll(int no) throws Exception {
		return SqlSession.selectList(NAMESPASE + ".sendListAll", no);
	}

	@Override
	public List<ChallengeDTO> ReciveChallengeListAll(int no) throws Exception {
		return SqlSession.selectList(NAMESPASE + ".reciveListAll", no);
	}

	@Override
	public boolean yesChallenge(int challenge_no) throws Exception {
		return SqlSession.update(NAMESPASE + ".updateYes", challenge_no) > 0;
	}

	@Override
	public boolean noChallenge(int challenge_no) throws Exception {
		return SqlSession.update(NAMESPASE + ".updateNo", challenge_no) > 0;
	}

	@Override
	public String myClubName(int club_no) throws Exception {
		return SqlSession.selectOne(NAMESPASE + ".myclubName", club_no);
	}
}
