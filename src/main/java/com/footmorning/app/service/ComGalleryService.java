package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ComGalleryDTO;

public interface ComGalleryService {
	public void register(ComGalleryDTO dto) throws Exception;
	public ComGalleryDTO read(Integer no) throws Exception;
	public void update(ComGalleryDTO dto) throws Exception;
	public void delete(Integer no) throws Exception;
	public List<ComGalleryDTO> listAll() throws Exception;
}
