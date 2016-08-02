package com.footmorning.app.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ClubMemberDTO;
import com.footmorning.app.util.ClubCriteria;
import com.footmorning.app.util.SearchClubCriteria;

@Repository
public class ClubMemberDAOImpl implements ClubMemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "com.footmorning.mappers.clubMemberMapper";

	@Override
	public String getTime() {
		return sqlSession.selectOne(NAMESPACE + ".getTime");
	}

	@Override
	public void insert(ClubMemberDTO dto) {
		sqlSession.insert(NAMESPACE + ".insert", dto);
	}
	
	@Override
	public void update(ClubMemberDTO dto) {
		sqlSession.insert(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(ClubMemberDTO dto) {
		sqlSession.delete(NAMESPACE + ".delete", dto);
	}

	@Override
	public List<ClubMemberDTO> listAll(Integer club_no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll", club_no);
	}

	@Override
	public List<ClubMemberDTO> listMember(Integer club_no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listMember", club_no);
	}
	
	@Override
	public List<ClubMemberDTO> listRequest(Integer club_no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listRequest", club_no);
	}

	@Override
	public ClubMemberDTO getWithMemno(Integer mem_no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getWithMemno", mem_no);
	}

	@Override
	public List<ClubMemberDTO> listSearchClubMemberCriteria(SearchClubCriteria clubcri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listMember", clubcri);
	}

	@Override
	public int listSearchClubMemberCount(SearchClubCriteria clubcri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listMemberCount", clubcri);
	}

	@Override
	public List<ClubMemberDTO> listClubRequest(SearchClubCriteria clubcri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listRequest", clubcri);
	}

	@Override
	public int listClubRequestcount(SearchClubCriteria clubcri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listRequestCount", clubcri);
	}
	
}
