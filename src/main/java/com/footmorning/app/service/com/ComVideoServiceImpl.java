package com.footmorning.app.service.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComVideoDTO;
import com.footmorning.app.persistence.ComVideoDAO;
import com.footmorning.app.service.ComVideoService;

@Service
public class ComVideoServiceImpl implements ComVideoService {
	
	@Autowired
	private ComVideoDAO dao;

	@Override
	public void register(ComVideoDTO dto) throws Exception {
		dao.register(dto);
	}

	@Override
	public ComVideoDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void update(ComVideoDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		dao.delete(no);
	}

	@Override
	public List<ComVideoDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
