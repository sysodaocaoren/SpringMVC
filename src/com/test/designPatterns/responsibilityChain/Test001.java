package com.test.designPatterns.responsibilityChain;
/**
 * 
 
��ϰ
  Sunny�����˾��OAϵͳ��Ҫ�ṩһ����������ģ�飺
    ���Ա���������С��3�죬���ο��������ü��������Ա������������ڵ���3�죬С��10�죬
    ����������������Ա������������ڵ���10�죬С��30�죬�ܾ������������
    �������30�죬�ܾ���Ҳ������������ʾ��Ӧ�ľܾ���Ϣ������ְ����ģʽ��Ƹü�������ģ�顣
 * @author zhuyumeng
 *
 */
public class Test001 {

	public static void main(String[] args) {
		//������������ɫ
		YunGongEntity yuangong=new YunGongEntity("С��");
		 Employee zhuren=new ZhurenEntity("����");
		 Employee jingli=new JingLiEntity("ǿ��");
		 Employee zongjingli=new ZongJingLiEntity("ɵ��");
		
		//����������
		yuangong.setSuccessor(zhuren);
		zhuren.setSuccessor(jingli);
		jingli.setSuccessor(zongjingli);
		
		//Ա�����
		LeaveRequest lr1=new LeaveRequest();
		lr1.setLeaveDay(2);
		lr1.setLeaveReason("��һ���~~~");
		
		LeaveRequest lr2=new LeaveRequest();
		lr2.setLeaveDay(6);
		lr2.setLeaveReason("��6���~~~");
		
		LeaveRequest lr3=new LeaveRequest();
		lr3.setLeaveDay(20);
		lr3.setLeaveReason("��20���~~~");
		
		LeaveRequest lr4=new LeaveRequest();
		lr4.setLeaveDay(40);
		lr4.setLeaveReason("��40���~~~");
		
		//��ʼ�����
		yuangong.proccessNext(lr1);
		yuangong.proccessNext(lr2);
		yuangong.proccessNext(lr3);
		yuangong.proccessNext(lr4);
	}

}
