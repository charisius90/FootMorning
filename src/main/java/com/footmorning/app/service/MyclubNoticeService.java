package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.MyclubNoticeDTO;
import com.footmorning.app.domain.MyclubNoticeReplyDTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

public interface MyclubNoticeService {
	public void register(MyclubNoticeDTO dto) throws Exception;

	public MyclubNoticeDTO read(Integer bno) throws Exception;

	public void updateCount(Integer myclub_notice_no) throws Exception;
	
	public void modify(MyclubNoticeDTO dto) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<MyclubNoticeDTO> listAll() throws Exception;

	public List<MyclubNoticeDTO> listCriteria(Criteria cri) throws Exception;	// ��ä
	
	public int listCountCriteria(Criteria cri) throws Exception;	// ��ä

	public List<MyclubNoticeDTO> listSearchCriteria(SearchCriteria cri) throws Exception; // ��ä

	public int listSearchCount(SearchCriteria cri) throws Exception;	// ��ä
	
	public void createReply(MyclubNoticeReplyDTO dto) throws Exception;

	public void createReReply(MyclubNoticeReplyDTO dto);

	public void updatePos(MyclubNoticeReplyDTO dto);

	public MyclubNoticeReplyDTO MyclubNoticeParentPos(Integer no);

	public void updateReply(MyclubNoticeReplyDTO dto) throws Exception;

	public void deleteReply(MyclubNoticeReplyDTO dto) throws Exception;

	public List<MyclubNoticeReplyDTO> listAllReply(Integer bno) throws Exception;

	public List<MyclubNoticeDTO> listMypostAll(int mem_no) throws Exception;
}