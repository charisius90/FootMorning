package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.util.SearchClubCriteria;
import com.footmorning.app.util.SearchCriteria;

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
	public List<ClubDTO> popularityListAll() throws Exception;
	public List<ClubDTO> listSearchClubCriteria(SearchClubCriteria clubcri) throws Exception;
	public int listSearchClubCount(SearchClubCriteria clubcri);
	public List<ClubDTO> listSearchCriteria(SearchCriteria cri) throws Exception;
	public int listSearchCount(SearchCriteria cri) throws Exception;
}
