package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.MyclubNoticeDTO;


public interface MyclubNoticeService {
	public void register(MyclubNoticeDTO dto) throws Exception;

	public MyclubNoticeDTO read(Integer bno) throws Exception;

	public void modify(MyclubNoticeDTO dto) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<MyclubNoticeDTO> listAll() throws Exception;
}