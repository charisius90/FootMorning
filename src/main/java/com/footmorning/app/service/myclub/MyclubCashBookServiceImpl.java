package com.footmorning.app.service.myclub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.MyclubCashBookDTO;
import com.footmorning.app.persistence.MyclubCashBookDAO;
import com.footmorning.app.service.MyclubCashBookService;

@Service
public class MyclubCashBookServiceImpl implements MyclubCashBookService {
	@Autowired
	private MyclubCashBookDAO dao;

	@Override
	public String getTime() {
		return dao.getTime();
	}

	@Override
	public void insert(MyclubCashBookDTO dto) {
		dao.insert(dto);
	}

	@Override
	public void update(MyclubCashBookDTO dto) {
		dao.update(dto);
	}

	@Override
	public void delete(Integer no) {
		dao.delete(no);
	}

	@Override
	public MyclubCashBookDTO getWithNo(Integer no) throws Exception {
		return dao.getWithNo(no);
	}

	@Override
	public List<MyclubCashBookDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
