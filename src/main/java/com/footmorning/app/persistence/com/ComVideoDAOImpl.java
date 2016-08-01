package com.footmorning.app.persistence.com;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ComVideoDTO;
import com.footmorning.app.domain.ComVideoReplyDTO;
import com.footmorning.app.persistence.ComVideoDAO;
import com.footmorning.app.util.AlbumCriteria;
import com.footmorning.app.util.AlbumSearchCriteria;

@Repository
public class ComVideoDAOImpl implements ComVideoDAO {
	
	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.footmorning.mappers.comVideoMapper";
	
	@Override
	public void create(ComVideoDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", dto);
	}

	@Override
	public ComVideoDTO read(Integer bno) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", bno);
	}

	@Override
	public void updateCount(Integer com_video_no) throws Exception {
		sqlSession.selectOne(NAMESPACE + ".updateCount", com_video_no);
	}

	@Override
	public void update(ComVideoDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", bno);
	}

	@Override
	public List<ComVideoDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public List<ComVideoDTO> listCriteria(AlbumCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listCriteria", cri);
	}

	@Override
	public int countPaging(AlbumCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countPaging", cri);
	}

	@Override
	public List<ComVideoDTO> listSearchCriteria(AlbumSearchCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(AlbumSearchCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listSearchCount", cri);
	}

	@Override
	public void createReply(ComVideoReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".updatePos");
		sqlSession.insert(NAMESPACE + ".createReply", dto);
	}

	@Override
	public void createReReply(ComVideoReplyDTO dto) {
		sqlSession.insert(NAMESPACE + ".createReReply", dto);
	}

	@Override
	public void updatePos(ComVideoReplyDTO dto) {
		sqlSession.update(NAMESPACE + ".replyUpdatePos", dto);
	}

	@Override
	public ComVideoReplyDTO ComVideoParentPos(Integer no) {
		return sqlSession.selectOne(NAMESPACE + ".parentInfo", no);
	}

	@Override
	public void updateReply(ComVideoReplyDTO dto) throws Exception {
		
	}

	@Override
	public void deleteReply(ComVideoReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".deleteReply", dto);
	}

	@Override
	public List<ComVideoReplyDTO> listAllReply(Integer bno) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listReply", bno);
	}

}
