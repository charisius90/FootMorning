package com.footmorning.app.service.com;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComGalleryDTO;
import com.footmorning.app.domain.ComVideoDTO;
import com.footmorning.app.domain.ComVideoReplyDTO;
import com.footmorning.app.persistence.ComVideoDAO;
import com.footmorning.app.service.ComVideoService;
import com.footmorning.app.util.AlbumCriteria;
import com.footmorning.app.util.AlbumSearchCriteria;
import com.footmorning.app.util.SearchCriteria;

@Service
public class ComVideoSerivceImpl implements ComVideoService {
	
	@Inject
	private ComVideoDAO dao;
	
	@Override
	public void create(ComVideoDTO dto) throws Exception {
		dao.create(dto);
	}

	@Override
	public ComVideoDTO read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void updateCount(Integer com_video_no) throws Exception {
		dao.updateCount(com_video_no);
	}

	@Override
	public void update(ComVideoDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<ComVideoDTO> listAll() throws Exception {
		return getComVideos(dao.listAll());
	}
	
	private List<ComVideoDTO> getComVideos(List<ComVideoDTO> list) {
		for (ComVideoDTO dto : list) {
			dto.setCom_video_main_thumnail(getMainThumnail(dto.getCom_video_content()));
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
	public List<ComVideoDTO> listCriteria(AlbumCriteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int countPaging(AlbumCriteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<ComVideoDTO> listSearchCriteria(AlbumSearchCriteria cri) throws Exception {
		return getComVideos(dao.listSearchCriteria(cri));
	}

	@Override
	public int listSearchCount(AlbumSearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public void createReply(ComVideoReplyDTO dto) throws Exception {
		dao.createReply(dto);
	}

	@Override
	public void createReReply(ComVideoReplyDTO dto) {
		dao.createReReply(dto);
		
	}

	@Override
	public void updatePos(ComVideoReplyDTO dto) {
		dao.updatePos(dto);
	}

	@Override
	public ComVideoReplyDTO ComVideoParentPos(Integer no) {
		return dao.ComVideoParentPos(no);
	}

	@Override
	public void updateReply(ComVideoReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReply(ComVideoReplyDTO dto) throws Exception {
		dao.deleteReply(dto);
	}

	@Override
	public List<ComVideoReplyDTO> listAllReply(Integer bno) throws Exception {
		return dao.listAllReply(bno);
	}

	@Override
	public List<ComVideoDTO> listAdmin(SearchCriteria cri) throws Exception {
		return dao.listAdmin(cri);
	}

	@Override
	public int listAdminCount(SearchCriteria cri) throws Exception {
		return dao.listAdminCount(cri);
	}

	@Override
	public List<ComVideoDTO> listMypostAll(int mem_no) throws Exception {
		return dao.listMypostAll(mem_no);
	}
}
