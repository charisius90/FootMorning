package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ComVideoDTO_before;

public interface ComVideoService_before {
	public void register(ComVideoDTO_before dto) throws Exception;
	public ComVideoDTO_before read(Integer no) throws Exception;
	public void update(ComVideoDTO_before dto) throws Exception;
	public void delete(Integer no) throws Exception;
	public List<ComVideoDTO_before> listAll() throws Exception;
}
