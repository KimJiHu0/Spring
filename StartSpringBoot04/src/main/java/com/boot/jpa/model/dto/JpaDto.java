package com.boot.jpa.model.dto;

import java.util.Date;

import javax.persistence.Column;
// 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Table(name="MYBOARD") // MYBOARD라는 테이블이다.
@Entity // table이 될 객체야 라는걸 알려준다. , myboard와 연결될 애?
// Entity : 아래 java class를 Talbe로 만들어 주겠다.
// Table : 만들어준 객체를 MYBOARD라는걸 알려준다.
public class JpaDto {
	
	@Id // primary key라는 걸 명시
	@Column // column이라는 것을 명시
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int myno;
	
	@Column
	private String myname;
	
	@Column
	private String mytitle;
	
	@Column
	private String mycontent;
	
	@Column(updatable = false)
	@Temporal(TemporalType.DATE)
	private Date mydate;

	
	public JpaDto() {
		
	}


	public JpaDto(int myno, String myname, String mytitle, String mycontent, Date mydate) {
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


	public Date getMydate() {
		return mydate;
	}


	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
	
	
}
