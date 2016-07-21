package com.footmorning.app.service.myclub;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.footmorning.app.domain.MyclubNoticeDTO;
import com.footmorning.app.persistence.MyclubNoticeDAO;
import com.footmorning.app.service.MyclubNoticeService;

@Service
public class MyclubNoticeServiceImpl implements MyclubNoticeService{
	@Inject
	private MyclubNoticeDAO dao;
	   
	@Override
	public void register(MyclubNoticeDTO dto) throws Exception {
		dao.create(dto);
	}

	/**
	    * ���� read
	    */
	   @Override
	   public MyclubNoticeDTO read(Integer bno) throws Exception {
	      // TODO Auto-generated method stub
	      return dao.read(bno);
	   }

	   /**
	    * ���� update
	    */
	   @Override
	   public void modify(MyclubNoticeDTO dto) throws Exception {
	      dao.update(dto);
	   }
	   
	   /**
	    * ���� delete
	    */
	   @Override
	   public void remove(Integer bno) throws Exception {
	      dao.delete(bno);
	   }

	@Override
	public List<MyclubNoticeDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
