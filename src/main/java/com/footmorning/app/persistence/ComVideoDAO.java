package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.ComVideoDTO;

public interface ComVideoDAO {
	public void register(ComVideoDTO dto) throws Exception;
	public ComVideoDTO read(Integer no) throws Exception;
	public void update(ComVideoDTO dto) throws Exception;
	public void delete(Integer no) throws Exception;
	public List<ComVideoDTO> listAll() throws Exception;
}
