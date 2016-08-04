package com.footmorning.app.persistence.com;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.ComFreeDTO;
import com.footmorning.app.domain.ComFreeReplyDTO;
import com.footmorning.app.domain.ComQnADTO;
import com.footmorning.app.domain.ComQnAReplyDTO;
import com.footmorning.app.persistence.ComQnADAO;
import com.footmorning.app.util.Criteria;
import com.footmorning.app.util.SearchCriteria;

@Repository
public class ComQnADAOImpl implements ComQnADAO {
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.footmorning.mappers.comQnAMapper";

	@Override
	public void create(ComQnADTO dto) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", dto);
	}

	/**
	 * ���� read
	 */
	@Override
	public ComQnADTO read(Integer bno) throws Exception {
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
	public void update(ComQnADTO dto) throws Exception {
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
	public List<ComQnADTO> listAll() throws Exception {
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
	public List<ComQnADTO> listCriteria(Criteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listCriteria", cri);
	}

	/**
	 * ��ä listSearchCriteria
	 */
	@Override
	public List<ComQnADTO> listSearchCriteria(SearchCriteria cri) throws Exception {
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
	public void createReply(ComQnAReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".updatePos");
		sqlSession.insert(NAMESPACE + ".createReply", dto);

	}

	/**
	 * ���� insert
	 */
	@Override
	public void createReReply(ComQnAReplyDTO dto) {
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
	public void updatePos(ComQnAReplyDTO dto) {
		sqlSession.update(NAMESPACE + ".replyUpdatePos", dto);
	}

	/**
	 * parentInfo
	 */
	@Override
	public ComQnAReplyDTO MyclubNoticeParentPos(Integer no) {
		return sqlSession.selectOne(NAMESPACE + ".parentInfo", no);
	}

	// ������;
	@Override
	public void updateReply(ComQnAReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * ���� ����
	 */
	@Override
	public void deleteReply(ComQnAReplyDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".deleteReply", dto);

	}

	/**
	 * �Խñۿ� ���� ��ü ���� ����Ʈ
	 */
	@Override
	public List<ComQnAReplyDTO> listAllReply(Integer bno) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listReply", bno);
	}

	@Override
	public List<ComQnADTO> listMypostAll(int mem_no) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listMypostAll", mem_no);
	}

}
