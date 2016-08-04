package com.footmorning.app.service.myclub;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.MyclubTeamDTO;
import com.footmorning.app.domain.MyclubTeamReplyDTO;
import com.footmorning.app.persistence.MyclubTeamDAO;
import com.footmorning.app.service.MyclubTeamService;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

@Service
public class MyclubTeamServiceImpl implements MyclubTeamService {
	
	@Inject
	private MyclubTeamDAO dao;
	
	@Override
	public void register(MyclubTeamDTO dto) throws Exception {
		dao.create(dto);
	}

	@Override
	public MyclubTeamDTO read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void updateCount(Integer myclub_team_no) throws Exception {
		dao.updateCount(myclub_team_no);
	}

	@Override
	public void modify(MyclubTeamDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<MyclubTeamDTO> listAll() throws Exception {
		return getMyClubTeams(dao.listAll());
	}
	
	private List<MyclubTeamDTO> getMyClubTeams(List<MyclubTeamDTO> list) {
		for (MyclubTeamDTO dto : list) {
			dto.setMyclub_team_main_thumnail(getMainThumnail(dto.getMyclub_team_content()));
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
	public List<MyclubTeamDTO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<MyclubTeamDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return getMyClubTeams(dao.listSearchCriteria(cri));
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public void createReply(MyclubTeamReplyDTO dto) throws Exception {
		dao.createReply(dto);
	}

	@Override
	public void createReReply(MyclubTeamReplyDTO dto) {
		dao.createReReply(dto);
	}

	@Override
	public void updatePos(MyclubTeamReplyDTO dto) {
		dao.updatePos(dto);
	}

	@Override
	public MyclubTeamReplyDTO MyclubTeamParentPos(Integer no) {
		return dao.MyclubTeamParentPos(no);
	}

	@Override
	public void updateReply(MyclubTeamReplyDTO dto) throws Exception {
		
	}

	@Override
	public void deleteReply(MyclubTeamReplyDTO dto) throws Exception {
		dao.deleteReply(dto);
	}

	@Override
	public List<MyclubTeamReplyDTO> listAllReply(Integer bno) throws Exception {
		return dao.listAllReply(bno);
	}

	@Override
	public List<MyclubTeamDTO> listMypostAll(int mem_no) throws Exception {
		return dao.listMypostAll(mem_no);
	}

}
