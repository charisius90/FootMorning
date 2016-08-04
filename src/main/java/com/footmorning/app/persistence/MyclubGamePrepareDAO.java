package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.FirstLineupDTO;
import com.footmorning.app.domain.FormationDTO;
import com.footmorning.app.domain.MatchDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.domain.SubLineupDTO;

public interface MyclubGamePrepareDAO {
	public String checkLineupNo(MatchDTO dto) throws Exception;	
	
	public List<MemberDTO> listMemberWithClubNo(int club_no) throws Exception;
	
	public void registerFirstLineup(FirstLineupDTO dto) throws Exception;
	
	public void registerSubLineup(SubLineupDTO dto) throws Exception;
	
	public void registerFormation(FormationDTO dto) throws Exception;
	
	public void deleteFirstLineup(String lineup_no) throws Exception;
	
	public void deleteSubLineup(String lineup_no) throws Exception;
	
	public void deleteFormation(String lineup_no) throws Exception;
	
	public FirstLineupDTO firstLineupWithLineupNo(String lineup_no) throws Exception;
	
	public SubLineupDTO subLineupWithLineupNo(String lineup_no) throws Exception;
	
	public FormationDTO formationWithLineupNo(String lineup_no) throws Exception;
}
