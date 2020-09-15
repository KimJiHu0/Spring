package com.mvc.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mvc.file.dto.UploadFile;
import com.mvc.file.validate.FileValidator;


@Controller
public class HomeController {
	
	@Autowired
	private FileValidator filevalidator;
	
	@RequestMapping("/form")
	public String file() {
		return "upload";
	}
	
	// HttpServletRequest request : request객체 받은 것
	// Model model : 전달해줄 객체
	// UploadFile uploadFile : upload.jsp에서 submit버튼을 클릭했을 때 넘어오는 값들을 의미
	// dto에서 name,desc,mpfile을 하나하나 받아줄 필요 없이 한꺼번에 받을 수 있음.
	// BindingResult : FileValidator Class의 Errors를 상속받은 애로
	// 오류 정보를 받아오기 위해서
	@RequestMapping("upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
		
		// upload.jsp에서 form:form에 modelAttribute="uploadFile" 보낸 것을 받아온
		// uploadFile과 result를 파라미터로 넣어줌으로써
		// FileValidator Class에 validate메소드를 실행.
		// uploadFile을 검증할건데, 만일 검증에 에러가 발생하면 나오는 오류를
		// result변수에 담아서 받아온다.
		filevalidator.validate(uploadFile, result);
		
		// 만일 validate()에서 uploadFile의 검증하는 도중
		// 에러가 발생했다면. 즉, 에러가 존재한다면
		// [에러가 나지 않는다면 건너뜀]
		if(result.hasErrors()){
			// upload로 다시 보내준다.
			return "upload";
		}
		
		
		// 만일 검증이 에러없이 성공했다면 차근차근 실행해 나간다.
		
		// upload.jsp에서 넘어온 uploadFile에서 mpfile이라는 name을 가진
		// 즉, file을 MultipartFile 타입의 file이라는 변수에 담아준다.
		// MultipartFile : 
		// 파일경로, 이름, 데이터, 길이, 타클래스 .. 등등 여러가지
		// 정보를 전송하는..
		MultipartFile file = uploadFile.getMpfile();
		// 그 후에 담아진 file의 OriginalFileName을 String변수인 name에 담는다.
		String name = file.getOriginalFilename();
		
		// UploadFile Type의 fileObj를 생성 / dto객체
		UploadFile fileObj = new UploadFile();
		// 위에서 지정해준 String name에 담은 파일의 OriginalName을 setter
		// 파라미터에 넣어줘서 지정,
		fileObj.setName(name);
		// 넘어온 uploadFile의 Desc를 가져와서 setter 파라미터에 넣고 지정
		fileObj.setDesc(uploadFile.getDesc());
		
		// upload와 download를 해주기 위해 선언
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		
		
		try {
			// file에 담긴 것을 getInputStream으로 읽어서
			// inputStream에 담아준다.
			inputStream = file.getInputStream();
			// request.getSession().getServletContext() : 
			// 우리가 만든 해당 프로젝트의 경로를 잡아준다.
			// getRealPath : 프로젝트의 metadata. 즉, 진짜 저장되는 경로,
			// 안에 resources에 storage라고 상세하게 지정
			// 즉 path라는 변수의 경로는 metadata/.../... (저장되는 진짜경로) + /resources/storage 를 의미.
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			
			System.out.println(" 실제 저장될 경로 : " + path);
			
			
			// 폴더를 생성해주자.
			File storage = new File(path);
			// 만일 storage라는 파일이 경로안에 존재하지 않는다면
			if(!storage.exists()) {
				// 그 파일 만들준다.
				storage.mkdir();
			}
			
			// 위에서 만든 폴더/ 안에 파일을 생성
			// 파일을 생성할건데 위에서 지정해준 path에 upload할 file의 name을
			// 더해줘서 그 경로에 파일을 지정해줌.
			File newFile = new File(path + "/" + name);
			// 만일 위에서 준 newFile이 존재하지 않는다면
			if(!newFile.exists()) {
				// 파일을 생성해준다.
				newFile.createNewFile();
			}
			
			//-------------여기까지하면 해당파일은 0byte로 아무것도 존재하지 않는 파일이다---------------
			
			
			// upload를 위해 outputStream을 사용
			// 위에서 지정한 newFile을 출력해줄거다.
			outputStream = new FileOutputStream(newFile);
			
			int read = 0;
			
			// 데이터가 들어갈 수 있도록 file의 자리를 만들어준다.
			byte[] b = new byte[(int)file.getSize()];
			
			// Client에서 Server로 전달한 File이 byte[]로 되어있다.
			// 이걸 가지고 하나씩 가지고 와서 read에 하나씩 대입할건데
			// != -1이란 것은 파일이 끝나면 -1을 return하기 때문에 끝날때까지
			// while문을 돌려서 
			while((read=inputStream.read(b)) != -1) {
				// 0번지부터 끝까지 읽어서 만들어준다?
				outputStream.write(b, 0, read);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// fileObj라는 이름으로 fileObj를 담아서 전달
		model.addAttribute("fileObj", fileObj);
		
		// download.jsp로 이동
		return "download";
	}
	
	
	// download
	// request와 response를 파라미터로 받고
	// hidden값으로 넘어온 String name을 받아준다.
	@RequestMapping("/download")
	@ResponseBody
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
		
		// down이라는 byte배열 선언
		byte[] down = null;
		
		try {
			// 저장될 RealPath 경로에 + resources/storage를 합쳐서 path변수에 담아준다.
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			
			// File타입의 file이라는 변수에 위에서 지정한 path + file의 이름을 정해서 선언해준다.
			File file = new File(path + "/" + name);
			
			// 위에서 선언한 down이라는 byte[]에 file의 내용을
			// 그대로 복사해서 담아준다.
			down = FileCopyUtils.copyToByteArray(file);
			
			// 파일 이름을 encoding
			String filename = new String(file.getName().getBytes(), "8859_1");
			
			// "Content-Disposition", "attacthment; : 파일을 다운로드 할 수 있다. 라고 알려준다.
			response.setHeader("Content-Disposition", "attacthment; filename=\"" + filename + "\"");
			response.setContentLength(down.length);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return down;
	}
} 
