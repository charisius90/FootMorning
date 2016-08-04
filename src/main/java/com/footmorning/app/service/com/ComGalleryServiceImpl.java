package com.footmorning.app.service.com;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComGalleryDTO;
import com.footmorning.app.domain.ComGalleryReplyDTO;
import com.footmorning.app.persistence.ComGalleryDAO;
import com.footmorning.app.service.ComGalleryService;
import com.footmorning.app.util.AlbumCriteria;
import com.footmorning.app.util.AlbumSearchCriteria;
import com.footmorning.app.util.SearchCriteria;

@Service
public class ComGalleryServiceImpl implements ComGalleryService {
	
	@Inject
	private ComGalleryDAO dao;
	
	@Override
	public void create(ComGalleryDTO dto) throws Exception {
		dao.create(dto);
	}

	@Override
	public ComGalleryDTO read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void updateCount(Integer com_gallery_no) throws Exception {
		dao.updateCount(com_gallery_no);
	}

	@Override
	public void update(ComGalleryDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<ComGalleryDTO> listAll() throws Exception {
		return getComGallerys(dao.listAll());
	}

	private List<ComGalleryDTO> getComGallerys(List<ComGalleryDTO> list) {
		for (ComGalleryDTO dto : list) {
			dto.setCom_gallery_main_thumnail(getMainThumnail(dto.getCom_gallery_content()));
		}
		return list;
	}

	private String getMainThumnail(String content) {
		String mainThumnail = "";

		if (content.contains("img src=")) {
			int startIndex = content.indexOf("img src=") + 9;
			// System.out.println(content.charAt(startIndex));
			int endIndex = content.indexOf("\"", startIndex) - 1;
			if (startIndex < endIndex) {
				mainThumnail = content.substring(startIndex, endIndex);
			}
			// System.out.println(mainThumnail);
		}
		return mainThumnail;
	}	
	
	@Override
	public List<ComGalleryDTO> listCriteria(AlbumCriteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int countPaging(AlbumCriteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<ComGalleryDTO> listSearchCriteria(AlbumSearchCriteria cri) throws Exception {
		return getComGallerys(dao.listSearchCriteria(cri));
	}

	@Override
	public int listSearchCount(AlbumSearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public void createReply(ComGalleryReplyDTO dto) throws Exception {
		dao.createReply(dto);
	}

	@Override
	public void createReReply(ComGalleryReplyDTO dto) {
		dao.createReReply(dto);
	}

	@Override
	public void updatePos(ComGalleryReplyDTO dto) {
		dao.updatePos(dto);
	}

	@Override
	public ComGalleryReplyDTO ComGalleryParentPos(Integer no) {
		return dao.ComGalleryParentPos(no);
	}

	@Override
	public void updateReply(ComGalleryReplyDTO dto) throws Exception {
		
	}

	@Override
	public void deleteReply(ComGalleryReplyDTO dto) throws Exception {
		dao.deleteReply(dto);
	}

	@Override
	public List<ComGalleryReplyDTO> listAllReply(Integer bno) throws Exception {
		return dao.listAllReply(bno);
	}

	@Override
	public List<ComGalleryDTO> listAdmin(SearchCriteria cri) throws Exception {
		return dao.listAdmin(cri);
	}

	@Override
	public int listAdminCount(SearchCriteria cri) throws Exception {
		return dao.listAdminCount(cri);
	}

	@Override
	public List<ComGalleryDTO> listMypostAll(int mem_no) throws Exception {
		return dao.listMypostAll(mem_no);
	}

}
