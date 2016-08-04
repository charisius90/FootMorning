package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.ComDiscussionWorldDTO;
import com.footmorning.app.domain.ComFreeDTO;
import com.footmorning.app.domain.ComFreeReplyDTO;
import com.footmorning.app.domain.ComQnADTO;
import com.footmorning.app.domain.ComQnAReplyDTO;
import com.footmorning.app.domain.ComQnADTO;
import com.footmorning.app.domain.ComQnADTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

public interface ComFreeDAO {
	
	public void create(ComFreeDTO dto) throws Exception;

	public ComFreeDTO read(Integer bno) throws Exception;
	
	public void updateCount(Integer no) throws Exception;

	public void update(ComFreeDTO dto) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<ComFreeDTO> listAll() throws Exception;

	public List<ComFreeDTO> listCriteria(Criteria cri) throws Exception; // ��ä

	public int countPaging(Criteria cri) throws Exception; // ��ä

	public List<ComFreeDTO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public void createReply(ComFreeReplyDTO dto) throws Exception;

	public void createReReply(ComFreeReplyDTO dto);

	public void updatePos(ComFreeReplyDTO dto);

	public ComFreeReplyDTO MyclubNoticeParentPos(Integer no);

	public void updateReply(ComFreeReplyDTO dto) throws Exception;

	public void deleteReply(ComFreeReplyDTO dto) throws Exception;

	public List<ComFreeReplyDTO> listAllReply(Integer bno) throws Exception;
	
	public List<ComFreeDTO> listMypostAll(int mem_no) throws Exception;

}
