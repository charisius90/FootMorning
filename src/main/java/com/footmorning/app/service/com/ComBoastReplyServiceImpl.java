package com.footmorning.app.service.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComBoastReplyDTO;
import com.footmorning.app.persistence.ComBoastReplyDAO;
import com.footmorning.app.service.ComBoastReplyService;

/**
 * 
 * @author ±è¼Ò¿µ
 *
 */
@Service
public class ComBoastReplyServiceImpl implements ComBoastReplyService {
	
	@Autowired
	private ComBoastReplyDAO dao;

	@Override
	public void register(ComBoastReplyDTO dto) throws Exception {
		dao.register(dto);
	}

	@Override
	public ComBoastReplyDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void update(ComBoastReplyDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		dao.delete(no);
	}

	@Override
	public List<ComBoastReplyDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
