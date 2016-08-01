package com.footmorning.app.persistence.com;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ComVideoDTO_before;
import com.footmorning.app.persistence.ComVideoDAO_before;

@Repository
public class ComVideoDAOImpl_before implements ComVideoDAO_before {

	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "com.footmorning.mappers.comVideoMapper";
	
	@Override
	public void register(ComVideoDTO_before dto) throws Exception {
		sqlSession.insert(NAMESPACE+".register", dto);

	}

	@Override
	public ComVideoDTO_before read(Integer no) throws Exception {
	
		return sqlSession.selectOne(NAMESPACE +".read", no );
	}

	@Override
	public void update(ComVideoDTO_before dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		sqlSession.update(NAMESPACE + ".delete", no);		
	}

	@Override
	public List<ComVideoDTO_before> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

}
