package com.test.designPatterns.visitor;

public class TeacherCheck implements Awarder{
   private int	paperCount;
   
   private int backCount;
   
   private String name;
   
   public TeacherCheck(String name,int paper,int backCount){
	   this.name=name;
	   this.backCount=backCount;
	   this.paperCount=paper;
   }

	public int getPaperCount() {
		return paperCount;
	}
	
	public void setPaperCount(int paperCount) {
		this.paperCount = paperCount;
	}
	
	public int getBackCount() {
		return backCount;
	}
	
	public void setBackCount(int backCount) {
		this.backCount = backCount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void accpetCheck(AwardCheck ack) {
		ack.check(this);
	}
   
   
   
}
