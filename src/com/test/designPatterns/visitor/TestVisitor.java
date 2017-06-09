package com.test.designPatterns.visitor;

/**
 * Sunny�����˾��Ϊĳ��У����һ�׽�������ϵͳ����ϵͳ����ʵ�ֽ�ʦ������ѧ������������(Award Check)��
 * �����ʦ��������������10ƪ����ѧ�����ĳ���2ƪ������ѡ���н���
 * �����ʦ��ѧ�����ִ��ڵ���90�ֻ���ѧ��ƽ���ɼ����ڵ���90�ֿ�����ѡ�ɼ����㽱��
 * ��ʹ�÷�����ģʽ��Ƹ�ϵͳ�����жϺ�ѡ�˼����еĽ�ʦ��ѧ���Ƿ����ĳ�ֻ�Ҫ��
 * @author zhuyumeng
 *
 */
public class TestVisitor {

	public static void main(String[] args) {
		StudentCheck stu1=new StudentCheck("����", 23, 97);
		StudentCheck stu2=new StudentCheck("����1", 0, 95);
		StudentCheck stu3=new StudentCheck("����2", 1, 7);
		StudentCheck stu4=new StudentCheck("����3", 3, 87);
		
		TeacherCheck tck1=new TeacherCheck("����", 23, 97);
		TeacherCheck tck2=new TeacherCheck("����1", 2, 7);
		TeacherCheck tck3=new TeacherCheck("����2", 1, 87);
		TeacherCheck tck4=new TeacherCheck("����3", 13, 77);
		TeacherCheck tck5=new TeacherCheck("����4", 11, 97);
		
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
		
		//���п��н���ѡ
		PaperCheck pk=new PaperCheck();
		list.acceptCheck(pk);
		//���гɼ�����ѡ
		CountCheck ck=new CountCheck();
		list.acceptCheck(ck);
	}

}
