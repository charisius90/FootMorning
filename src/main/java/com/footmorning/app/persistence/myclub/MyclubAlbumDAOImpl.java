package com.footmorning.app.persistence.myclub;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.MyclubAlbumDTO;
import com.footmorning.app.domain.MyclubAlbumReplyDTO;
import com.footmorning.app.persistence.MyclubAlbumDAO;
import com.footmorning.app.util.AlbumCriteria;
import com.footmorning.app.util.AlbumSearchCriteria;

@Repository
public class MyclubAlbumDAOImpl implements MyclubAlbumDAO {
	
	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.footmorning.mappers.myclub.myclubAlbumMapper";
	
	@Override
	public void create(MyclubAlbumDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", dto);
	}

	@Override
	public MyclubAlbumDTO read(Integer bno) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", bno);
	}

	@Override
	public void updateCount(Integer myclub_album_no) throws Exception {
		sqlSession.selectOne(NAMESPACE + ".updateCount", myclub_album_no);
	}

	@Override
	public void update(MyclubAlbumDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", bno);
	}

	@Override
	public List<MyclubAlbumDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public List<MyclubAlbumDTO> listCriteria(AlbumCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listCriteria", cri);
	}

	@Override
	public int countPaging(AlbumCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countPaging", cri);
	}

	@Override
	public List<MyclubAlbumDTO> listSearchCriteria(AlbumSearchCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(AlbumSearchCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listSearchCount", cri);
	}

	@Override
	public void createReply(MyclubAlbumReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".updatePos");
		sqlSession.insert(NAMESPACE + ".createReply", dto);
	}

	@Override
	public void createReReply(MyclubAlbumReplyDTO dto) {
		sqlSession.insert(NAMESPACE + ".createReReply", dto);
	}

	@Override
	public void updatePos(MyclubAlbumReplyDTO dto) {
		sqlSession.update(NAMESPACE + ".replyUpdatePos", dto);
	}

	@Override
	public MyclubAlbumReplyDTO MyclubAlbumParentPos(Integer no) {
		return sqlSession.selectOne(NAMESPACE + ".parentInfo", no);
	}

	@Override
	public void updateReply(MyclubAlbumReplyDTO dto) throws Exception {
		
	}

	@Override
	public void deleteReply(MyclubAlbumReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".deleteReply", dto);
	}

	@Override
	public List<MyclubAlbumReplyDTO> listAllReply(Integer bno) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listReply", bno);
	}

}
