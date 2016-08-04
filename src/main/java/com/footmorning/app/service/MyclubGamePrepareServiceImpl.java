package com.footmorning.app.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.FirstLineupDTO;
import com.footmorning.app.domain.FormationDTO;
import com.footmorning.app.domain.MatchDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.domain.SubLineupDTO;
import com.footmorning.app.persistence.MyclubGamePrepareDAO;

@Service
public class MyclubGamePrepareServiceImpl implements MyclubGamePrepareService{

	@Inject
	private MyclubGamePrepareDAO dao;
	
	@Override
	public String checkLineupNo(MatchDTO dto) throws Exception {
		return dao.checkLineupNo(dto);
	}

	@Override
	public List<MemberDTO> listMemberWithClubNo(int club_no) throws Exception {
		return dao.listMemberWithClubNo(club_no);
	}

	@Override
	public void registerFirstLineup(FirstLineupDTO dto) throws Exception {
		dao.registerFirstLineup(dto);
	}

	@Override
	public void registerSubLineup(SubLineupDTO dto) throws Exception {
		dao.registerSubLineup(dto);
	}

	@Override
	public void registerFormation(FormationDTO dto) throws Exception {
		dao.registerFormation(dto);
	}

	@Override
	public void deleteFirstLineup(String lineup_no) throws Exception {
		dao.deleteFirstLineup(lineup_no);
	}

	@Override
	public void deleteSubLineup(String lineup_no) throws Exception {
		dao.deleteSubLineup(lineup_no);
	}

	@Override
	public void deleteFormation(String lineup_no) throws Exception {
		dao.deleteFormation(lineup_no);
	}

	@Override
	public FirstLineupDTO firstLineupWithLineupNo(String lineup_no) throws Exception {
		return dao.firstLineupWithLineupNo(lineup_no);
	}

	@Override
	public SubLineupDTO subLineupWithLineupNo(String lineup_no) throws Exception {
		return dao.subLineupWithLineupNo(lineup_no);
	}

	@Override
	public FormationDTO formationWithLineupNo(String lineup_no) throws Exception {
		return dao.formationWithLineupNo(lineup_no);
	}
}
