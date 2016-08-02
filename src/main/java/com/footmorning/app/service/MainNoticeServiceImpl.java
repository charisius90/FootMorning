package com.footmorning.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.MainNoticeDTO;
import com.footmorning.app.domain.MainNoticeReplyDTO;
import com.footmorning.app.persistence.MainNoticeDAO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;
/**
 * 
 * @author 손승한
 *
 */
@Service
public class MainNoticeServiceImpl implements MainNoticeService {
	
	@Autowired
	private MainNoticeDAO dao;
	
	@Override
	public void register(MainNoticeDTO dto) throws Exception {
		dao.create(dto);
	}

	/**
	 * ���� read
	 */
	@Override
	public MainNoticeDTO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}
	
	@Override
	public void updateCount(Integer no) throws Exception {
		dao.updateCount(no);
	}

	/**
	 * ���� update
	 */
	@Override
	public void modify(MainNoticeDTO dto) throws Exception {
		dao.update(dto);
	}

	/**
	 * ���� delete
	 */
	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<MainNoticeDTO> listAll() throws Exception {
		return getMyClubNotices(dao.listAll());
	}
	
	// �����
	private List<MainNoticeDTO> getMyClubNotices(List<MainNoticeDTO> list) {
		for (MainNoticeDTO dto : list) {
			dto.setMain_notice_main_thumnail(dto.getMain_notice_content());
		}
		return list;
	}

	// �����
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

	/**
	 * 	��ä listCountCriteria
	 */
	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}
	
	/**
	 * 	��ä listCriteria
	 */
	@Override
	public List<MainNoticeDTO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}
	
	/**
	 * 	��ä listSearchCriteria
	 */
	@Override
	public List<MainNoticeDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearchCriteria(cri);
	}
	
	/**
	 *  ��ä listSearchCount
	 */
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}
	
	/**
	 * ����,���� reply service dao�� ����
	 */
	@Override
	public void createReply(MainNoticeReplyDTO dto) throws Exception {
		dao.createReply(dto);

	}

	@Override
	public void createReReply(MainNoticeReplyDTO dto) {

		dao.createReReply(dto);
	}

	@Override
	public void updatePos(MainNoticeReplyDTO dto) {
		dao.updatePos(dto);
	}

	@Override
	public MainNoticeReplyDTO MyclubNoticeParentPos(Integer no) {
		return dao.MyclubNoticeParentPos(no);
	}

	@Override
	public void updateReply(MainNoticeReplyDTO dto) throws Exception {

	}

	@Override
	public void deleteReply(MainNoticeReplyDTO dto) throws Exception {

		dao.deleteReply(dto);
	}

	@Override
	public List<MainNoticeReplyDTO> listAllReply(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.listAllReply(bno);
	}

}
