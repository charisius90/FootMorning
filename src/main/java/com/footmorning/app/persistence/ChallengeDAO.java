package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.ChallengeDTO;

public interface ChallengeDAO {

	public void ChallengeRegister(ChallengeDTO dto)throws Exception;
	
	public List<ChallengeDTO> SendChallengeListAll(int no)throws Exception;
	
	public List<ChallengeDTO> ReciveChallengeListAll(int no)throws Exception;
	
	public boolean yesChallenge(int no) throws Exception;
	
	public boolean noChallenge(int no) throws Exception;
}
