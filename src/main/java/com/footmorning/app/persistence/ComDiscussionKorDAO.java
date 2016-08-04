package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.ComDiscussionKorDTO;
import com.footmorning.app.domain.ComDiscussionKorReplyDTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

public interface ComDiscussionKorDAO {

	public void create(ComDiscussionKorDTO dto) throws Exception;

	public ComDiscussionKorDTO read(Integer bno) throws Exception;
	
	public void updateCount(Integer no) throws Exception;

	public void update(ComDiscussionKorDTO dto) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<ComDiscussionKorDTO> listAll() throws Exception;

	public List<ComDiscussionKorDTO> listCriteria(Criteria cri) throws Exception; // ��ä

	public int countPaging(Criteria cri) throws Exception; // ��ä

	public List<ComDiscussionKorDTO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public void createReply(ComDiscussionKorReplyDTO dto) throws Exception;

	public void createReReply(ComDiscussionKorReplyDTO dto);

	public void updatePos(ComDiscussionKorReplyDTO dto);

	public ComDiscussionKorReplyDTO MyclubNoticeParentPos(Integer no);

	public void updateReply(ComDiscussionKorReplyDTO dto) throws Exception;

	public void deleteReply(ComDiscussionKorReplyDTO dto) throws Exception;

	public List<ComDiscussionKorReplyDTO> listAllReply(Integer bno) throws Exception;
	
	public List<ComDiscussionKorDTO> listMypostAll(int mem_no) throws Exception;
}
