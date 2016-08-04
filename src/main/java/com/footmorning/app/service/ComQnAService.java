package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ComQnADTO;
import com.footmorning.app.domain.ComQnAReplyDTO;
import com.footmorning.app.domain.ComQnADTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

public interface ComQnAService {
	public void register(ComQnADTO dto) throws Exception;

	public ComQnADTO read(Integer bno) throws Exception;

	public void updateCount(Integer no) throws Exception;
	
	public void modify(ComQnADTO dto) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<ComQnADTO> listAll() throws Exception;

	public List<ComQnADTO> listCriteria(Criteria cri) throws Exception;	// ��ä
	
	public int listCountCriteria(Criteria cri) throws Exception;	// ��ä

	public List<ComQnADTO> listSearchCriteria(SearchCriteria cri) throws Exception; // ��ä

	public int listSearchCount(SearchCriteria cri) throws Exception;	// ��ä
	
	public void createReply(ComQnAReplyDTO dto) throws Exception;

	public void createReReply(ComQnAReplyDTO dto);

	public void updatePos(ComQnAReplyDTO dto);

	public ComQnAReplyDTO MyclubNoticeParentPos(Integer no);

	public void updateReply(ComQnAReplyDTO dto) throws Exception;

	public void deleteReply(ComQnAReplyDTO dto) throws Exception;

	public List<ComQnAReplyDTO> listAllReply(Integer bno) throws Exception;

	public List<ComQnADTO> listMypostAll(int mem_no) throws Exception;
}
