package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.MyclubNoticeDTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;


public interface MyclubNoticeService {
	public void register(MyclubNoticeDTO dto) throws Exception;

	public MyclubNoticeDTO read(Integer bno) throws Exception;
	
	public void updateCount(Integer bno) throws Exception;
	
	public void modify(MyclubNoticeDTO dto) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<MyclubNoticeDTO> listAll() throws Exception;

	public List<MyclubNoticeDTO> listCriteria(Criteria cri) throws Exception;	// 규채
	
	public int listCountCriteria(Criteria cri) throws Exception;	// 규채

	public List<MyclubNoticeDTO> listSearchCriteria(SearchCriteria cri) throws Exception; // 규채

	public int listSearchCount(SearchCriteria cri) throws Exception;	// 규채
}