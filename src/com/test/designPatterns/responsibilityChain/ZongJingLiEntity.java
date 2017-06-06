package com.test.designPatterns.responsibilityChain;

public class ZongJingLiEntity extends Employee{
	public ZongJingLiEntity(String name){
		super(name);
	}
	
	public void proccessNext(LeaveRequest request){
		int day=request.getLeaveDay();
		if(day>=10&&day<30){
			System.out.println("总经理审批："+request.getLeaveReason());
		}else{
			System.out.println("你辞职吧！！");
		}
	}
}
