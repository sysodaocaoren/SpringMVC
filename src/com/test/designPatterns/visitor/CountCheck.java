package com.test.designPatterns.visitor;

public class CountCheck implements AwardCheck{

	public void check(TeacherCheck tk) {
		if(tk.getBackCount()>90){
			System.out.println(tk.getName()+"，恭喜您，获取的成绩优秀奖！！");
		}else{
			System.out.println(tk.getName()+"，很遗憾，分数不够");
		}
	}

	public void check(StudentCheck tk) {
		if(tk.getCount()>90){
			System.out.println(tk.getName()+"，恭喜您，获取的成绩优秀奖！！");
		}else{
			System.out.println(tk.getName()+"，很遗憾，分数不够");
		}
	}

}
