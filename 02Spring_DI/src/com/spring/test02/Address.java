package com.spring.test02;

public class Address {
	
	//name, addr, phone를 전역변수로 선언해준다.
	private String name;
	private String addr;
	private String phone;
	
	
	//기본생성자를 생성해주고,
	public Address() {
		
	}
	
	//Parameter 3개 받는 생성자를 생성
	public Address(String name, String addr, String phone) {
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	
	public String toString() {
		return "이름 : " + name + "\t 주소 : " + addr + "\t 전화번호 : " + phone;
	}
}
