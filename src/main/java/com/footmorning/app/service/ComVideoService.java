package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ComVideoDTO;

public interface ComVideoService {
	public void register(ComVideoDTO dto) throws Exception;
	public ComVideoDTO read(Integer no) throws Exception;
	public void update(ComVideoDTO dto) throws Exception;
	public void delete(Integer no) throws Exception;
	public List<ComVideoDTO> listAll() throws Exception;
}
