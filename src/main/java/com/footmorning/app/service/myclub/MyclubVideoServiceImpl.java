package com.footmorning.app.service.myclub;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.MyclubVideoDTO;
import com.footmorning.app.domain.MyclubVideoReplyDTO;
import com.footmorning.app.persistence.MyclubVideoDAO;
import com.footmorning.app.service.MyclubVideoService;
import com.footmorning.app.util.AlbumCriteria;
import com.footmorning.app.util.AlbumSearchCriteria;
@Service
public class MyclubVideoServiceImpl implements MyclubVideoService {
	
	@Inject
	private MyclubVideoDAO dao;
	
	@Override
	public void register(MyclubVideoDTO dto) throws Exception {
		dao.create(dto);
	}

	@Override
	public MyclubVideoDTO read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void updateCount(Integer myclub_video_no) throws Exception {
		dao.updateCount(myclub_video_no);
	}

	@Override
	public void modify(MyclubVideoDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<MyclubVideoDTO> listAll() throws Exception {
		return getMyClubVideos(dao.listAll());
	}
	
	private List<MyclubVideoDTO> getMyClubVideos(List<MyclubVideoDTO> list) {
		for (MyclubVideoDTO dto : list) {
			dto.setMyclub_video_main_thumnail(getMainThumnail(dto.getMyclub_video_content()));
		}
		return list;
	}

	private String getMainThumnail(String content) {
		System.out.println("섬네일 메서드 컨텐트 : " + content);
		int startIndex = content.indexOf("<source src=") + 13;
		int endIndex = content.indexOf("\"", startIndex);
		System.out.println("시작" +startIndex+ "끝"+endIndex);
		if(endIndex < startIndex) {
			return "";
		}
		return content.substring(startIndex, endIndex);
	}		

	@Override
	public List<MyclubVideoDTO> listCriteria(AlbumCriteria cri) throws Exception {
		return getMyClubVideos(dao.listCriteria(cri));
	}

	@Override
	public int listCountCriteria(AlbumCriteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<MyclubVideoDTO> listSearchCriteria(AlbumSearchCriteria cri) throws Exception {
		return getMyClubVideos(dao.listSearchCriteria(cri));
	}

	@Override
	public int listSearchCount(AlbumSearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public void createReply(MyclubVideoReplyDTO dto) throws Exception {
		dao.createReply(dto);
	}

	@Override
	public void createReReply(MyclubVideoReplyDTO dto) {
		dao.createReReply(dto);
	}

	@Override
	public void updatePos(MyclubVideoReplyDTO dto) {
		dao.updatePos(dto);
	}

	@Override
	public MyclubVideoReplyDTO MyclubVideoParentPos(Integer no) {
		return dao.MyclubVideoParentPos(no);
	}

	@Override
	public void updateReply(MyclubVideoReplyDTO dto) throws Exception {
		
	}

	@Override
	public void deleteReply(MyclubVideoReplyDTO dto) throws Exception {
		dao.deleteReply(dto);
	}

	@Override
	public List<MyclubVideoReplyDTO> listAllReply(Integer bno) throws Exception {
		return dao.listAllReply(bno);
	}

}
