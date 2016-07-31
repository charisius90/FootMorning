package com.footmorning.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ClubConfigDTO;
import com.footmorning.app.persistence.ClubConfigDAO;

@Service
public class ClubConfigServiceImpl implements ClubConfigService {
	@Autowired
	private ClubConfigDAO dao;

	@Override
	public String getTime() {
		return dao.getTime();
	}

	@Override
	public void insert(ClubConfigDTO dto) {
		dao.insert(dto);
	}

	@Override
	public void update(ClubConfigDTO dto) {
		dao.update(dto);
	}

	@Override
	public void delete(Integer no) {
		dao.delete(no);
	}

	@Override
	public ClubConfigDTO getWithClubNo(Integer no) throws Exception {
		return dao.getWithClubNo(no);
	}

	@Override
	public List<ClubConfigDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
