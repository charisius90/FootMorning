package com.footmorning.app.service.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComDiscussionWorldDTO;
import com.footmorning.app.persistence.ComDiscussionWorldDAO;
import com.footmorning.app.service.ComDiscussionWorldService;

@Service
public class ComDiscussionWorldServiceImpl implements ComDiscussionWorldService {

	@Autowired
	private ComDiscussionWorldDAO dao;
	
	@Override
	public void register(ComDiscussionWorldDTO dto) throws Exception {
		dao.register(dto);
	}

	@Override
	public ComDiscussionWorldDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void update(ComDiscussionWorldDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		dao.delete(no);
	}

	@Override
	public List<ComDiscussionWorldDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
