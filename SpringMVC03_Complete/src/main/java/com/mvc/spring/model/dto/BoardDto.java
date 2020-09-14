package com.mvc.spring.model.dto;

import javax.xml.crypto.Data;

public class BoardDto {
	
	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	private Data mydate;
	
	public BoardDto() {
		super();
	}
	
	public BoardDto(int myno, String myname, String mytitle, String mycontent, Data mydate) {
		super();
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
	}
	public int getMyno() {
		return myno;
	}
	public void setMyno(int myno) {
		this.myno = myno;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public String getMytitle() {
		return mytitle;
	}
	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}
	public String getMycontent() {
		return mycontent;
	}
	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}
	public Data getMydate() {
		return mydate;
	}
	public void setMydate(Data mydate) {
		this.mydate = mydate;
	}
	
	

}
