package com.footmorning.app.persistence.com;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ComGalleryDTO;
import com.footmorning.app.persistence.ComGalleryDAO;

@Repository
public class ComGalleryDAOImpl implements ComGalleryDAO {

	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "com.footmorning.mappers.comGalleryMapper";
	
	@Override
	public void register(ComGalleryDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE+".register", dto);

	}

	@Override
	public ComGalleryDTO read(Integer no) throws Exception {
	
		return sqlSession.selectOne(NAMESPACE +".read", no );
	}

	@Override
	public void update(ComGalleryDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		sqlSession.update(NAMESPACE + ".delete", no);		
	}

	@Override
	public List<ComGalleryDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + "listAll");
	}

}
