package com.spring.test01;

public class MyNickNamePrn {
	
	//NickName class의 값을 전역변수로 선언
	private NickName nickname;
	
	//Setter & Getter
	public NickName getNickName() {
		return nickname;
	}
	public void setNickName(NickName nickname) {
		this.nickname = nickname;
	}
	
	public String toString() {
		return "내 별명은 " + nickname + "입니다.";
	}

}
