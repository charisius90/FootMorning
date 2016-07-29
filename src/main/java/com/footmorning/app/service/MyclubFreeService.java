package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.MyclubFreeDTO;
import com.footmorning.app.domain.MyclubFreeReplyDTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;


public interface MyclubFreeService {
	public void register(MyclubFreeDTO dto) throws Exception;

	public MyclubFreeDTO read(Integer bno) throws Exception;

	public void updateCount(Integer myclub_notice_no) throws Exception;
	
	public void modify(MyclubFreeDTO dto) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<MyclubFreeDTO> listAll() throws Exception;

	public List<MyclubFreeDTO> listCriteria(Criteria cri) throws Exception;	
	
	public int listCountCriteria(Criteria cri) throws Exception;	

	public List<MyclubFreeDTO> listSearchCriteria(SearchCriteria cri) throws Exception; 

	public int listSearchCount(SearchCriteria cri) throws Exception;	
	
	public void createReply(MyclubFreeReplyDTO dto) throws Exception;

	public void createReReply(MyclubFreeReplyDTO dto);

	public void updatePos(MyclubFreeReplyDTO dto);

	public MyclubFreeReplyDTO MyclubFreeParentPos(Integer no);

	public void updateReply(MyclubFreeReplyDTO dto) throws Exception;

	public void deleteReply(MyclubFreeReplyDTO dto) throws Exception;

	public List<MyclubFreeReplyDTO> listAllReply(Integer bno) throws Exception;
}