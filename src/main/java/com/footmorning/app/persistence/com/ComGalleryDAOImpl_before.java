package com.footmorning.app.persistence.com;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ComGalleryDTO_before;
import com.footmorning.app.persistence.ComGalleryDAO_before;

@Repository
public class ComGalleryDAOImpl_before implements ComGalleryDAO_before {

	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "com.footmorning.mappers.comGalleryMapper";
	
	@Override
	public void register(ComGalleryDTO_before dto) throws Exception {
		sqlSession.insert(NAMESPACE+".register", dto);

	}

	@Override
	public ComGalleryDTO_before read(Integer no) throws Exception {
	
		return sqlSession.selectOne(NAMESPACE +".read", no );
	}

	@Override
	public void update(ComGalleryDTO_before dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer no) throws Exception {
		sqlSession.update(NAMESPACE + ".delete", no);		
	}

	@Override
	public List<ComGalleryDTO_before> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

}
