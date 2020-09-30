package com.mvc.spring.model.dto;

public class BoardDto {
	
	private int boardno;
	private String boardtitle;
	private String boardname;
	private String boardcontent;
	private String boarddate;
	
	
	public BoardDto() {
		super();
	}
	
	public BoardDto(int boardno, String boardtitle, String boardname, String boardcontent, String boarddate) {
		super();
		this.boardno = boardno;
		this.boardtitle = boardtitle;
		this.boardname = boardname;
		this.boardcontent = boardcontent;
		this.boarddate = boarddate;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getBoardtitle() {
		return boardtitle;
	}
	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	public String getBoardcontent() {
		return boardcontent;
	}
	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}
	public String getBoarddate() {
		return boarddate;
	}
	public void setBoarddate(String boarddate) {
		this.boarddate = boarddate;
	}
	
	

}
