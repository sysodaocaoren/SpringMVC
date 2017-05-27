package com.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class TestInitializing implements InitializingBean{

	public void afterPropertiesSet() throws Exception {
		System.out.println("我执行了~~~~~~~~~~~~");
	}
	
	public void test2222(){
		System.out.println("我是test222222~~~~~~~~");
	}
}
