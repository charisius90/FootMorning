package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.MyclubVideoDTO;
import com.footmorning.app.domain.MyclubVideoReplyDTO;
import com.footmorning.app.util.AlbumCriteria;
import com.footmorning.app.util.AlbumSearchCriteria;

public interface MyclubVideoDAO {
	public void create(MyclubVideoDTO dto) throws Exception;

	public MyclubVideoDTO read(Integer bno) throws Exception;
	
	public void updateCount(Integer myclub_video_no) throws Exception;

	public void update(MyclubVideoDTO dto) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<MyclubVideoDTO> listAll() throws Exception;

	public List<MyclubVideoDTO> listCriteria(AlbumCriteria cri) throws Exception; 

	public int countPaging(AlbumCriteria cri) throws Exception; 

	public List<MyclubVideoDTO> listSearchCriteria(AlbumSearchCriteria cri) throws Exception;

	public int listSearchCount(AlbumSearchCriteria cri) throws Exception;

	public void createReply(MyclubVideoReplyDTO dto) throws Exception;

	public void createReReply(MyclubVideoReplyDTO dto);

	public void updatePos(MyclubVideoReplyDTO dto);

	public MyclubVideoReplyDTO MyclubVideoParentPos(Integer no);

	public void updateReply(MyclubVideoReplyDTO dto) throws Exception;

	public void deleteReply(MyclubVideoReplyDTO dto) throws Exception;

	public List<MyclubVideoReplyDTO> listAllReply(Integer bno) throws Exception;
	
	public List<MyclubVideoDTO> listMypostAll(int mem_no) throws Exception;
}
