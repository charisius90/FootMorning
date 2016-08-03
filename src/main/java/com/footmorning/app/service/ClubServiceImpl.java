package com.footmorning.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.persistence.ClubDAO;
import com.footmorning.app.persistence.MemberDAO;
import com.footmorning.app.util.SearchClubCriteria;
import com.footmorning.app.util.SearchCriteria;

@Service
public class ClubServiceImpl implements ClubService {
	
	@Autowired
	private ClubDAO dao;

	@Override
	public String getTime() {
		return dao.getTime();
	}

	@Override
	public void insert(ClubDTO dto) {
		dao.insert(dto);
	}

	@Override
	public void update(ClubDTO dto) {
		dao.update(dto);
	}

	@Override
	public void delete(Integer no) {
		dao.delete(no);
	}

	@Override
	public ClubDTO getClubInfo(String name) throws Exception {
		return dao.getClubInfo(name);
	}

	@Override
	public List<ClubDTO> listAll() throws Exception {
		System.out.println("clubserviceimpl dao : " + dao);
		return dao.listAll();
	}
	
	@Override
	public List<ClubDTO> popularityListAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.popularityListAll();
	}

	@Override
	public ClubDTO getWithNo(Integer no) throws Exception {
		return dao.getWithNo(no);
	}

	@Override
	public List<ClubDTO> listSearchClubCriteria(SearchClubCriteria clubcri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchClubCriteria(clubcri);
	}

	@Override
	public int listSearchClubCount(SearchClubCriteria clubcri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchClubCount(clubcri);
	}

	@Override
	public List<ClubDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearchCriteria(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

}
