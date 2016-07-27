package com.footmorning.app.persistence.myclub;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.footmorning.app.domain.MyclubNoticeDTO;
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
	 * ½ÂÇÑ read
	 */
	@Override
	public MyclubNoticeDTO read(Integer myclub_notice_no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".read", myclub_notice_no);
	}
	
	@Override
	public void updateCount(Integer myclub_notice_no) throws Exception {
		sqlSession.selectOne(NAMESPACE + ".updateCount", myclub_notice_no);
	}
	
	/**
	 * ½ÂÇÑ update
	 */
	@Override
	public void update(MyclubNoticeDTO dto) throws Exception {
		sqlSession.update(NAMESPACE + ".update", dto);
	}

	/**
	 * ½ÂÇÑ delete
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
	 *  ±ÔÃ¤ countPaging
	 */
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countPaging", cri);
	}
	
	/**
	 * 	±ÔÃ¤ listCriteria
	 */
	@Override
	public List<MyclubNoticeDTO> listCriteria(Criteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listCriteria", cri);
	}
	
	/**
	 *  ±ÔÃ¤ listSearchCriteria
	 */
	@Override
	public List<MyclubNoticeDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSearch" , cri);
	}
	
	/**
	 *  ±ÔÃ¤ listSearchCount
	 */
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listSearchCount", cri);
	}

}
