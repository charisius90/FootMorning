package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.MyclubNoticeDTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

public interface MyclubNoticeDAO {
	public void create(MyclubNoticeDTO dto) throws Exception;

	public MyclubNoticeDTO read(Integer bno) throws Exception;
	
	public void updateCount(Integer bno) throws Exception;

	public void update(MyclubNoticeDTO dto) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<MyclubNoticeDTO> listAll() throws Exception;

	public List<MyclubNoticeDTO> listCriteria(Criteria cri) throws Exception;	// ��ä
	
	public int countPaging(Criteria cri) throws Exception; 	// ��ä
	
	public List<MyclubNoticeDTO> listSearchCriteria(SearchCriteria cri)throws Exception;
	  
	public int listSearchCount(SearchCriteria cri)throws Exception;	
	
}
