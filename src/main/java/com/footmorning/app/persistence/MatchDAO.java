package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.MatchDTO;

public interface MatchDAO {
	public void matchRegister(MatchDTO dto)throws Exception;
	
	public MatchDTO checkGameNo(MatchDTO dto)throws Exception;
	
	public void matchReciveRegister(MatchDTO dto)throws Exception;
	
	public List<MatchDTO> matchListAll()throws Exception;
	
	public List<MatchDTO> matchListWithClubNo(int club_no) throws Exception;
	
	public List<MatchDTO> matchListWithClubNoUnconnect(int club_no) throws Exception;
	
	public MatchDTO matchWithGameNo(int game_no) throws Exception;
	
	public MatchDTO matchWithGameNoAndGameFlag(MatchDTO dto) throws Exception;

	public void matchDelete(int game_no) throws Exception;
	
	public String myClubName(int club_no) throws Exception;
	
	public List<MatchDTO> matchListWithClubNoThird(int club_no) throws Exception;
	
	public Integer gameNoMax() throws Exception;
	
}
