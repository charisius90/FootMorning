package com.footmorning.app.service.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComQnADTO;
import com.footmorning.app.persistence.ComQnADAO;
import com.footmorning.app.service.ComQnAService;

@Service
public class ComQnAServiceImpl implements ComQnAService {
	
	@Autowired
	private ComQnADAO dao;

	@Override
	public void register(ComQnADTO dto) throws Exception {
		dao.register(dto);
	}

	@Override
	public ComQnADTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void update(ComQnADTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		dao.delete(no);
	}

	@Override
	public List<ComQnADTO> listAll() throws Exception {
		return dao.listAll();
	}

}
