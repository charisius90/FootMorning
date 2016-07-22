package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.ComDiscussionWorldDTO;

public interface ComDiscussionWorldDAO {
	public void register(ComDiscussionWorldDTO dto) throws Exception;
	public ComDiscussionWorldDTO read(Integer no) throws Exception;
	public void update(ComDiscussionWorldDTO dto) throws Exception;
	public void delete(Integer no) throws Exception;
	public List<ComDiscussionWorldDTO> listAll() throws Exception;
}
