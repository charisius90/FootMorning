package com.footmorning.app.persistence.com;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ComBoastReplyDTO;
import com.footmorning.app.persistence.ComBoastReplyDAO;

/**
 * Ä¿¹Â´ÏÆ¼ ÀÚ¶û °Ô½ÃÆÇ ¸®ÇÃ DAO
 * @author ±è¼Ò¿µ
 */
@Repository
public class ComBoastReplyDAOImpl implements ComBoastReplyDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.footmorning.mappers.comBoastReplyMapper";

	@Override
	public void register(ComBoastReplyDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE + ".register", dto);
	}

	@Override
	public ComBoastReplyDTO read(Integer no) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", no);
	}

	@Override
	public void update(ComBoastReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", no);
	}

	@Override
	public List<ComBoastReplyDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

}
