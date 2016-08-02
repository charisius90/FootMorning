package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.MainNoticeDTO;
import com.footmorning.app.domain.MainNoticeReplyDTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

public interface MainNoticeService {
	
	public void register(MainNoticeDTO dto) throws Exception;

	public MainNoticeDTO read(Integer bno) throws Exception;

	public void updateCount(Integer no) throws Exception;
	
	public void modify(MainNoticeDTO dto) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<MainNoticeDTO> listAll() throws Exception;

	public List<MainNoticeDTO> listCriteria(Criteria cri) throws Exception;	// ��ä
	
	public int listCountCriteria(Criteria cri) throws Exception;	// ��ä

	public List<MainNoticeDTO> listSearchCriteria(SearchCriteria cri) throws Exception; // ��ä

	public int listSearchCount(SearchCriteria cri) throws Exception;	// ��ä
	
	public void createReply(MainNoticeReplyDTO dto) throws Exception;

	public void createReReply(MainNoticeReplyDTO dto);

	public void updatePos(MainNoticeReplyDTO dto);

	public MainNoticeReplyDTO MyclubNoticeParentPos(Integer no);

	public void updateReply(MainNoticeReplyDTO dto) throws Exception;

	public void deleteReply(MainNoticeReplyDTO dto) throws Exception;

	public List<MainNoticeReplyDTO> listAllReply(Integer bno) throws Exception;
	
}
