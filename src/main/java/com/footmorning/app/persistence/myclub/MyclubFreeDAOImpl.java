package com.footmorning.app.persistence.myclub;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.MyclubFreeDTO;
import com.footmorning.app.domain.MyclubFreeReplyDTO;
import com.footmorning.app.persistence.MyclubFreeDAO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

@Repository
public class MyclubFreeDAOImpl implements MyclubFreeDAO {
	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.footmorning.mappers.myclub.myclubFreeMapper";

	@Override
	public void create(MyclubFreeDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", dto);
	}

	@Override
	public MyclubFreeDTO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".read", bno);
	}
	
	@Override
	public void updateCount(Integer myclub_notice_no) throws Exception {
		sqlSession.selectOne(NAMESPACE + ".updateCount", myclub_notice_no);
	}

	@Override
	public void update(MyclubFreeDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", bno);
	}

	@Override
	public List<MyclubFreeDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countPaging", cri);
	}

	@Override
	public List<MyclubFreeDTO> listCriteria(Criteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listCriteria", cri);
	}

	@Override
	public List<MyclubFreeDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listSearchCount", cri);
	}

	@Override
	public void createReply(MyclubFreeReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".updatePos");
		sqlSession.insert(NAMESPACE + ".createReply", dto);

	}

	@Override
	public void createReReply(MyclubFreeReplyDTO dto) {
		sqlSession.insert(NAMESPACE + ".createReReply", dto);

	}

	@Override
	public void updatePos(MyclubFreeReplyDTO dto) {
		sqlSession.update(NAMESPACE + ".replyUpdatePos", dto);
	}

	@Override
	public MyclubFreeReplyDTO MyclubFreeParentPos(Integer no) {
		return sqlSession.selectOne(NAMESPACE + ".parentInfo", no);
	}

	@Override
	public void updateReply(MyclubFreeReplyDTO dto) throws Exception {

	}

	@Override
	public void deleteReply(MyclubFreeReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".deleteReply", dto);

	}

	@Override
	public List<MyclubFreeReplyDTO> listAllReply(Integer bno) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listReply", bno);
	}
}
