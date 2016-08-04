package com.footmorning.app.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.FirstLineupDTO;
import com.footmorning.app.domain.FormationDTO;
import com.footmorning.app.domain.MatchDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.domain.SubLineupDTO;

@Repository
public class MyclubGamePrepareDAOImpl implements MyclubGamePrepareDAO {
	
	private static final String NAMESPASE="com.footmorning.mappers.gamePrepareMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public String checkLineupNo(MatchDTO dto) throws Exception {
		return sqlSession.selectOne(NAMESPASE+".checkLineupNo", dto);
	}

	@Override
	public List<MemberDTO> listMemberWithClubNo(int club_no) throws Exception {
		return sqlSession.selectList(NAMESPASE+".listMemberWithClubNo", club_no);
	}

	@Override
	public void registerFirstLineup(FirstLineupDTO dto) throws Exception {
		sqlSession.insert(NAMESPASE+".registerFirstLineup", dto);
	}

	@Override
	public void registerSubLineup(SubLineupDTO dto) throws Exception {
		sqlSession.insert(NAMESPASE+".registerSubLineup", dto);
	}

	@Override
	public void registerFormation(FormationDTO dto) throws Exception {
		sqlSession.insert(NAMESPASE+".registerFormation", dto);
	}

	@Override
	public void deleteFirstLineup(String lineup_no) throws Exception {
		sqlSession.delete(NAMESPASE + ".deleteFirstLineup", lineup_no);
	}

	@Override
	public void deleteSubLineup(String lineup_no) throws Exception {
		sqlSession.delete(NAMESPASE + ".deleteSubLineup", lineup_no);
	}

	@Override
	public void deleteFormation(String lineup_no) throws Exception {
		sqlSession.delete(NAMESPASE + ".deleteFormation", lineup_no);
	}

	@Override
	public FirstLineupDTO firstLineupWithLineupNo(String lineup_no) throws Exception {
		return sqlSession.selectOne(NAMESPASE+".firstLineupWithLineupNo", lineup_no);
	}

	@Override
	public SubLineupDTO subLineupWithLineupNo(String lineup_no) throws Exception {
		return sqlSession.selectOne(NAMESPASE+".subLineupWithLineupNo", lineup_no);
	}

	@Override
	public FormationDTO formationWithLineupNo(String lineup_no) throws Exception {
		return sqlSession.selectOne(NAMESPASE+".formationWithLineupNo", lineup_no);
	}
}
