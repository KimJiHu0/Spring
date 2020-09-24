package com.mvc.mongo.dto;

import org.springframework.data.annotation.Id;

public class ScoreMongoDto {
	
	@Id // primary key로 지정해주는 Annotation
	private String id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	public ScoreMongoDto() {
		super();
	}
	public ScoreMongoDto(String id, String name, int kor, int eng, int math) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	@Override
	public String toString() {
		return "{'_id':'" + id + "', 'name':'" + name + "', 'kor':'" + kor + "', 'eng':'" + eng + "', 'math':'" + math + "'}";
	}
	
	
	

}
