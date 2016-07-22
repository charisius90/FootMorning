package com.footmorning.app.service.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComFreeDTO;
import com.footmorning.app.persistence.ComFreeDAO;
import com.footmorning.app.service.ComFreeService;

@Service
public class ComFreeServiceImpl implements ComFreeService {
	
	@Autowired
	private ComFreeDAO dao;

	@Override
	public void register(ComFreeDTO dto) throws Exception {
		dao.register(dto);
	}

	@Override
	public ComFreeDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void update(ComFreeDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		dao.delete(no);
	}

	@Override
	public List<ComFreeDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
