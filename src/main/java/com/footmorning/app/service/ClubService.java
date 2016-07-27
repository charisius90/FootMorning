package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ClubDTO;

/**
 * 
 * @author ��ҿ�
 *
 */
public interface ClubService {
	public String getTime();
	public void insert(ClubDTO dto);
	public void update(ClubDTO dto);
	public void delete(Integer no);
	public ClubDTO getClubInfo(String name) throws Exception;
	public List<ClubDTO> listAll() throws Exception;
}
