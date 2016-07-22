package com.footmorning.app.persistence.com;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ComBoastDTO;
import com.footmorning.app.persistence.ComBoastDAO;

/**
 * 커뮤니티 자랑게시판 DAO
 * @author 박수항
 */
@Repository
public class ComBoastDAOImpl implements ComBoastDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.footmorning.mappers.comBoastMapper";

	@Override
	public void register(ComBoastDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE + ".register", dto);
	}

	@Override
	public ComBoastDTO read(Integer no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", no);
	}

	@Override
	public void update(ComBoastDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", no);
	}

	@Override
	public List<ComBoastDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

}
