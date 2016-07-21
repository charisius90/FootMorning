package com.footmorning.app.persistence.com;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.footmorning.app.domain.ComBoastDTO;
import com.footmorning.app.persistence.ComBoastDAO;

public class ComBoastDAOImpl implements ComBoastDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void register(ComBoastDTO dto) throws Exception {
		sqlSession.insert("register", dto);
	}

	@Override
	public ComBoastDTO read(Integer no) throws Exception {
		return sqlSession.selectOne("read", no);
	}

	@Override
	public void update(ComBoastDTO dto) throws Exception {
		sqlSession.update("update", dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		sqlSession.delete("delete", no);
	}

	@Override
	public List<ComBoastDTO> listAll() throws Exception {
		return sqlSession.selectList("listAll");
	}

}
