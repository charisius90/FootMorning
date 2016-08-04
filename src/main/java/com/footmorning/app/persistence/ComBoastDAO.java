package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.ComBoastDTO;
import com.footmorning.app.domain.ComBoastReplyDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

public interface ComBoastDAO {
	public void create(ComBoastDTO dto) throws Exception;

	public ComBoastDTO read(Integer bno) throws Exception;
	
	public void updateCount(Integer no) throws Exception;

	public void update(ComBoastDTO dto) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<ComBoastDTO> listAll() throws Exception;

	public List<ComBoastDTO> listCriteria(Criteria cri) throws Exception; // ��ä

	public int countPaging(Criteria cri) throws Exception; // ��ä

	public List<ComBoastDTO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public void createReply(ComBoastReplyDTO dto) throws Exception;

	public void createReReply(ComBoastReplyDTO dto);

	public void updatePos(ComBoastReplyDTO dto);

	public ComBoastReplyDTO MyclubNoticeParentPos(Integer no);

	public void updateReply(ComBoastReplyDTO dto) throws Exception;
	
	public void deleteReply(ComBoastReplyDTO dto) throws Exception;

	public List<ComBoastReplyDTO> listAllReply(Integer bno) throws Exception;
	
	public List<ComBoastDTO> listSearchCri(SearchCriteria cri) throws Exception;

	public List<ComBoastDTO> listMypostAll(int mem_no) throws Exception;
}
