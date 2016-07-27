package com.footmorning.app.persistence.com;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ComDiscussionWorldDTO;
import com.footmorning.app.persistence.ComDiscussionWorldDAO;

@Repository
public class ComDiscussionWorldDAOImpl implements ComDiscussionWorldDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.footmorning.mappers.comDiscussionWorldMapper";
	
	@Override
	public void register(ComDiscussionWorldDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE+".register", dto);
	}

	@Override
	public ComDiscussionWorldDTO read(Integer no) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".read", no);
	}

	@Override
	public void update(ComDiscussionWorldDTO dto) throws Exception {
		System.out.println("dao : " + dto);
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		sqlSession.update(NAMESPACE + ".delete", no);		
	}

	@Override
	public List<ComDiscussionWorldDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

}
