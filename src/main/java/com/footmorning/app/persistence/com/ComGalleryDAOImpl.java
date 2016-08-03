package com.footmorning.app.persistence.com;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ComGalleryDTO;
import com.footmorning.app.domain.ComGalleryReplyDTO;
import com.footmorning.app.persistence.ComGalleryDAO;
import com.footmorning.app.util.AlbumCriteria;
import com.footmorning.app.util.AlbumSearchCriteria;
import com.footmorning.app.util.SearchCriteria;

@Repository
public class ComGalleryDAOImpl implements ComGalleryDAO {
	
	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.footmorning.mappers.comGalleryMapper";
	
	@Override
	public void create(ComGalleryDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", dto);
	}

	@Override
	public ComGalleryDTO read(Integer bno) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", bno);
	}

	@Override
	public void updateCount(Integer com_gallery_no) throws Exception {
		sqlSession.selectOne(NAMESPACE + ".updateCount", com_gallery_no);
	}

	@Override
	public void update(ComGalleryDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", bno);
	}

	@Override
	public List<ComGalleryDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public List<ComGalleryDTO> listCriteria(AlbumCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listCriteria", cri);
	}

	@Override
	public int countPaging(AlbumCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countPaging", cri);
	}

	@Override
	public List<ComGalleryDTO> listSearchCriteria(AlbumSearchCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(AlbumSearchCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listSearchCount", cri);
	}

	@Override
	public void createReply(ComGalleryReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".updatePos");
		sqlSession.insert(NAMESPACE + ".createReply", dto);
	}

	@Override
	public void createReReply(ComGalleryReplyDTO dto) {
		sqlSession.insert(NAMESPACE + ".createReReply", dto);
	}

	@Override
	public void updatePos(ComGalleryReplyDTO dto) {
		sqlSession.update(NAMESPACE + ".replyUpdatePos", dto);
	}

	@Override
	public ComGalleryReplyDTO ComGalleryParentPos(Integer no) {
		return sqlSession.selectOne(NAMESPACE + ".parentInfo", no);
	}

	@Override
	public void updateReply(ComGalleryReplyDTO dto) throws Exception {
		
	}

	@Override
	public void deleteReply(ComGalleryReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".deleteReply", dto);
	}

	@Override
	public List<ComGalleryReplyDTO> listAllReply(Integer bno) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listReply", bno);
	}

	@Override
	public List<ComGalleryDTO> listAdmin(SearchCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listadmin", cri);
	}

	@Override
	public int listAdminCount(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listadmincount", cri);
	}
	

}
