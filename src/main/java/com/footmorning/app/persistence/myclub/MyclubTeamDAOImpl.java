package com.footmorning.app.persistence.myclub;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.MyclubTeamDTO;
import com.footmorning.app.domain.MyclubTeamReplyDTO;
import com.footmorning.app.persistence.MyclubTeamDAO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

@Repository
public class MyclubTeamDAOImpl implements MyclubTeamDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.footmorning.mappers.myclub.myclubTeamMapper";

	
	@Override
	public void create(MyclubTeamDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", dto);
	}

	@Override
	public MyclubTeamDTO read(Integer bno) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", bno);
	}

	@Override
	public void updateCount(Integer myclub_team_no) throws Exception {
		sqlSession.selectOne(NAMESPACE + ".updateCount", myclub_team_no);
	}

	@Override
	public void update(MyclubTeamDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", bno);
	}

	@Override
	public List<MyclubTeamDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public List<MyclubTeamDTO> listCriteria(Criteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countPaging", cri);
	}

	@Override
	public List<MyclubTeamDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listSearchCount", cri);
	}

	@Override
	public void createReply(MyclubTeamReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".updatePos");
		sqlSession.insert(NAMESPACE + ".createReply", dto);
	}

	@Override
	public void createReReply(MyclubTeamReplyDTO dto) {
		sqlSession.insert(NAMESPACE + ".createReReply", dto);
	}

	@Override
	public void updatePos(MyclubTeamReplyDTO dto) {
		sqlSession.update(NAMESPACE + ".replyUpdatePos", dto);
		
	}

	@Override
	public MyclubTeamReplyDTO MyclubTeamParentPos(Integer no) {
		return sqlSession.selectOne(NAMESPACE + ".parentInfo", no);
	}

	@Override
	public void updateReply(MyclubTeamReplyDTO dto) throws Exception {
		
	}

	@Override
	public void deleteReply(MyclubTeamReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".deleteReply", dto);
	}

	@Override
	public List<MyclubTeamReplyDTO> listAllReply(Integer bno) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listReply", bno);
	}

	@Override
	public List<MyclubTeamDTO> listMypostAll(int mem_no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listMypostAll", mem_no);
	}

}
