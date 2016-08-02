package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.util.SearchClubCriteria;

/**
 * 
 * @author ��ҿ�
 *
 */
public interface ClubDAO {
	public String getTime();
	public void insert(ClubDTO dto);
	public void update(ClubDTO dto);
	public void delete(Integer no);
	public ClubDTO getClubInfo(String name) throws Exception;
	public ClubDTO getWithNo(Integer no) throws Exception;
	public List<ClubDTO> listAll() throws Exception;
	public List<ClubDTO> listSearchClubCriteria(SearchClubCriteria clubcri) throws Exception;
}
