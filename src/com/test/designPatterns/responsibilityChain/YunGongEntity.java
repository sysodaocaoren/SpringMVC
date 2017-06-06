package com.test.designPatterns.responsibilityChain;

public class YunGongEntity extends Employee{
	public YunGongEntity(String name){
		super(name);
	}
	
	public void proccessNext(LeaveRequest request){
		this.successor.proccessNext(request);
	}
}
