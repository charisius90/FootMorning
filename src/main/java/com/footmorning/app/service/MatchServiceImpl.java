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
	public List<MatchDTO> myMatchListWithClubNo(int club_no) throws Exception {
		return dao.myMatchListWithClubNo(club_no);
	}
	
	@Override
	public List<MatchDTO> yourMatchListWithClubNo(int club_no) throws Exception {
		return dao.yourMatchListWithClubNo(club_no);
	}
	
	@Override
	public List<MatchDTO> matchListWithClubNo(int club_no) throws Exception {
		return dao.matchListWithClubNo(club_no);
	}

	@Override
	public void matchDelete(int game_no) throws Exception {
		dao.matchDelete(game_no);
	}
}
