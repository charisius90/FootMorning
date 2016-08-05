package com.footmorning.app.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.MatchDTO;
import com.footmorning.app.persistence.MatchDAO;

@Service
public class MatchServiceImpl implements MatchService {

	@Inject
	private MatchDAO dao;

	@Override
	public void matchRegister(MatchDTO dto) throws Exception {
		dao.matchRegister(dto);

	}

	@Override
	public void matchReciveRegister(MatchDTO dto) throws Exception {
		dao.matchReciveRegister(dto);
	}

	@Override
	public List<MatchDTO> matchListAll() throws Exception {
		return dao.matchListAll();
	}

	@Override
	public List<MatchDTO> matchListWithClubNo(int club_no) throws Exception {
		return dao.matchListWithClubNo(club_no);
	}

	@Override
	public List<MatchDTO> matchListWithClubNoUnconnect(int club_no) throws Exception {
		return dao.matchListWithClubNoUnconnect(club_no);
	}

	@Override
	public MatchDTO matchWithGameNo(int game_no) throws Exception {
		return dao.matchWithGameNo(game_no);
	}

	@Override
	public MatchDTO matchWithGameNoAndGameFlag(MatchDTO dto) throws Exception {
		return dao.matchWithGameNoAndGameFlag(dto);
	}

	@Override
	public void matchDelete(int game_no) throws Exception {
		dao.matchDelete(game_no);
	}

	@Override
	public String myClubName(int club_no) throws Exception {
		return dao.myClubName(club_no);
	}

	@Override
	public List<MatchDTO> matchListWithClubNoThird(int club_no) throws Exception {
		return dao.matchListWithClubNoThird(club_no);
	}

	@Override
	public Integer gameNoMax() throws Exception {
		return dao.gameNoMax();
	}

	@Override
	public void editHome(MatchDTO dto) throws Exception {
		dao.editHome(dto);
	}

	@Override
	public void editAway(MatchDTO dto) throws Exception {
		dao.editAway(dto);
	}
}
