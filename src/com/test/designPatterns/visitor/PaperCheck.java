package com.test.designPatterns.visitor;
/**
 * 论文评选
 * @author zhuyumeng
 *
 */
public class PaperCheck implements AwardCheck{

	public void check(TeacherCheck tk) {
		if(tk.getPaperCount()>10){
			System.out.println(tk.getName()+"，恭喜您，评选为科研奖！！");
		}else{
			System.out.println(tk.getName()+"，很遗憾，论文不够~~");
		}
	}

	public void check(StudentCheck tk) {
		if(tk.getPaper()>2){
			System.out.println(tk.getName()+"，恭喜您，评选为科研奖！！");
		}else{
			System.out.println(tk.getName()+"，很遗憾，论文不够~~");
		}
		
	}

}
