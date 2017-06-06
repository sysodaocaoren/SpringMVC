package com.test.designPatterns.responsibilityChain;
/**
 * 
 
练习
  Sunny软件公司的OA系统需要提供一个假条审批模块：
    如果员工请假天数小于3天，主任可以审批该假条；如果员工请假天数大于等于3天，小于10天，
    经理可以审批；如果员工请假天数大于等于10天，小于30天，总经理可以审批；
    如果超过30天，总经理也不能审批，提示相应的拒绝信息。试用职责链模式设计该假条审批模块。
 * @author zhuyumeng
 *
 */
public class Test001 {

	public static void main(String[] args) {
		//先声明各个角色
		YunGongEntity yuangong=new YunGongEntity("小明");
		 Employee zhuren=new ZhurenEntity("主任");
		 Employee jingli=new JingLiEntity("强哥");
		 Employee zongjingli=new ZongJingLiEntity("傻叉");
		
		//设置责任链
		yuangong.setSuccessor(zhuren);
		zhuren.setSuccessor(jingli);
		jingli.setSuccessor(zongjingli);
		
		//员工请假
		LeaveRequest lr1=new LeaveRequest();
		lr1.setLeaveDay(2);
		lr1.setLeaveReason("请一天假~~~");
		
		LeaveRequest lr2=new LeaveRequest();
		lr2.setLeaveDay(6);
		lr2.setLeaveReason("请6天假~~~");
		
		LeaveRequest lr3=new LeaveRequest();
		lr3.setLeaveDay(20);
		lr3.setLeaveReason("请20天假~~~");
		
		LeaveRequest lr4=new LeaveRequest();
		lr4.setLeaveDay(40);
		lr4.setLeaveReason("请40天假~~~");
		
		//开始请假了
		yuangong.proccessNext(lr1);
		yuangong.proccessNext(lr2);
		yuangong.proccessNext(lr3);
		yuangong.proccessNext(lr4);
	}

}
