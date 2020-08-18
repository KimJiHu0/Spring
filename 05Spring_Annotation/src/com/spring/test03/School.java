package com.spring.test03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {
	
	@Autowired
	//해당이름을 가진애들을 특정해서 연결해주라는 의미이다.
	//한번밖에 쓸 수 없다.
	//Autowired : 값 하나만 가져와서 쓸 수 있다.
	@Qualifier("bae")
	//@Qualifier은 객체 하나만.
	private Student student;
	private int grade;
	
	public School() {
		
	}
	public School(Student student, int grade) {
		super();
		this.student = student;
		this.grade = grade;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "School [student=" + student + ", grade=" + grade + "]";
	}
}
