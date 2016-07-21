package com.footmorning.app.service.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComBoastDTO;
import com.footmorning.app.persistence.ComBoastDAO;
import com.footmorning.app.service.ComBoastService;

@Service
public class ComBoastServiceImpl implements ComBoastService {
	
	@Autowired
	private ComBoastDAO dao;

	@Override
	public void register(ComBoastDTO dto) throws Exception {
		dao.register(dto);
	}

	@Override
	public ComBoastDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void update(ComBoastDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		dao.delete(no);
	}

	@Override
	public List<ComBoastDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
