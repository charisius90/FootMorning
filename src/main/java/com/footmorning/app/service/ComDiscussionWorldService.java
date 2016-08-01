package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ComDiscussionWorldDTO;
import com.footmorning.app.domain.ComDiscussionWorldReplyDTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

public interface ComDiscussionWorldService {
	public void register(ComDiscussionWorldDTO dto) throws Exception;

	public ComDiscussionWorldDTO read(Integer bno) throws Exception;

	public void updateCount(Integer no) throws Exception;
	
	public void modify(ComDiscussionWorldDTO dto) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<ComDiscussionWorldDTO> listAll() throws Exception;

	public List<ComDiscussionWorldDTO> listCriteria(Criteria cri) throws Exception;	// ��ä
	
	public int listCountCriteria(Criteria cri) throws Exception;	// ��ä

	public List<ComDiscussionWorldDTO> listSearchCriteria(SearchCriteria cri) throws Exception; // ��ä

	public int listSearchCount(SearchCriteria cri) throws Exception;	// ��ä
	
	public void createReply(ComDiscussionWorldReplyDTO dto) throws Exception;

	public void createReReply(ComDiscussionWorldReplyDTO dto);

	public void updatePos(ComDiscussionWorldReplyDTO dto);

	public ComDiscussionWorldReplyDTO MyclubNoticeParentPos(Integer no);

	public void updateReply(ComDiscussionWorldReplyDTO dto) throws Exception;

	public void deleteReply(ComDiscussionWorldReplyDTO dto) throws Exception;

	public List<ComDiscussionWorldReplyDTO> listAllReply(Integer bno) throws Exception;
}
