package com.footmorning.app.service.myclub;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.MyclubAlbumDTO;
import com.footmorning.app.domain.MyclubAlbumReplyDTO;
import com.footmorning.app.persistence.MyclubAlbumDAO;
import com.footmorning.app.service.MyclubAlbumService;
import com.footmorning.app.util.AlbumCriteria;
import com.footmorning.app.util.AlbumSearchCriteria;

@Service
public class MyclubAlbumServiceImpl implements MyclubAlbumService {
	
	@Inject
	private MyclubAlbumDAO dao;
	
	@Override
	public void register(MyclubAlbumDTO dto) throws Exception {
		dao.create(dto);
	}

	@Override
	public MyclubAlbumDTO read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void updateCount(Integer myclub_album_no) throws Exception {
		dao.updateCount(myclub_album_no);
	}

	@Override
	public void modify(MyclubAlbumDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<MyclubAlbumDTO> listAll() throws Exception {
		return getMyClubAlbums(dao.listAll());
	}
	
	private List<MyclubAlbumDTO> getMyClubAlbums(List<MyclubAlbumDTO> list) {
		for (MyclubAlbumDTO dto : list) {
			dto.setMyclub_album_main_thumnail(getMainThumnail(dto.getMyclub_album_content()));
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
	public List<MyclubAlbumDTO> listCriteria(AlbumCriteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(AlbumCriteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<MyclubAlbumDTO> listSearchCriteria(AlbumSearchCriteria cri) throws Exception {
		return getMyClubAlbums(dao.listSearchCriteria(cri));
	}

	@Override
	public int listSearchCount(AlbumSearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public void createReply(MyclubAlbumReplyDTO dto) throws Exception {
		dao.createReply(dto);
	}

	@Override
	public void createReReply(MyclubAlbumReplyDTO dto) {
		dao.createReReply(dto);
	}

	@Override
	public void updatePos(MyclubAlbumReplyDTO dto) {
		dao.updatePos(dto);
	}

	@Override
	public MyclubAlbumReplyDTO MyclubAlbumParentPos(Integer no) {
		return dao.MyclubAlbumParentPos(no);
	}

	@Override
	public void updateReply(MyclubAlbumReplyDTO dto) throws Exception {
		
	}

	@Override
	public void deleteReply(MyclubAlbumReplyDTO dto) throws Exception {
		dao.deleteReply(dto);
	}

	@Override
	public List<MyclubAlbumReplyDTO> listAllReply(Integer bno) throws Exception {
		return dao.listAllReply(bno);
	}

	@Override
	public List<MyclubAlbumDTO> listMypostAll(int mem_no) throws Exception {
		return dao.listMypostAll(mem_no);
	}

}
