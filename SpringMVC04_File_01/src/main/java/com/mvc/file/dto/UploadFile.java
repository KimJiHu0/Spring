package com.mvc.file.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

	private String name;
	private String desc;
	// MultipartFile : 파일경로, 이름, 데이터, 길이, 타클래스, ... 등 여러가지 정보를 전송한다.
	private MultipartFile mpfile;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public MultipartFile getMpfile() {
		return mpfile;
	}
	public void setMpfile(MultipartFile mpfile) {
		this.mpfile = mpfile;
	}
	
	
	
}
