package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.ClubMemberDTO;
import com.footmorning.app.util.ClubCriteria;
import com.footmorning.app.util.SearchClubCriteria;

/**
 * @author 박수항
 */
public interface ClubMemberService {
	public String getTime();
	public void insert(ClubMemberDTO dto);
	public void update(ClubMemberDTO dto);
	public void delete(ClubMemberDTO dto);
	public List<ClubMemberDTO> listAll(Integer club_no) throws Exception;
	public List<ClubMemberDTO> listMember(Integer club_no) throws Exception;
	public List<ClubMemberDTO> listRequest(Integer club_no) throws Exception;
	public ClubMemberDTO getWithMemno(Integer mem_no) throws Exception;
	public List<ClubMemberDTO> listSearchClubMemberCriteria(SearchClubCriteria clubcri) throws Exception;
	public int listSearchClubMemberCount(SearchClubCriteria clubcri) throws Exception;
	public List<ClubMemberDTO> listClubRequest(SearchClubCriteria clubcri) throws Exception;
	public int listClubRequestCount(SearchClubCriteria clubcri) throws Exception;
}
