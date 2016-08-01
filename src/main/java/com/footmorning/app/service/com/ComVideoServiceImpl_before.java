package com.footmorning.app.service.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComVideoDTO_before;
import com.footmorning.app.persistence.ComVideoDAO_before;
import com.footmorning.app.service.ComVideoService_before;

@Service
public class ComVideoServiceImpl_before implements ComVideoService_before {
	
	@Autowired
	private ComVideoDAO_before dao;

	@Override
	public void register(ComVideoDTO_before dto) throws Exception {
		dao.register(dto);
	}

	@Override
	public ComVideoDTO_before read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void update(ComVideoDTO_before dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		dao.delete(no);
	}

	@Override
	public List<ComVideoDTO_before> listAll() throws Exception {
		return dao.listAll();
	}

}
