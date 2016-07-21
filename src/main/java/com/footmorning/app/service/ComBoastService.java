package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ComBoastDTO;

public interface ComBoastService {
	public void register(ComBoastDTO dto) throws Exception;
	public ComBoastDTO read(Integer no) throws Exception;
	public void update(ComBoastDTO dto) throws Exception;
	public void delete(Integer no) throws Exception;
	public List<ComBoastDTO> listAll() throws Exception;
}
