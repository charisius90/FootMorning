package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ClubConfigDTO;

public interface ClubConfigService {
	public String getTime();
	public void insert(ClubConfigDTO dto);
	public void update(ClubConfigDTO dto);
	public void delete(Integer no);
	public ClubConfigDTO getWithClubNo(Integer no) throws Exception;
	public List<ClubConfigDTO> listAll() throws Exception;
}
