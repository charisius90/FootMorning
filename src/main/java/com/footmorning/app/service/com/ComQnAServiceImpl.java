package com.footmorning.app.service.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComQnADTO;
import com.footmorning.app.domain.ComQnAReplyDTO;
import com.footmorning.app.domain.ComQnADTO;
import com.footmorning.app.persistence.ComQnADAO;
import com.footmorning.app.service.ComQnAService;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

@Service
public class ComQnAServiceImpl implements ComQnAService {
	
	@Autowired
	private ComQnADAO dao;

	@Override
	public void register(ComQnADTO dto) throws Exception {
		dao.create(dto);
	}

	/**
	 * ���� read
	 */
	@Override
	public ComQnADTO read(Integer bno) throws Exception {
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
	public void modify(ComQnADTO dto) throws Exception {
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
	public List<ComQnADTO> listAll() throws Exception {
		return getMyClubNotices(dao.listAll());
	}
	
	// �����
	private List<ComQnADTO> getMyClubNotices(List<ComQnADTO> list) {
		for (ComQnADTO dto : list) {
			dto.setCom_qna_main_thumnail(dto.getCom_qna_content());
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
	public List<ComQnADTO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}
	
	/**
	 * 	��ä listSearchCriteria
	 */
	@Override
	public List<ComQnADTO> listSearchCriteria(SearchCriteria cri) throws Exception {
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
	public void createReply(ComQnAReplyDTO dto) throws Exception {
		dao.createReply(dto);

	}

	@Override
	public void createReReply(ComQnAReplyDTO dto) {

		dao.createReReply(dto);
	}

	@Override
	public void updatePos(ComQnAReplyDTO dto) {
		dao.updatePos(dto);
	}

	@Override
	public ComQnAReplyDTO MyclubNoticeParentPos(Integer no) {
		return dao.MyclubNoticeParentPos(no);
	}

	@Override
	public void updateReply(ComQnAReplyDTO dto) throws Exception {

	}

	@Override
	public void deleteReply(ComQnAReplyDTO dto) throws Exception {

		dao.deleteReply(dto);
	}

	@Override
	public List<ComQnAReplyDTO> listAllReply(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.listAllReply(bno);
	}

	@Override
	public List<ComQnADTO> listMypostAll(int mem_no) throws Exception {
		return dao.listMypostAll(mem_no);
	}



}
