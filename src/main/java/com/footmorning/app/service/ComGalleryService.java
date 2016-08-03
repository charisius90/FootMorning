package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ComGalleryDTO;
import com.footmorning.app.domain.ComGalleryReplyDTO;
import com.footmorning.app.util.AlbumCriteria;
import com.footmorning.app.util.AlbumSearchCriteria;
import com.footmorning.app.util.SearchCriteria;

public interface ComGalleryService {
	public void create(ComGalleryDTO dto) throws Exception;

	public ComGalleryDTO read(Integer bno) throws Exception;
	
	public void updateCount(Integer com_gallery_no) throws Exception;

	public void update(ComGalleryDTO dto) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<ComGalleryDTO> listAll() throws Exception;

	public List<ComGalleryDTO> listCriteria(AlbumCriteria cri) throws Exception; 

	public int countPaging(AlbumCriteria cri) throws Exception; 

	public List<ComGalleryDTO> listSearchCriteria(AlbumSearchCriteria cri) throws Exception;

	public int listSearchCount(AlbumSearchCriteria cri) throws Exception;

	public void createReply(ComGalleryReplyDTO dto) throws Exception;

	public void createReReply(ComGalleryReplyDTO dto);

	public void updatePos(ComGalleryReplyDTO dto);

	public ComGalleryReplyDTO ComGalleryParentPos(Integer no);

	public void updateReply(ComGalleryReplyDTO dto) throws Exception;

	public void deleteReply(ComGalleryReplyDTO dto) throws Exception;

	public List<ComGalleryReplyDTO> listAllReply(Integer bno) throws Exception;
	
	public List<ComGalleryDTO> listAdmin(SearchCriteria cri) throws Exception;

	public int listAdminCount(SearchCriteria cri) throws Exception;
}
