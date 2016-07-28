package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.MyclubNoticeDTO;
import com.footmorning.app.domain.MyclubNoticeReplyDTO;

public interface MyclubNoticeDAO {
	public void create(MyclubNoticeDTO dto) throws Exception;

	public MyclubNoticeDTO read(Integer bno) throws Exception;

	public void update(MyclubNoticeDTO dto) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<MyclubNoticeDTO> listAll() throws Exception;

	public void createReply(MyclubNoticeReplyDTO dto) throws Exception;

	public void createReReply(MyclubNoticeReplyDTO dto);

	public void updatePos(MyclubNoticeReplyDTO dto);

	public MyclubNoticeReplyDTO MyclubNoticeParentPos(Integer no);

	public void updateReply(MyclubNoticeReplyDTO dto) throws Exception;

	public void deleteReply(MyclubNoticeReplyDTO dto) throws Exception;

	public List<MyclubNoticeReplyDTO> listAllReply(Integer bno) throws Exception;
}
