package com.footmorning.app.service.com;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComDiscussionWorldDTO;
import com.footmorning.app.domain.ComDiscussionWorldReplyDTO;
import com.footmorning.app.persistence.ComDiscussionWorldDAO;
import com.footmorning.app.service.ComDiscussionWorldService;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

@Service
public class ComDiscussionWorldServiceImpl implements ComDiscussionWorldService {

	@Inject
	private ComDiscussionWorldDAO dao;
	
	@Override
	public void register(ComDiscussionWorldDTO dto) throws Exception {
		dao.create(dto);
	}

	/**
	 * ���� read
	 */
	@Override
	public ComDiscussionWorldDTO read(Integer bno) throws Exception {
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
	public void modify(ComDiscussionWorldDTO dto) throws Exception {
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
	public List<ComDiscussionWorldDTO> listAll() throws Exception {
		return getMyClubNotices(dao.listAll());
	}
	
	// �����
	private List<ComDiscussionWorldDTO> getMyClubNotices(List<ComDiscussionWorldDTO> list) {
		for (ComDiscussionWorldDTO dto : list) {
			dto.setCom_discussion_world_main_thumnail(dto.getCom_discussion_world_content());
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
	public List<ComDiscussionWorldDTO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}
	
	/**
	 * 	��ä listSearchCriteria
	 */
	@Override
	public List<ComDiscussionWorldDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
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
	public void createReply(ComDiscussionWorldReplyDTO dto) throws Exception {
		dao.createReply(dto);

	}

	@Override
	public void createReReply(ComDiscussionWorldReplyDTO dto) {

		dao.createReReply(dto);
	}

	@Override
	public void updatePos(ComDiscussionWorldReplyDTO dto) {
		dao.updatePos(dto);
	}

	@Override
	public ComDiscussionWorldReplyDTO MyclubNoticeParentPos(Integer no) {
		return dao.MyclubNoticeParentPos(no);
	}

	@Override
	public void updateReply(ComDiscussionWorldReplyDTO dto) throws Exception {

	}

	@Override
	public void deleteReply(ComDiscussionWorldReplyDTO dto) throws Exception {

		dao.deleteReply(dto);
	}

	@Override
	public List<ComDiscussionWorldReplyDTO> listAllReply(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.listAllReply(bno);
	}

	@Override
	public List<ComDiscussionWorldDTO> listMypostAll(int mem_no) throws Exception {
		return dao.listMypostAll(mem_no);
	}


}
