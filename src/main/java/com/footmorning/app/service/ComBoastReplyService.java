package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ComBoastReplyDTO;

public interface ComBoastReplyService {
	public void register(ComBoastReplyDTO dto) throws Exception;
	public ComBoastReplyDTO read(Integer no) throws Exception;
	public void update(ComBoastReplyDTO dto) throws Exception;
	public void delete(Integer no) throws Exception;
	public List<ComBoastReplyDTO> listAll() throws Exception;
}
