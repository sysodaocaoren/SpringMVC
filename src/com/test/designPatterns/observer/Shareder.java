package com.test.designPatterns.observer;

public class Shareder implements Observer{
	
	private String name;
	
	public Shareder(String name){
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public void notices() {
		System.out.println(name+",股票上涨啦！！！！");
	}

	public void shareChange(ShareControllerCenter sc) {
		System.out.println(name+",你的股票上涨了！");
		sc.notifyAll(this.name);
	}

}
