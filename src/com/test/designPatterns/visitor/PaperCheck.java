package com.test.designPatterns.visitor;
/**
 * ������ѡ
 * @author zhuyumeng
 *
 */
public class PaperCheck implements AwardCheck{

	public void check(TeacherCheck tk) {
		if(tk.getPaperCount()>10){
			System.out.println(tk.getName()+"����ϲ������ѡΪ���н�����");
		}else{
			System.out.println(tk.getName()+"�����ź������Ĳ���~~");
		}
	}

	public void check(StudentCheck tk) {
		if(tk.getPaper()>2){
			System.out.println(tk.getName()+"����ϲ������ѡΪ���н�����");
		}else{
			System.out.println(tk.getName()+"�����ź������Ĳ���~~");
		}
		
	}

}
