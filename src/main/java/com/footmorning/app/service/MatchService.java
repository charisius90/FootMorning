package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.MatchDTO;

public interface MatchService {
	
public void matchRegister(MatchDTO dto)throws Exception;
	
	public void matchReciveRegister(MatchDTO dto)throws Exception;
	
	public List<MatchDTO> matchListAll()throws Exception;
	
	public List<MatchDTO> myMatchListWithClubNo(int club_no)throws Exception;
	
	public List<MatchDTO> yourMatchListWithClubNo(int club_no)throws Exception;
	
	public List<MatchDTO> matchListWithClubNo(int club_no) throws Exception;
	
	public void matchDelete(int game_no) throws Exception;
}
