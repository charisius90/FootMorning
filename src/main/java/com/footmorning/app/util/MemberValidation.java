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
 * @author ��ҿ�
 *
 */
@Component
public class MemberValidation implements Validator {
	// commit �׽�Ʈ
	@Inject
	private MemberDAO memberDAO;
	
	// ��й�ȣ Ȯ�� - �ڼ���
	public static boolean isValidPw(String pw){
		Pattern p = Pattern.compile("([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])");
		Matcher m = p.matcher(pw);
		
		int length = pw.length();
		if(length >= 8 && length <= 16){
			return m.find();
		}
		
		return false;
	}
	
	// �̸��� Ȯ�� - �ڼ���
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
			// �α��� Validation
			
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
				// �Էµ� �̸��ϰ� ��й�ȣ�� ��ȸ�� ����� ������� ���ܹ߻�
				System.out.println("err : " + err);
				arg1.reject("login");
			}
		}
		else{
			// ȸ������ Validation
			
			// ��й�ȣ ����ǥ��+���� Ȯ��
			if(!isValidPw(dto.getMem_pw())){
				arg1.rejectValue("mem_pw", "invalid");
			}
			
			// �̸��� ����ǥ�� Ȯ��
			if(!isValidEmail(dto.getMem_email())){
				arg1.rejectValue("mem_email", "invalid");
			}
			
			try{
				System.out.println("MemValid : " + dto);
				memberDAO.getMemberInfo(dto.getMem_email());
				//���� �߻� ���� ��� ������ ȸ���� �����ϹǷ� reject
				arg1.reject("signup");
			}
			catch(Exception err){
				// ȸ������ ����
				System.out.println("err : " + err);
			}
		}
	}
	
}
