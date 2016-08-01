package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.MatchDTO;

public interface MatchService {
	
	public void matchRegister(MatchDTO dto)throws Exception;
	
	public List<MatchDTO> matchListAll()throws Exception;

}
