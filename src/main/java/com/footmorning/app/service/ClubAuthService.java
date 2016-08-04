package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ClubAuthDTO;

public interface ClubAuthService {
	
	public void insert(ClubAuthDTO dto) throws Exception;
	
	public void update(ClubAuthDTO dto) throws Exception; 

	public void delete(ClubAuthDTO dto) throws Exception;
	
	public List<ClubAuthDTO> listAuthMaster(Integer no) throws Exception;
	
	public List<ClubAuthDTO> listAuthMgr(Integer no) throws Exception;
	
	public List<ClubAuthDTO> listAuthStaff(Integer no) throws Exception;
	
	public List<ClubAuthDTO> listAuthMember(Integer no) throws Exception;
}
