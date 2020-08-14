package com.test07;

public class SamSungTV implements TV {
	
	public SamSungTV() {
		System.out.println("SamSungTV 생성!");
	}

	@Override
	public void powerOn() {
		System.out.println("SamSung tv power on");
	}

	@Override
	public void powerOff() {
		System.out.println("SamSung tv power off");
	}

	@Override
	public void volumeUp() {
		System.out.println("SamSung tv volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("SamSung tv volume down");
	}

}
