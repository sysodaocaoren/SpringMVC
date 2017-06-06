package com.test.designPatterns.responsibilityChain;

public class JingLiEntity extends Employee{
	public JingLiEntity(String name){
		super(name);
	}
	
	public void proccessNext(LeaveRequest request){
		int days=request.getLeaveDay();
		if(3<=days&&days<10){
			System.out.println("经理允许了"+request.getLeaveReason());
		}else{
			this.successor.proccessNext(request);
		}
	}
}
