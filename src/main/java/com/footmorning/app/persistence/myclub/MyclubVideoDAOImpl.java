package com.footmorning.app.persistence.myclub;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.MyclubVideoDTO;
import com.footmorning.app.domain.MyclubVideoReplyDTO;
import com.footmorning.app.persistence.MyclubVideoDAO;
import com.footmorning.app.util.AlbumCriteria;
import com.footmorning.app.util.AlbumSearchCriteria;

@Repository
public class MyclubVideoDAOImpl implements MyclubVideoDAO {
	
	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.footmorning.mappers.myclub.myclubVideoMapper";

	
	@Override
	public void create(MyclubVideoDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", dto);
	}

	@Override
	public MyclubVideoDTO read(Integer bno) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", bno);
	}

	@Override
	public void updateCount(Integer myclub_video_no) throws Exception {
		sqlSession.selectOne(NAMESPACE + ".updateCount", myclub_video_no);
	}

	@Override
	public void update(MyclubVideoDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", bno);
	}

	@Override
	public List<MyclubVideoDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public List<MyclubVideoDTO> listCriteria(AlbumCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listCriteria", cri);
	}

	@Override
	public int countPaging(AlbumCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countPaging", cri);
	}

	@Override
	public List<MyclubVideoDTO> listSearchCriteria(AlbumSearchCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(AlbumSearchCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listSearchCount", cri);
	}

	@Override
	public void createReply(MyclubVideoReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".updatePos");
		sqlSession.insert(NAMESPACE + ".createReply", dto);
	}

	@Override
	public void createReReply(MyclubVideoReplyDTO dto) {
		sqlSession.insert(NAMESPACE + ".createReReply", dto);
	}

	@Override
	public void updatePos(MyclubVideoReplyDTO dto) {
		sqlSession.update(NAMESPACE + ".replyUpdatePos", dto);
	}

	@Override
	public MyclubVideoReplyDTO MyclubVideoParentPos(Integer no) {
		return sqlSession.selectOne(NAMESPACE + ".parentInfo", no);
	}

	@Override
	public void updateReply(MyclubVideoReplyDTO dto) throws Exception {
		
	}

	@Override
	public void deleteReply(MyclubVideoReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".deleteReply", dto);
	}

	@Override
	public List<MyclubVideoReplyDTO> listAllReply(Integer bno) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listReply", bno);
	}

	@Override
	public List<MyclubVideoDTO> listMypostAll(int mem_no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listMypostAll", mem_no);
	}

}
