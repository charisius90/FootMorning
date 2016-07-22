package com.footmorning.app.persistence.com;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ComFreeDTO;
import com.footmorning.app.persistence.ComFreeDAO;

@Repository
public class ComFreeDAOImpl implements ComFreeDAO {

	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "com.footmorning.mappers.comFreeMapper";
	
	@Override
	public void register(ComFreeDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE+".register", dto);

	}

	@Override
	public ComFreeDTO read(Integer no) throws Exception {
	
		return sqlSession.selectOne(NAMESPACE +".read", no );
	}

	@Override
	public void update(ComFreeDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		sqlSession.update(NAMESPACE + ".delete", no);		
	}

	@Override
	public List<ComFreeDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + "listAll");
	}

}
