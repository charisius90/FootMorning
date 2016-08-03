package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ComGalleryDTO;
import com.footmorning.app.domain.ComVideoDTO;
import com.footmorning.app.domain.ComVideoReplyDTO;
import com.footmorning.app.util.AlbumCriteria;
import com.footmorning.app.util.AlbumSearchCriteria;
import com.footmorning.app.util.SearchCriteria;


public interface ComVideoService {
	public void create(ComVideoDTO dto) throws Exception;

	public ComVideoDTO read(Integer bno) throws Exception;
	
	public void updateCount(Integer com_video_no) throws Exception;

	public void update(ComVideoDTO dto) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<ComVideoDTO> listAll() throws Exception;

	public List<ComVideoDTO> listCriteria(AlbumCriteria cri) throws Exception; 

	public int countPaging(AlbumCriteria cri) throws Exception; 

	public List<ComVideoDTO> listSearchCriteria(AlbumSearchCriteria cri) throws Exception;

	public int listSearchCount(AlbumSearchCriteria cri) throws Exception;

	public void createReply(ComVideoReplyDTO dto) throws Exception;

	public void createReReply(ComVideoReplyDTO dto);

	public void updatePos(ComVideoReplyDTO dto);

	public ComVideoReplyDTO ComVideoParentPos(Integer no);

	public void updateReply(ComVideoReplyDTO dto) throws Exception;

	public void deleteReply(ComVideoReplyDTO dto) throws Exception;

	public List<ComVideoReplyDTO> listAllReply(Integer bno) throws Exception;
	
	public List<ComVideoDTO> listAdmin(SearchCriteria cri) throws Exception;

	public int listAdminCount(SearchCriteria cri) throws Exception;
}
