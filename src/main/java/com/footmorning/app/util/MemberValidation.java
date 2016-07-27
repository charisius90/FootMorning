package com.footmorning.app.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.persistence.MemberDAO;

/**
 * 
 * @author 김소영
 *
 */
@Component
public class MemberValidation implements Validator {
	// commit 테스트
	@Inject
	private MemberDAO memberDAO;
	
	// 비밀번호 확인 - 박수항
	public static boolean isValidPw(String pw){
		Pattern p = Pattern.compile("([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])");
		Matcher m = p.matcher(pw);
		
		int length = pw.length();
		if(length >= 8 && length <= 16){
			return m.find();
		}
		
		return false;
	}
	
	// 이메일 확인 - 박수항
	public static boolean isValidEmail(String email){
		Pattern p = Pattern.compile("(^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$)");	
		Matcher m = p.matcher(email);
		return m.find();
	}
	
	@Override
	public boolean supports(Class<?> arg0) {
		return MemberDTO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		MemberDTO dto = (MemberDTO)arg0;
		
		if(dto.getMem_name()==null || dto.getMem_name().trim().isEmpty()){
			// 로그인 Validation
			
			if(dto.getMem_email()==null || dto.getMem_email().trim().isEmpty()){
				arg1.rejectValue("mem_email", "required");
			}
			
			if(dto.getMem_pw()==null || dto.getMem_pw().trim().isEmpty()){
				arg1.rejectValue("mem_pw", "required");
			}
			
			try{
				System.out.println("MemValid : " + dto);
				memberDAO.getWithPW(dto.getMem_email(), dto.getMem_pw());
			}
			catch(Exception err){
				// 입력된 이메일과 비밀번호로 조회한 결과가 없을경우 예외발생
				System.out.println("err : " + err);
				arg1.reject("login");
			}
		}
		else{
			// 회원가입 Validation
			
			// 비밀번호 정규표현+길이 확인
			if(!isValidPw(dto.getMem_pw())){
				arg1.rejectValue("mem_pw", "invalid");
			}
			
			// 이메일 정규표현 확인
			if(!isValidEmail(dto.getMem_email())){
				arg1.rejectValue("mem_email", "invalid");
			}
			
			try{
				System.out.println("MemValid : " + dto);
				memberDAO.getMemberInfo(dto.getMem_email());
				//예외 발생 없는 경우 동일한 회원이 존재하므로 reject
				arg1.reject("signup");
			}
			catch(Exception err){
				// 회원가입 가능
				System.out.println("err : " + err);
			}
		}
	}
	
}
