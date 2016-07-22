package com.footmorning.app.util;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.persistence.MemberDAO;

/**
 * 
 * @author ±è¼Ò¿µ
 *
 */
@Component
public class MemberValidation implements Validator {
	@Inject
	private MemberDAO memberDAO;
	
	@Override
	public boolean supports(Class<?> arg0) {
		return MemberDTO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		MemberDTO dto = (MemberDTO)arg0;
		if(dto.getMem_email()==null || dto.getMem_email().trim().isEmpty()){
			arg1.rejectValue("userid", "required");
		}
		
		if(dto.getMem_pw()==null || dto.getMem_pw().trim().isEmpty()){
			arg1.rejectValue("userpw", "required");
		}
		
		try{
			System.out.println("MemValid : " + dto);
			System.out.println("dao : " + memberDAO);
			memberDAO.getWithPW(dto.getMem_email(), dto.getMem_pw());
		}
		catch(Exception err){
			arg1.reject("login");
		}
	}
}
