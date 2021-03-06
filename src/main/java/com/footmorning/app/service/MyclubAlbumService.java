package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.MyclubAlbumDTO;
import com.footmorning.app.domain.MyclubAlbumReplyDTO;
import com.footmorning.app.util.AlbumCriteria;
import com.footmorning.app.util.AlbumSearchCriteria;


public interface MyclubAlbumService {
	public void register(MyclubAlbumDTO dto) throws Exception;

	public MyclubAlbumDTO read(Integer bno) throws Exception;

	public void updateCount(Integer myclub_album_no) throws Exception;
	
	public void modify(MyclubAlbumDTO dto) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<MyclubAlbumDTO> listAll() throws Exception;

	public List<MyclubAlbumDTO> listCriteria(AlbumCriteria cri) throws Exception;	
	
	public int listCountCriteria(AlbumCriteria cri) throws Exception;	

	public List<MyclubAlbumDTO> listSearchCriteria(AlbumSearchCriteria cri) throws Exception; 

	public int listSearchCount(AlbumSearchCriteria cri) throws Exception;	
	
	public void createReply(MyclubAlbumReplyDTO dto) throws Exception;

	public void createReReply(MyclubAlbumReplyDTO dto);

	public void updatePos(MyclubAlbumReplyDTO dto);

	public MyclubAlbumReplyDTO MyclubAlbumParentPos(Integer no);

	public void updateReply(MyclubAlbumReplyDTO dto) throws Exception;

	public void deleteReply(MyclubAlbumReplyDTO dto) throws Exception;

	public List<MyclubAlbumReplyDTO> listAllReply(Integer bno) throws Exception;

	public List<MyclubAlbumDTO> listMypostAll(int mem_no) throws Exception;
}
