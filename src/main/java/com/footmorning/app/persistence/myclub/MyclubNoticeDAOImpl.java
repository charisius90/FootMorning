package com.footmorning.app.persistence.myclub;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.MyclubNoticeDTO;
import com.footmorning.app.domain.MyclubNoticeReplyDTO;
import com.footmorning.app.persistence.MyclubNoticeDAO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

@Repository
public class MyclubNoticeDAOImpl implements MyclubNoticeDAO {
	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.footmorning.mappers.myclub.myclubNoticeMapper";

	@Override
	public void create(MyclubNoticeDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", dto);
	}

	/**
	 * ���� read
	 */
	@Override
	public MyclubNoticeDTO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".read", bno);
	}

	/**
	 * ���� update
	 */
	@Override
	public void update(MyclubNoticeDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	/**
	 * ���� delete
	 */
	@Override
	public void delete(Integer bno) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", bno);
	}

	@Override
	public List<MyclubNoticeDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

	/**
	 * ��ä countPaging
	 */
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countPaging", cri);
	}

	/**
	 * ��ä listCriteria
	 */
	@Override
	public List<MyclubNoticeDTO> listCriteria(Criteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listCriteria", cri);
	}

	/**
	 * ��ä listSearchCriteria
	 */
	@Override
	public List<MyclubNoticeDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSearch", cri);
	}

	/**
	 * ��ä listSearchCount
	 */
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listSearchCount", cri);
	}

	/**
	 * ����,���� reply start
	 */
	/**
	 * pos +1 , parent_reply insert
	 */
	@Override
	public void createReply(MyclubNoticeReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".updatePos");
		sqlSession.insert(NAMESPACE + ".createReply", dto);

	}

	/**
	 * ���� insert
	 */
	@Override
	public void createReReply(MyclubNoticeReplyDTO dto) {
		sqlSession.insert(NAMESPACE + ".createReReply", dto);

	}

	// @Override
	// public void updatePos(Integer pos) {
	// sqlSession.update(NAMESPACE+".replyUpdatePos", pos);
	// }
	/**
	 * rereply pos update
	 */
	@Override
	public void updatePos(MyclubNoticeReplyDTO dto) {
		sqlSession.update(NAMESPACE + ".replyUpdatePos", dto);
	}

	/**
	 * parentInfo
	 */
	@Override
	public MyclubNoticeReplyDTO MyclubNoticeParentPos(Integer no) {
		return sqlSession.selectOne(NAMESPACE + ".parentInfo", no);
	}

	// ������;
	@Override
	public void updateReply(MyclubNoticeReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * ���� ����
	 */
	@Override
	public void deleteReply(MyclubNoticeReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".deleteReply", dto);

	}

	/**
	 * �Խñۿ� ���� ��ü ���� ����Ʈ
	 */
	@Override
	public List<MyclubNoticeReplyDTO> listAllReply(Integer bno) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listReply", bno);
	}
}
