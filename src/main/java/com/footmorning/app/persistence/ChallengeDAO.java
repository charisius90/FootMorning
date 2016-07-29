package com.footmorning.app.persistence;

import com.footmorning.app.domain.ChallengeDTO;

public interface ChallengeDAO {

	public void ChallengRegister(ChallengeDTO dto)throws Exception;
}
