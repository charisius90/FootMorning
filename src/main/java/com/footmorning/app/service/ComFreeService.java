package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ComFreeDTO;

public interface ComFreeService {
	public void register(ComFreeDTO dto) throws Exception;
	public ComFreeDTO read(Integer no) throws Exception;
	public void update(ComFreeDTO dto) throws Exception;
	public void delete(Integer no) throws Exception;
	public List<ComFreeDTO> listAll() throws Exception;
}