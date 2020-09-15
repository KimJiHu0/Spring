package com.mvc.updown.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvc.updown.dto.UploadFile;


	// org.springframework.validation을 상속받고 class를 만들어야한다.


// 이따가 컨트롤러에서 파일밸리데이터 객체를 사용하려고 그냥 @Service 걸어줌
@Service
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		UploadFile file = (UploadFile) target;
		
		// 아무것도 존재하지 않는다면. 즉, file이 아무것도 없다면
		// upload한 file의 Mpfile의 사이즈가 0일 때
		// 오류를 출력해주기 위한 설정.
		// 필드에 대한 에러코드를 추가 에러코드에 대한 메세지가 존재하지 않을 경우 defaultMessage를 사용
		if(file.getMpfile().getSize() == 0) {
			// fileNPE라는 메세지가 없어서 default값인 Please select a file이 출력.
			errors.rejectValue("mpfile", "fileNPE", "Please select a file");
		}
		
	}

}
