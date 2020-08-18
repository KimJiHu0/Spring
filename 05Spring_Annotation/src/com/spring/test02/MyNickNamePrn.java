package com.spring.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyNickNamePrn {

	@Autowired
	//nicknname 타입의 객체를 땡겨와서 변수에 넣어줄거라는 뜻 annotation
	//만들어진 Nickname 객체를 가져와서 nickName이라는 변수에 담아줘
	//ㅌ태그 안에 Autowire="default"라고 마늗ㄹ어진거.
	private NickName nickname;
	
	//getter / setter
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
