package com.footmorning.app.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.MainNoticeDTO;
import com.footmorning.app.domain.MainNoticeReplyDTO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

/**
 * Ŀ�´�Ƽ �ڶ��Խ��� DAO
 * @author �ڼ���
 */
@Repository
public class MainNoticeDAOImpl implements MainNoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	private static final String NAMESPACE = "com.footmorning.mappers.mainNoticeMapper";

	@Override
	public void create(MainNoticeDTO dto) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", dto);
	}

	/**
	 * ���� read
	 */
	@Override
	public MainNoticeDTO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".read", bno);
	}
	
	@Override
	public void updateCount(Integer no) throws Exception {
		sqlSession.selectOne(NAMESPACE + ".updateCount", no);
	}

	/**
	 * ���� update
	 */
	@Override
	public void update(MainNoticeDTO dto) throws Exception {
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
	public List<MainNoticeDTO> listAll() throws Exception {
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
	public List<MainNoticeDTO> listCriteria(Criteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listCriteria", cri);
	}

	/**
	 * ��ä listSearchCriteria
	 */
	@Override
	public List<MainNoticeDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
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
	public void createReply(MainNoticeReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".updatePos");
		sqlSession.insert(NAMESPACE + ".createReply", dto);

	}

	/**
	 * ���� insert
	 */
	@Override
	public void createReReply(MainNoticeReplyDTO dto) {
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
	public void updatePos(MainNoticeReplyDTO dto) {
		sqlSession.update(NAMESPACE + ".replyUpdatePos", dto);
	}

	/**
	 * parentInfo
	 */
	@Override
	public MainNoticeReplyDTO MyclubNoticeParentPos(Integer no) {
		return sqlSession.selectOne(NAMESPACE + ".parentInfo", no);
	}

	// ������;
	@Override
	public void updateReply(MainNoticeReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * ���� ����
	 */
	@Override
	public void deleteReply(MainNoticeReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".deleteReply", dto);

	}

	/**
	 * �Խñۿ� ���� ��ü ���� ����Ʈ
	 */
	@Override
	public List<MainNoticeReplyDTO> listAllReply(Integer bno) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listReply", bno);
	}

}
