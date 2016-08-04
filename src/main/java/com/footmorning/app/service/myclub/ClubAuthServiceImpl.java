package com.footmorning.app.service.myclub;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.ClubAuthDTO;
import com.footmorning.app.persistence.ClubAuthDAO;
import com.footmorning.app.service.ClubAuthService;

@Service
public class ClubAuthServiceImpl implements ClubAuthService {
	
	@Inject
	private ClubAuthDAO dao;
	
	@Override
	public void insert(ClubAuthDTO dto) throws Exception {
		dao.insert(dto);
	}

	@Override
	public void update(ClubAuthDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void delete(ClubAuthDTO dto) throws Exception {
		dao.delete(dto);
	}

	@Override
	public List<ClubAuthDTO> listAuthMaster(Integer no) throws Exception {
		return dao.listAuthMaster(no);
	}

	@Override
	public List<ClubAuthDTO> listAuthMgr(Integer no) throws Exception {
		return dao.listAuthMgr(no);
	}

	@Override
	public List<ClubAuthDTO> listAuthStaff(Integer no) throws Exception {
		return dao.listAuthStaff(no);
	}

	@Override
	public List<ClubAuthDTO> listAuthMember(Integer no) throws Exception {
		return dao.listAuthMember(no);
	}

}
