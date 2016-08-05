package com.footmorning.app.persistence;

import com.footmorning.app.domain.ClubAuthDTO;

public interface ClubAuthDAO {
	
	public void insert(ClubAuthDTO dto) throws Exception;
	
	public void update(ClubAuthDTO dto) throws Exception; 

	public void delete(ClubAuthDTO dto) throws Exception;
	
	public ClubAuthDTO getAuthMaster(Integer no) throws Exception;
	
	public ClubAuthDTO getAuthMgr(Integer no) throws Exception;
	
	public ClubAuthDTO getAuthStaff(Integer no) throws Exception;
	
	public ClubAuthDTO getAuthMember(Integer no) throws Exception;
	
	public ClubAuthDTO getAuthUser(Integer no) throws Exception;
}
