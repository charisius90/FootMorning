package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.MyclubCashBookDTO;

public interface MyclubCashBookDAO {
	public String getTime();
	public void insert(MyclubCashBookDTO dto);
	public void update(MyclubCashBookDTO dto);
	public void delete(Integer no);
	public MyclubCashBookDTO getWithNo(Integer no) throws Exception;
	public List<MyclubCashBookDTO> listAll() throws Exception;
//	public List<MyclubCashBookDTO>listSearchClubCriteria(SearchClubCriteria clubcri);
//	public int listSearchClubCount(SearchClubCriteria clubcri);
}
