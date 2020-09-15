package com.mvc.updown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.mvc.updown.dto.UploadFile;
import com.mvc.updown.validate.FileValidator;


@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;
	
	// form이라는 값이 요청되면 HandlerMapping을 통해서 현재 메소드와 연결해준 다음에 upload라는 jsp를 return해준다.
	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}
	
	
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
		
		// .validate 매소드의 수행이 끝난 후 돌아와서 Errors.hasErrors()를 이용해서
		// 에러가 존재하는지 확인하고 에러가 존재할 경우 알맞은 처리하기.
		
		// uploadFile : jsp에 전달해준 객체
		// result : validator에서 만들어준 validate에서의 에러를 의미한다.
		fileValidator.validate(uploadFile, result);
		
		// 에러가 존재하면 upload를 다시 보내준다.
		if(result.hasErrors()) {
			return "upload";
		}
		
		// file이라는 이름의 값에 uploadFile이라는 command객체의  MpFile을 담아주고
		MultipartFile file = uploadFile.getMpfile();
		// 이름에 MpFile의 이름을 가져와서 담아준다.(원본 진짜 이름)
		String name = file.getOriginalFilename();
		
		// UploadFile Dto 생성
		UploadFile fileObj = new UploadFile();
		// 넘어온 name과 / uploadFile의 desc이름을 담아준다.
		fileObj.setName(name);
		fileObj.setDesc(uploadFile.getDesc());
		
		// inputStream과 OutputStream을 null로 선언.
		InputStream inputStream = null; // upload
		OutputStream outputStream = null; // download
		
		
		try {
			// file에 담긴 것을 읽어서 담아주는 것
			inputStream = file.getInputStream();
			// request.getSession().getServletContext() : 
			// 우리가 만든 해당 프로젝트가 어디있냐??????? 물어봄.
			// 우리 프로젝트 경로로 잡아줬음.
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			
			System.out.println("업로드 될 실제 경로 : " + path);
			
			// 폴더 생성
			File storage = new File(path);
			if(!storage.exists()) {
				storage.mkdir();
			}
			
			// 폴더 안에 생성
			File newFile = new File(path + "/" + name);
			if(!newFile.exists()) {
				// 주어진 이름의 파일이 없으면 새로 생성한다.
				newFile.createNewFile();
			}
			// --------여기까지하면 해당 파일은 0바이트 아무것도 없음 ---------
			
			outputStream = new FileOutputStream(newFile);
			
			int read = 0;
			// 데이터가 들어갈 수 있도록 자리만 만들어준다.
			byte[] b = new byte[(int)file.getSize()];
			
			// 클라이언트에서 서버로 전달한 파일이 바이트배열로 되어있음
			// 이걸 가지고 하나씩 가지고와서 read에 하나씩 대입할건데 파일이 끝나지 않을때까지 반복
			// 파일이 끝나면 -1를 return
			// 위에서 받아온 파일이 inputStream에 있는데
			while((read=inputStream.read(b)) != -1) {
				// 0번지부터 끝까지 읽어서 만들어주는것?
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
		
		model.addAttribute("fileObj", fileObj);
		
		return "download";
	}
	
	@RequestMapping("/download")
	@ResponseBody
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
		
		byte[] down = null;
		
		try {
			// 프로젝트의 경로를 잡아준다.storage라는 폴더를 잡아줬다.
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			// file의 경로 + name을 섞어서 폴더 안에 있는 파일을 file이라는 변수에 담아줬다.
			File file = new File(path + "/" + name);
			
			// file의 내용을 새로운 byte[]로 복사한다.
			// 그걸 down이라는 이름에 담았음.
			down = FileCopyUtils.copyToByteArray(file);
			// 파일명을 인코딩해준다.
			String filename = new String(file.getName().getBytes(), "8859_1");
			
			// 몰라모른다고모르겠따고ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			// attachment : 실제로 브라우저가 받을 수 있게? 첨부파일?
			// 해당 브라우저가 파일 다운로드하는애구나 인걸 자동으로 알아들음 : attachment
			// "Content-Disposition", "attachment;" : 파일 다운로드할 수 있다 라고 알려준다.
			response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\""); 
			response.setContentLength(down.length);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 이건 사실 의미가 없습니다 허허.
		return down;
	}
	
}
