package com.footmorning.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.persistence.MemberDAO;
import com.footmorning.app.util.RoleFeeder;
import com.footmorning.app.util.SearchCriteria;

/**
 * 
 * @author박수항
 *
 */

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO memberDAO;
	
//	@Autowired
//	private BCryptPasswordEncoder bCrypt;
	
	@Override
	public void updateAuth(Map map) {
		memberDAO.updateAuth(map);
	}
	

	@Override
	public void updateLogdate(MemberDTO dto) {
		memberDAO.updateLogdate(dto);
	}

	@Override
	public void insertMember(MemberDTO dto) {
		// bCrypt로 비밀번호 암호화
//		dto.setMem_pw(this.bCrypt.encode(dto.getMem_pw()));
		
		memberDAO.insertMember(dto);
		
		Object[] objs = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray();
		Map map = new HashMap();
		map.put("mem_email", dto.getMem_email());
		map.put("role", objs[0].toString());
		
		memberDAO.insertAuth(map);
	}

	@Override
	public void updateMember(MemberDTO dto) {
//		dto.setMem_pw(this.bCrypt.encode(dto.getMem_pw()));
		memberDAO.updateMember(dto);
	}

	@Override
	public void deleteMember(Integer mem_no) {
		try {
			memberDAO.deleteMember(mem_no);
			
			String mem_email = memberDAO.getWithNo(mem_no).getMem_email();
			memberDAO.deleteAuth(mem_email);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberDTO getMemberInfo(String mem_email) throws Exception{
		return memberDAO.getMemberInfo(mem_email);
	}
	
	@Override
	public MemberDTO getWithPW(String mem_email, String mem_pw) throws Exception{
		return memberDAO.getWithPW(mem_email, mem_pw);
	}

	@Override
	public String getTime() {
		return memberDAO.getTime();
	}

	@Override
	public String getPW(String mem_email, String mem_phone) {
		return memberDAO.getPW(mem_email, mem_phone);
	}

	@Override
	public int getWithClubno(Integer club_no) {
		return memberDAO.getWithClubno(club_no);
	}

	@Override
	public MemberDTO getWithNo(Integer mem_no) throws Exception {
		return memberDAO.getWithNo(mem_no);
	}

	@Override
	public List<MemberDTO> listAll() throws Exception {
		return memberDAO.listAll();
	}

	@Override
	public List<MemberDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return memberDAO.listSearchCriteria(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return memberDAO.listSearchCount(cri);
	}

}
