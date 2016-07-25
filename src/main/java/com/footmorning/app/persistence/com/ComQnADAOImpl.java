package com.footmorning.app.persistence.com;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ComQnADTO;
import com.footmorning.app.persistence.ComQnADAO;

@Repository
public class ComQnADAOImpl implements ComQnADAO {
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.footmorning.mappers.comQnAMapper";

	@Override
	public void register(ComQnADTO dto) throws Exception {
		sqlSession.insert(NAMESPACE + ".register", dto);
	}

	@Override
	public ComQnADTO read(Integer no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", no);
	}

	@Override
	public void update(ComQnADTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", no);
	}

	@Override
	public List<ComQnADTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

}
