package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ComFreeDTO;
import com.footmorning.app.domain.ComFreeReplyDTO;
import com.footmorning.app.domain.ComFreeDTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

public interface ComFreeService {
	public void register(ComFreeDTO dto) throws Exception;

	public ComFreeDTO read(Integer bno) throws Exception;

	public void updateCount(Integer no) throws Exception;
	
	public void modify(ComFreeDTO dto) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<ComFreeDTO> listAll() throws Exception;

	public List<ComFreeDTO> listCriteria(Criteria cri) throws Exception;	// ��ä
	
	public int listCountCriteria(Criteria cri) throws Exception;	// ��ä

	public List<ComFreeDTO> listSearchCriteria(SearchCriteria cri) throws Exception; // ��ä

	public int listSearchCount(SearchCriteria cri) throws Exception;	// ��ä
	
	public void createReply(ComFreeReplyDTO dto) throws Exception;

	public void createReReply(ComFreeReplyDTO dto);

	public void updatePos(ComFreeReplyDTO dto);

	public ComFreeReplyDTO MyclubNoticeParentPos(Integer no);

	public void updateReply(ComFreeReplyDTO dto) throws Exception;

	public void deleteReply(ComFreeReplyDTO dto) throws Exception;

	public List<ComFreeReplyDTO> listAllReply(Integer bno) throws Exception;
}
