package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ComGalleryDTO_before;

public interface ComGalleryService_before {
	public void register(ComGalleryDTO_before dto) throws Exception;
	public ComGalleryDTO_before read(Integer no) throws Exception;
	public void update(ComGalleryDTO_before dto) throws Exception;
	public void delete(Integer no) throws Exception;
	public List<ComGalleryDTO_before> listAll() throws Exception;
}
