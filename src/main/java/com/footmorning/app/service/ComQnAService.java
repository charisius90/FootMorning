package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ComQnADTO;

public interface ComQnAService {
	public void register(ComQnADTO dto) throws Exception;
	public ComQnADTO read(Integer no) throws Exception;
	public void update(ComQnADTO dto) throws Exception;
	public void delete(Integer no) throws Exception;
	public List<ComQnADTO> listAll() throws Exception;
}
