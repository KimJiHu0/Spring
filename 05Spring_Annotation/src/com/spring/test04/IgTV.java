package com.spring.test04;

import org.springframework.stereotype.Component;

@Component
//IgTV라는 class를 bean객체로 만들어준다.
public class IgTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("아이쥐 전원 켜짐");
	}

	@Override
	public void powertOff() {
		System.out.println("아이쥐 전원 꺼짐");
	}

	@Override
	public void volumeUp() {
		System.out.println("아이쥐 소리 키우기");
	}

	@Override
	public void volumeDown() {
		System.out.println("아이쥐 소리 줄이기");
	}

}
