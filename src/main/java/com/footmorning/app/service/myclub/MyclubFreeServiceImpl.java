package com.footmorning.app.service.myclub;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.MyclubFreeDTO;
import com.footmorning.app.domain.MyclubFreeReplyDTO;
import com.footmorning.app.persistence.MyclubFreeDAO;
import com.footmorning.app.service.MyclubFreeService;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

@Service
public class MyclubFreeServiceImpl implements MyclubFreeService{
	@Inject
	private MyclubFreeDAO dao;

	@Override
	public void register(MyclubFreeDTO dto) throws Exception {
		dao.create(dto);
	}

	@Override
	public MyclubFreeDTO read(Integer bno) throws Exception {
		return dao.read(bno);
	}
	
	@Override
	public void updateCount(Integer myclub_free_no) throws Exception {
		dao.updateCount(myclub_free_no);
	}

	@Override
	public void modify(MyclubFreeDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<MyclubFreeDTO> listAll() throws Exception {
		return getMyClubFrees(dao.listAll());
	}
	
	private List<MyclubFreeDTO> getMyClubFrees(List<MyclubFreeDTO> list) {
		for (MyclubFreeDTO dto : list) {
			dto.setMyclub_free_main_thumnail(getMainThumnail(dto.getMyclub_free_content()));
		}
		return list;
	}

	private String getMainThumnail(String content) {
		String mainThumnail = "";

		if (content.contains("img src=")) {
			int startIndex = content.indexOf("img src=") + 9;
			int endIndex = content.indexOf("\"", startIndex) - 1;
			if (startIndex < endIndex) {
				mainThumnail = content.substring(startIndex, endIndex);
			}
		}
		return mainThumnail;
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}
	
	@Override
	public List<MyclubFreeDTO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}
	
	@Override
	public List<MyclubFreeDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearchCriteria(cri);
	}
	
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}
	
	@Override
	public void createReply(MyclubFreeReplyDTO dto) throws Exception {
		dao.createReply(dto);

	}

	@Override
	public void createReReply(MyclubFreeReplyDTO dto) {

		dao.createReReply(dto);
	}

	@Override
	public void updatePos(MyclubFreeReplyDTO dto) {
		dao.updatePos(dto);
	}

	@Override
	public MyclubFreeReplyDTO MyclubFreeParentPos(Integer no) {
		return dao.MyclubFreeParentPos(no);
	}

	@Override
	public void updateReply(MyclubFreeReplyDTO dto) throws Exception {

	}

	@Override
	public void deleteReply(MyclubFreeReplyDTO dto) throws Exception {

		dao.deleteReply(dto);
	}

	@Override
	public List<MyclubFreeReplyDTO> listAllReply(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.listAllReply(bno);
	}

	@Override
	public List<MyclubFreeDTO> listMypostAll(int mem_no) throws Exception {
		return dao.listMypostAll(mem_no);
	}
}
