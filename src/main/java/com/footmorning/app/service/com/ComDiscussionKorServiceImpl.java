package com.footmorning.app.service.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComDiscussionKorDTO;
import com.footmorning.app.persistence.ComDiscussionKorDAO;
import com.footmorning.app.service.ComDiscussionKorService;

@Service
public class ComDiscussionKorServiceImpl implements ComDiscussionKorService {
	
	@Autowired
	private ComDiscussionKorDAO dao;

	@Override
	public void register(ComDiscussionKorDTO dto) throws Exception {
		dao.register(dto);
	}

	@Override
	public ComDiscussionKorDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void update(ComDiscussionKorDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		dao.delete(no);
	}

	@Override
	public List<ComDiscussionKorDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
