package com.footmorning.app.service.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComFreeDTO;
import com.footmorning.app.domain.ComFreeReplyDTO;
import com.footmorning.app.persistence.ComFreeDAO;
import com.footmorning.app.service.ComFreeService;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

@Service
public class ComFreeServiceImpl implements ComFreeService {
	
	@Autowired
	private ComFreeDAO dao;

	@Override
	public void register(ComFreeDTO dto) throws Exception {
		dao.create(dto);
	}

	/**
	 * ���� read
	 */
	@Override
	public ComFreeDTO read(Integer bno) throws Exception {
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
	public void modify(ComFreeDTO dto) throws Exception {
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
	public List<ComFreeDTO> listAll() throws Exception {
		return getMyClubNotices(dao.listAll());
	}
	
	// �����
	private List<ComFreeDTO> getMyClubNotices(List<ComFreeDTO> list) {
		for (ComFreeDTO dto : list) {
			dto.setCom_free_main_thumnail(dto.getCom_free_content());
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
	public List<ComFreeDTO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}
	
	/**
	 * 	��ä listSearchCriteria
	 */
	@Override
	public List<ComFreeDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
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
	public void createReply(ComFreeReplyDTO dto) throws Exception {
		dao.createReply(dto);

	}

	@Override
	public void createReReply(ComFreeReplyDTO dto) {

		dao.createReReply(dto);
	}

	@Override
	public void updatePos(ComFreeReplyDTO dto) {
		dao.updatePos(dto);
	}

	@Override
	public ComFreeReplyDTO MyclubNoticeParentPos(Integer no) {
		return dao.MyclubNoticeParentPos(no);
	}

	@Override
	public void updateReply(ComFreeReplyDTO dto) throws Exception {

	}

	@Override
	public void deleteReply(ComFreeReplyDTO dto) throws Exception {

		dao.deleteReply(dto);
	}

	@Override
	public List<ComFreeReplyDTO> listAllReply(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.listAllReply(bno);
	}

	@Override
	public List<ComFreeDTO> listMypostAll(int mem_no) throws Exception {
		return dao.listMypostAll(mem_no);
	}

}
