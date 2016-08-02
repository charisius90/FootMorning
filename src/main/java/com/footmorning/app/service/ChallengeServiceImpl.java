package com.footmorning.app.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ChallengeDTO;
import com.footmorning.app.persistence.ChallengeDAO;

@Service
public class ChallengeServiceImpl implements ChallengeService{

	@Inject
	private ChallengeDAO dao;
	
	@Override
	public void ChallengeRegister(ChallengeDTO dto) throws Exception {
		dao.ChallengeRegister(dto);
	}

	@Override
	public List<ChallengeDTO> SendChallengeListAll(int no) throws Exception {
		return dao.SendChallengeListAll(no);
	}
	
	@Override
	public List<ChallengeDTO> ReciveChallengeListAll(int no) throws Exception {
		return dao.ReciveChallengeListAll(no);
	}

	@Override
	public boolean yesChallenge(int no) throws Exception {
		return dao.yesChallenge(no);
	}

	@Override
	public boolean noChallenge(int no) throws Exception {
		return dao.noChallenge(no);
	}
}
