package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.ComFreeDTO;
import com.footmorning.app.domain.ComFreeReplyDTO;
import com.footmorning.app.domain.ComQnADTO;
import com.footmorning.app.domain.ComQnAReplyDTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

public interface ComQnADAO {
	public void create(ComQnADTO dto) throws Exception;

	public ComQnADTO read(Integer bno) throws Exception;
	
	public void updateCount(Integer no) throws Exception;

	public void update(ComQnADTO dto) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<ComQnADTO> listAll() throws Exception;

	public List<ComQnADTO> listCriteria(Criteria cri) throws Exception; // ��ä

	public int countPaging(Criteria cri) throws Exception; // ��ä

	public List<ComQnADTO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public void createReply(ComQnAReplyDTO dto) throws Exception;

	public void createReReply(ComQnAReplyDTO dto);

	public void updatePos(ComQnAReplyDTO dto);

	public ComQnAReplyDTO MyclubNoticeParentPos(Integer no);

	public void updateReply(ComQnAReplyDTO dto) throws Exception;

	public void deleteReply(ComQnAReplyDTO dto) throws Exception;

	public List<ComQnAReplyDTO> listAllReply(Integer bno) throws Exception;
}
