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
	public List<MatchDTO> matchListAll() throws Exception {
		return dao.matchListAll();
	}
}
