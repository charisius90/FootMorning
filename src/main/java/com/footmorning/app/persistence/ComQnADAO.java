package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.ComQnADTO;

public interface ComQnADAO {
	public void register(ComQnADTO dto) throws Exception;
	public ComQnADTO read(Integer no) throws Exception;
	public void update(ComQnADTO dto) throws Exception;
	public void delete(Integer no) throws Exception;
	public List<ComQnADTO> listAll() throws Exception;
}
