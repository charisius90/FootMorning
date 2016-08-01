package com.footmorning.app.service.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ComBoastDTO;
import com.footmorning.app.domain.ComBoastReplyDTO;
import com.footmorning.app.persistence.ComBoastDAO;
import com.footmorning.app.service.ComBoastService;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;
/**
 * 
 * @author 손승한
 *
 */
@Service
public class ComBoastServiceImpl implements ComBoastService {
	
	@Autowired
	private ComBoastDAO dao;
	
	@Override
	public void register(ComBoastDTO dto) throws Exception {
		dao.create(dto);
	}

	/**
	 * ���� read
	 */
	@Override
	public ComBoastDTO read(Integer bno) throws Exception {
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
	public void modify(ComBoastDTO dto) throws Exception {
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
	public List<ComBoastDTO> listAll() throws Exception {
		return getMyClubNotices(dao.listAll());
	}
	
	// �����
	private List<ComBoastDTO> getMyClubNotices(List<ComBoastDTO> list) {
		for (ComBoastDTO dto : list) {
			dto.setCom_boast_main_thumnail(dto.getCom_boast_content());
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
	public List<ComBoastDTO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}
	
	/**
	 * 	��ä listSearchCriteria
	 */
	@Override
	public List<ComBoastDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
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
	public void createReply(ComBoastReplyDTO dto) throws Exception {
		dao.createReply(dto);

	}

	@Override
	public void createReReply(ComBoastReplyDTO dto) {

		dao.createReReply(dto);
	}

	@Override
	public void updatePos(ComBoastReplyDTO dto) {
		dao.updatePos(dto);
	}

	@Override
	public ComBoastReplyDTO MyclubNoticeParentPos(Integer no) {
		return dao.MyclubNoticeParentPos(no);
	}

	@Override
	public void updateReply(ComBoastReplyDTO dto) throws Exception {

	}

	@Override
	public void deleteReply(ComBoastReplyDTO dto) throws Exception {

		dao.deleteReply(dto);
	}

	@Override
	public List<ComBoastReplyDTO> listAllReply(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.listAllReply(bno);
	}

}
