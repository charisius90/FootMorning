package com.footmorning.app.service.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComGalleryDTO;
import com.footmorning.app.persistence.ComGalleryDAO;
import com.footmorning.app.service.ComGalleryService;

@Service
public class ComGalleryServiceImpl implements ComGalleryService {
	
	@Autowired
	private ComGalleryDAO dao;

	@Override
	public void register(ComGalleryDTO dto) throws Exception {
		dao.register(dto);
	}

	@Override
	public ComGalleryDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void update(ComGalleryDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		dao.delete(no);
	}

	@Override
	public List<ComGalleryDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
