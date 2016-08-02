package com.footmorning.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ClubMemberDTO;
import com.footmorning.app.persistence.ClubMemberDAO;
import com.footmorning.app.util.SearchClubCriteria;

@Service
public class ClubMemberServiceImpl implements ClubMemberService {
	@Autowired
	private ClubMemberDAO dao;

	@Override
	public String getTime() {
		return dao.getTime();
	}

	@Override
	public void insert(ClubMemberDTO dto) {
		dao.insert(dto);
	}

	@Override
	public void update(ClubMemberDTO dto) {
		dao.update(dto);
	}

	@Override
	public void delete(ClubMemberDTO dto) {
		dao.delete(dto);
	}

	@Override
	public List<ClubMemberDTO> listAll(Integer club_no) throws Exception {
		return dao.listAll(club_no);
	}

	@Override
	public List<ClubMemberDTO> listMember(Integer club_no) throws Exception {
		return dao.listMember(club_no);
	}
	
	@Override
	public List<ClubMemberDTO> listRequest(Integer club_no) throws Exception {
		return dao.listRequest(club_no);
	}

	@Override
	public ClubMemberDTO getWithMemno(Integer mem_no) throws Exception {
		return dao.getWithMemno(mem_no);
	}

	@Override
	public List<ClubMemberDTO> listSearchClubMemberCriteria(SearchClubCriteria clubcri) throws Exception{
		return dao.listSearchClubMemberCriteria(clubcri);
	}

	@Override
	public int listSearchClubMemberCount(SearchClubCriteria clubcri) throws Exception{
		return dao.listSearchClubMemberCount(clubcri);
	}

	@Override
	public int listRequestCount(SearchClubCriteria clubcri) throws Exception {
		return dao.listRequestcount(clubcri);
	}

	@Override
	public List<ClubMemberDTO> listRequest(SearchClubCriteria clubcri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
