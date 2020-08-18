package com.spring.test04;

import org.springframework.stereotype.Component;

@Component
//@Component("")안에 이름을 지정해주면  기본으로 지정된 samSungTV 이름이 아닌 지정해준 이름으로 출력할 수 있다.
public class SamSungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("삼성티비 전원 켜짐");
	}

	@Override
	public void powertOff() {
		System.out.println("삼성티비 전원 꺼짐");
	}

	@Override
	public void volumeUp() {
		System.out.println("삼성티비 소리 키우기");
	}

	@Override
	public void volumeDown() {
		System.out.println("삼성티비 소리 줄이기");
	}

}
