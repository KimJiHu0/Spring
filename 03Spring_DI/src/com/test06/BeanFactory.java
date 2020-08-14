package com.test06;

public class BeanFactory {
	
	Object getBean(String beanName) {
		//bean이름을 받아서 해당 객체를 만들어서 return
		
		if(beanName.equals("samsung")) {
			return new SamSungTV();
		} else if(beanName.equals("ig")) {
			return new IgTV();
		}
		
		return null;
	}

}
