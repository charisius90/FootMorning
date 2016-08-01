package com.footmorning.app.service.com;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComDiscussionKorDTO;
import com.footmorning.app.domain.ComDiscussionKorReplyDTO;
import com.footmorning.app.domain.ComDiscussionKorDTO;
import com.footmorning.app.persistence.ComDiscussionKorDAO;
import com.footmorning.app.service.ComDiscussionKorService;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

@Service
public class ComDiscussionKorServiceImpl implements ComDiscussionKorService {
	
	@Inject
	private ComDiscussionKorDAO dao;

	@Override
	public void register(ComDiscussionKorDTO dto) throws Exception {
		dao.create(dto);
	}

	/**
	 * ���� read
	 */
	@Override
	public ComDiscussionKorDTO read(Integer bno) throws Exception {
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
	public void modify(ComDiscussionKorDTO dto) throws Exception {
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
	public List<ComDiscussionKorDTO> listAll() throws Exception {
		return getMyClubNotices(dao.listAll());
	}
	
	// �����
	private List<ComDiscussionKorDTO> getMyClubNotices(List<ComDiscussionKorDTO> list) {
		for (ComDiscussionKorDTO dto : list) {
			dto.setCom_discussion_kor_main_thumnail(dto.getCom_discussion_kor_content());
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
	public List<ComDiscussionKorDTO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}
	
	/**
	 * 	��ä listSearchCriteria
	 */
	@Override
	public List<ComDiscussionKorDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
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
	public void createReply(ComDiscussionKorReplyDTO dto) throws Exception {
		dao.createReply(dto);

	}

	@Override
	public void createReReply(ComDiscussionKorReplyDTO dto) {

		dao.createReReply(dto);
	}

	@Override
	public void updatePos(ComDiscussionKorReplyDTO dto) {
		dao.updatePos(dto);
	}

	@Override
	public ComDiscussionKorReplyDTO MyclubNoticeParentPos(Integer no) {
		return dao.MyclubNoticeParentPos(no);
	}

	@Override
	public void updateReply(ComDiscussionKorReplyDTO dto) throws Exception {

	}

	@Override
	public void deleteReply(ComDiscussionKorReplyDTO dto) throws Exception {

		dao.deleteReply(dto);
	}

	@Override
	public List<ComDiscussionKorReplyDTO> listAllReply(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.listAllReply(bno);
	}

}
