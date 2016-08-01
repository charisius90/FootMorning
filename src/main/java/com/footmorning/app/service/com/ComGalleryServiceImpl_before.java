package com.footmorning.app.service.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComGalleryDTO_before;
import com.footmorning.app.persistence.ComGalleryDAO_before;
import com.footmorning.app.service.ComGalleryService_before;

@Service
public class ComGalleryServiceImpl_before implements ComGalleryService_before {
	
	@Autowired
	private ComGalleryDAO_before dao;

	@Override
	public void register(ComGalleryDTO_before dto) throws Exception {
		dao.register(dto);
	}

	@Override
	public ComGalleryDTO_before read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void update(ComGalleryDTO_before dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		dao.delete(no);
	}

	@Override
	public List<ComGalleryDTO_before> listAll() throws Exception {
		return dao.listAll();
	}

}
