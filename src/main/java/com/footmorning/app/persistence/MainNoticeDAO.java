package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.MainNoticeDTO;
import com.footmorning.app.domain.MainNoticeReplyDTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

public interface MainNoticeDAO {
	public void create(MainNoticeDTO dto) throws Exception;

	public MainNoticeDTO read(Integer bno) throws Exception;
	
	public void updateCount(Integer no) throws Exception;

	public void update(MainNoticeDTO dto) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<MainNoticeDTO> listAll() throws Exception;

	public List<MainNoticeDTO> listCriteria(Criteria cri) throws Exception; // ��ä

	public int countPaging(Criteria cri) throws Exception; // ��ä

	public List<MainNoticeDTO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public void createReply(MainNoticeReplyDTO dto) throws Exception;

	public void createReReply(MainNoticeReplyDTO dto);

	public void updatePos(MainNoticeReplyDTO dto);

	public MainNoticeReplyDTO MyclubNoticeParentPos(Integer no);

	public void updateReply(MainNoticeReplyDTO dto) throws Exception;

	public void deleteReply(MainNoticeReplyDTO dto) throws Exception;

	public List<MainNoticeReplyDTO> listAllReply(Integer bno) throws Exception;
	
}
