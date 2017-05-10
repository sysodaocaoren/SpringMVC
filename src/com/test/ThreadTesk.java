package com.test;

import java.util.concurrent.Callable;

public class ThreadTesk implements Callable<String>{
	private String index;
	
	public ThreadTesk(String index){
		super();
		this.index=index;
	}
	public String call() throws Exception {
		for(int i=0;i<1000;i++){
			System.out.println(index+"------------------------------"+index);
		}
		return "ok";
	}
	
}
