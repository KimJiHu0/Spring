package com.mvc.file.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvc.file.dto.UploadFile;

// Validator을 implements를 해준다.

// 이따가 Controller에서 FileValidata 객체를 사용하려고 @Service를 걸어준다.
@Service
public class FileValidator implements Validator {

	// 객체의 타입을 검증하는데 사용하는 메소드
	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	// 자바빈의 속성값을 검증하는데 사용하는 메소드
	// target : 검증할 객체
	// errors : 검증 객체가 올바르지 않을 경우 에러정보 저장
	@Override
	public void validate(Object target, Errors errors) {
			
		// 검증할 객체인 target을 검사 전 타입을 변환
		UploadFile file = (UploadFile) target;
		
		// 만일 file을 아무것도 올리지 않아서, .getSize를 했을 때 0이 나온다면 이는 오류인 것이다.
		if(file.getMpfile().getSize() == 0){
			// 에러변수 : mpfile
			// 에러코드 : fileNPE
			// 출력 : Please Select a File
			errors.rejectValue("mpfile", "fileNPE", "Please Select a File");
			
			// rejectValue() : 필드에 대한 에러정보를 추가(에러코드, 에러메세지, 메세지인자전달)
			// rejectValue(String field, String erreoCode, String defaultMessage);
			// 필드에 대한 에러코드를 추가 에러코드에 대한 메세지가 존재하지 않을 경우 defaultMessage사용
			
		}
	}

}
