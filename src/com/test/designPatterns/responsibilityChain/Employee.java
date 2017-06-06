package com.test.designPatterns.responsibilityChain;

public abstract class Employee {
	protected Employee successor;
	protected String name;
	
	public Employee(String name){
		this.name=name;
	}
	
	public void setSuccessor(Employee successor1){
		this.successor=successor1;
	}
	
	public void proccessNext(LeaveRequest request){};
}
