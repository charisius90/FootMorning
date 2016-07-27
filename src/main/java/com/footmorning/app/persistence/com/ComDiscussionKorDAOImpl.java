package com.footmorning.app.persistence.com;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ComDiscussionKorDTO;
import com.footmorning.app.persistence.ComDiscussionKorDAO;

@Repository
public class ComDiscussionKorDAOImpl implements ComDiscussionKorDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.footmorning.mappers.comDiscussionKorMapper";
	
	@Override
	public void register(ComDiscussionKorDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE+".register", dto);
	}

	@Override
	public ComDiscussionKorDTO read(Integer no) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".read", no);
	}

	@Override
	public void update(ComDiscussionKorDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		sqlSession.update(NAMESPACE + ".delete", no);		
	}

	@Override
	public List<ComDiscussionKorDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

}
