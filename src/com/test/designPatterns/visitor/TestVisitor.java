package com.test.designPatterns.visitor;

/**
 * Sunny软件公司欲为某高校开发一套奖励审批系统，该系统可以实现教师奖励和学生奖励的审批(Award Check)，
 * 如果教师发表论文数超过10篇或者学生论文超过2篇可以评选科研奖，
 * 如果教师教学反馈分大于等于90分或者学生平均成绩大于等于90分可以评选成绩优秀奖。
 * 试使用访问者模式设计该系统，以判断候选人集合中的教师或学生是否符合某种获奖要求。
 * @author zhuyumeng
 *
 */
public class TestVisitor {

	public static void main(String[] args) {
		StudentCheck stu1=new StudentCheck("张三", 23, 97);
		StudentCheck stu2=new StudentCheck("张三1", 0, 95);
		StudentCheck stu3=new StudentCheck("张三2", 1, 7);
		StudentCheck stu4=new StudentCheck("张三3", 3, 87);
		
		TeacherCheck tck1=new TeacherCheck("李四", 23, 97);
		TeacherCheck tck2=new TeacherCheck("李四1", 2, 7);
		TeacherCheck tck3=new TeacherCheck("李四2", 1, 87);
		TeacherCheck tck4=new TeacherCheck("李四3", 13, 77);
		TeacherCheck tck5=new TeacherCheck("李四4", 11, 97);
		
		AwarderCreater list=new AwarderCreater();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		list.add(tck1);
		list.add(tck2);
		list.add(tck3);
		list.add(tck4);
		list.add(tck5);
		
		//进行科研奖评选
		PaperCheck pk=new PaperCheck();
		list.acceptCheck(pk);
		//进行成绩奖评选
		CountCheck ck=new CountCheck();
		list.acceptCheck(ck);
	}

}
