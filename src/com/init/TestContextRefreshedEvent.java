package com.init;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class TestContextRefreshedEvent 
	implements ApplicationListener<ContextRefreshedEvent>{

	public void onApplicationEvent(ContextRefreshedEvent event) {
		//if(event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")){
			System.out.println("���е�bean���������~~~~~~"+event.getApplicationContext().getDisplayName());
		//}
	}
}
