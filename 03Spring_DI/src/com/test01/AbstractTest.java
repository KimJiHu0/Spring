package com.test01;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractTest {
	
	public abstract String dayInfo();
	
	//getInstance : sington pattern
	//메모리에 단 하나의 객체만 존재하게 만드는 것.
	//객체를 만들고 객체를 또 만드려고 하면 이미 만들어져 있는 객체의 주소값을 리턴해주는 애
	//ex ) 달력
	//applicationcontext.xml을 통해서 객체를 만들었어
	//원래 싱글톤을 객체를 만들 수 없어.
	public static AbstractTest getInstance() {
		
		GregorianCalendar cal = new GregorianCalendar();
		
		//요일을 리턴해줄 애.
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(day) {
		case 1: return new Sunday();
		case 2 : return new Monday();
		case 3 : return new Tuesday();
		case 4 : return new Wednesday();
		case 5 : return new Thursday();
		case 6 : return new Friday();
		case 7 : return new Saturday();
		}
		
		return null;
	}
}
