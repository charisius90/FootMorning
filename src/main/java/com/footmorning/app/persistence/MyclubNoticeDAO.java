package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.MyclubNoticeDTO;

public interface MyclubNoticeDAO {
	public void create(MyclubNoticeDTO dto) throws Exception;

	public MyclubNoticeDTO read(Integer bno) throws Exception;

	public void update(MyclubNoticeDTO dto) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<MyclubNoticeDTO> listAll() throws Exception;
}
