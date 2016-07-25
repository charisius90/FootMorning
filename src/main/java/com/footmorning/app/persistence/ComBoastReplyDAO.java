package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.ComBoastReplyDTO;

/**
 * 
 * @author ±è¼Ò¿µ
 *
 */
public interface ComBoastReplyDAO {
	public void register(ComBoastReplyDTO dto) throws Exception;
	public ComBoastReplyDTO read(Integer no) throws Exception;
	public void update(ComBoastReplyDTO dto) throws Exception;
	public void delete(Integer no) throws Exception;
	public List<ComBoastReplyDTO> listAll() throws Exception;
}
