package com.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class TestInitializing implements InitializingBean{

	public void afterPropertiesSet() throws Exception {
		System.out.println("��ִ����~~~~~~~~~~~~");
	}
	
	public void test2222(){
		System.out.println("����test222222~~~~~~~~");
	}
}
