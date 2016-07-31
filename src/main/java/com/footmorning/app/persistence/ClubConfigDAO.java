package com.footmorning.app.persistence;

import java.util.List;

import com.footmorning.app.domain.ClubConfigDTO;

/**
 * 
 * @author 박수항
 *
 */
public interface ClubConfigDAO {
	public String getTime();
	public void insert(ClubConfigDTO dto);
	public void update(ClubConfigDTO dto);
	public void delete(Integer no);
	public ClubConfigDTO getWithClubNo(Integer no) throws Exception;
	public List<ClubConfigDTO> listAll() throws Exception;
}
