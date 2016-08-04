package com.footmorning.app.service;

import java.util.List;

import com.footmorning.app.domain.MyclubTeamDTO;
import com.footmorning.app.domain.MyclubTeamReplyDTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

public interface MyclubTeamService {
	public void register(MyclubTeamDTO dto) throws Exception;

	public MyclubTeamDTO read(Integer bno) throws Exception;

	public void updateCount(Integer myclub_team_no) throws Exception;
	
	public void modify(MyclubTeamDTO dto) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<MyclubTeamDTO> listAll() throws Exception;

	public List<MyclubTeamDTO> listCriteria(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;	

	public List<MyclubTeamDTO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;	
	
	public void createReply(MyclubTeamReplyDTO dto) throws Exception;

	public void createReReply(MyclubTeamReplyDTO dto);

	public void updatePos(MyclubTeamReplyDTO dto);

	public MyclubTeamReplyDTO MyclubTeamParentPos(Integer no);

	public void updateReply(MyclubTeamReplyDTO dto) throws Exception;

	public void deleteReply(MyclubTeamReplyDTO dto) throws Exception;

	public List<MyclubTeamReplyDTO> listAllReply(Integer bno) throws Exception;

	public List<MyclubTeamDTO> listMypostAll(int mem_no) throws Exception;
}
