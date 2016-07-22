package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ComDiscussionKorDTO;

public interface ComDiscussionKorService {
	public void register(ComDiscussionKorDTO dto) throws Exception;
	public ComDiscussionKorDTO read(Integer no) throws Exception;
	public void update(ComDiscussionKorDTO dto) throws Exception;
	public void delete(Integer no) throws Exception;
	public List<ComDiscussionKorDTO> listAll() throws Exception;
}
