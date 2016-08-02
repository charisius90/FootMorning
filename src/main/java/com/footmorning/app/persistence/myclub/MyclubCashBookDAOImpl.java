package com.footmorning.app.persistence.myclub;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.MyclubCashBookDTO;
import com.footmorning.app.persistence.MyclubCashBookDAO;

@Repository
public class MyclubCashBookDAOImpl implements MyclubCashBookDAO {
	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "com.footmorning.mappers.myclub.myclubCashBookMapper";

	@Override
	public String getTime() {
		return sqlSession.selectOne(NAMESPACE + ".getTime");
	}

	@Override
	public void insert(MyclubCashBookDTO dto) {
		sqlSession.insert(NAMESPACE + ".insert", dto);
	}

	@Override
	public void update(MyclubCashBookDTO dto) {
		sqlSession.insert(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer no) {
		sqlSession.insert(NAMESPACE + ".delete", no);
	}

	@Override
	public MyclubCashBookDTO getWithNo(Integer no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getWithNo", no);
	}

	@Override
	public List<MyclubCashBookDTO> listAllWithClubNo(Integer no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAllWithClubNo", no);
	}

}
