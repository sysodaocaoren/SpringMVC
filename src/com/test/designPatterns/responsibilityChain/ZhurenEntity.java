package com.test.designPatterns.responsibilityChain;

public class ZhurenEntity extends Employee{
	public ZhurenEntity(String name){
		super(name);
	}
	
	public void proccessNext(LeaveRequest request){
		if(request.getLeaveDay()<3){
			System.out.println("���������ˣ�"+request.getLeaveReason());
		}else{
			this.successor.proccessNext(request);
		}
	}
}
