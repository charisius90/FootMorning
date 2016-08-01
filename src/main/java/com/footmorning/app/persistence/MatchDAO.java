package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.MatchDTO;

public interface MatchDAO {

	public void matchRegister(MatchDTO dto)throws Exception;
	
	public List<MatchDTO> matchListAll()throws Exception;
}
