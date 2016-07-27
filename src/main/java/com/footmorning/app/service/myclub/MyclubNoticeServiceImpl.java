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
		return getMyClubNotices(dao.listAll());
	}
	
//	�����
	private List<MyclubNoticeDTO> getMyClubNotices(List<MyclubNoticeDTO> list) {
		for(MyclubNoticeDTO dto : list) {
			dto.setMyclub_notice_main_thumnail(getMainThumnail(dto.getMyclub_notice_content()));
		}
		return list;
	}
	
//	�����
	private String getMainThumnail(String content) {
		String mainThumnail = "";
		
		if(content.contains("img src=")) {
			int startIndex = content.indexOf("img src=") + 9;
//			System.out.println(content.charAt(startIndex));
			int endIndex = content.indexOf("\"", startIndex) - 1;
			if(startIndex < endIndex) {
				mainThumnail = content.substring(startIndex, endIndex);
			}
//			System.out.println(mainThumnail);
		}
		return mainThumnail;
	}
}
