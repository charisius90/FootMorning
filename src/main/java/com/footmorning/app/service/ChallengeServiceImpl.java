package com.footmorning.app.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ChallengeDTO;
import com.footmorning.app.persistence.ChallengeDAO;

@Service
public class ChallengeServiceImpl implements ChallengeService{

	@Inject
	private ChallengeDAO dao;
	
	@Override
	public void ChallengRegister(ChallengeDTO dto) throws Exception {
		dao.ChallengRegister(dto);
	}
	
	

}
