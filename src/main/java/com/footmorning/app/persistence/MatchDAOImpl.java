package com.footmorning.app.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.MatchDTO;

@Repository
public class MatchDAOImpl implements MatchDAO {

	private static final String NAMESPASE = "com.footmorning.mappers.MatchMapper";
	private static final String NAMESPASE2 = "com.footmorning.mappers.ChallengeMapper";

	@Inject
	private SqlSession SqlSession;

	@Override
	public void matchRegister(MatchDTO dto) throws Exception {
		System.out.println("matchRegister : " + dto.toString());
		MatchDTO dtoReal = checkGameNo(dto);
		SqlSession.insert(NAMESPASE + ".register", dtoReal);
	}

	@Override
	public MatchDTO checkGameNo(MatchDTO dto) throws Exception {
		System.out.println("checkGameNo : " + dto.toString());
		int game_no = Integer.parseInt(SqlSession.selectOne(NAMESPASE + ".checkGameNo", dto));
		System.out.println("game_no : " + game_no);
		if (game_no > 0) {
			dto.setGame_no(game_no + 1);
		} else {
			dto.setGame_no(1);
		}
		return dto;
	}

	@Override
	public void matchReciveRegister(MatchDTO dto) throws Exception {
		SqlSession.insert(NAMESPASE + ".registerRecive", dto);
	}

	@Override
	public List<MatchDTO> matchListAll() throws Exception {

		return SqlSession.selectList(NAMESPASE + ".listAll");
	}

	@Override
	public List<MatchDTO> matchListWithClubNo(int club_no) throws Exception {
		return SqlSession.selectList(NAMESPASE + ".listWithClubNo", club_no);
	}

	@Override
	public List<MatchDTO> matchListWithClubNoUnconnect(int club_no) throws Exception {
		return SqlSession.selectList(NAMESPASE + ".listWithClubNoUnconnect", club_no);
	}

	@Override
	public MatchDTO matchWithGameNo(int game_no) throws Exception {
		return SqlSession.selectOne(NAMESPASE + ".matchWithGameNo", game_no);
	}

	@Override
	public MatchDTO matchWithGameNoAndGameFlag(MatchDTO dto) throws Exception {
		return SqlSession.selectOne(NAMESPASE + ".matchWithGameNoAndGameFlag", dto);
	}

	@Override
	public void matchDelete(int game_no) throws Exception {
		SqlSession.update(NAMESPASE2 + ".updateCancle", game_no);
		SqlSession.update(NAMESPASE + ".updateCancle", game_no);
	}

	@Override
	public String myClubName(int club_no) throws Exception {
		return SqlSession.selectOne(NAMESPASE + ".myclubName", club_no);
	}

	@Override
	public List<MatchDTO> matchListWithClubNoThird(int club_no) throws Exception {
		return SqlSession.selectList(NAMESPASE + ".listWithClubNoDateNull", club_no);
	}

	@Override
	public Integer gameNoMax() throws Exception {
		return SqlSession.selectOne(NAMESPASE + ".gameNoMax");
	}

	@Override
	public void editHome(MatchDTO dto) throws Exception {
		SqlSession.update(NAMESPASE + ".editHome", dto);
	}

	@Override
	public void editAway(MatchDTO dto) throws Exception {
		SqlSession.update(NAMESPASE + ".editAway", dto);

	}
}
