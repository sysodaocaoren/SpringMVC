package com.test.designPatterns.visitor;

public class CountCheck implements AwardCheck{

	public void check(TeacherCheck tk) {
		if(tk.getBackCount()>90){
			System.out.println(tk.getName()+"����ϲ������ȡ�ĳɼ����㽱����");
		}else{
			System.out.println(tk.getName()+"�����ź�����������");
		}
	}

	public void check(StudentCheck tk) {
		if(tk.getCount()>90){
			System.out.println(tk.getName()+"����ϲ������ȡ�ĳɼ����㽱����");
		}else{
			System.out.println(tk.getName()+"�����ź�����������");
		}
	}

}
