package com.footmorning.app.service.myclub;

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
	public ClubAuthDTO getAuthMaster(Integer no) throws Exception {
		return dao.getAuthMaster(no);
	}

	@Override
	public ClubAuthDTO getAuthMgr(Integer no) throws Exception {
		return dao.getAuthMgr(no);
	}

	@Override
	public ClubAuthDTO getAuthStaff(Integer no) throws Exception {
		return dao.getAuthStaff(no);
	}

	@Override
	public ClubAuthDTO getAuthMember(Integer no) throws Exception {
		return dao.getAuthMember(no);
	}
	
	@Override
	public ClubAuthDTO getAuthUser(Integer no) throws Exception {
		return dao.getAuthUser(no);
	}

}
