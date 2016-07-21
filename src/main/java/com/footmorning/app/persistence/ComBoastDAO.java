package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.ComBoastDTO;

public interface ComBoastDAO {
	public void create(ComBoastDTO dto) throws Exception;
	public ComBoastDTO read(Integer bno) throws Exception;
	public void update(ComBoastDTO vo) throws Exception;
	public void delete(Integer bno) throws Exception;
	public List<ComBoastDTO> listAll() throws Exception;
}
