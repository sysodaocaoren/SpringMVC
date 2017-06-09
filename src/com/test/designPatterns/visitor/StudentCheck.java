package com.test.designPatterns.visitor;

public class StudentCheck implements Awarder{
	private String name;
	private int paper;
	private int count;
	
	public StudentCheck(String name,int paper,int count){
		this.name=name;
		this.count=count;
		this.paper=paper;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPaper() {
		return paper;
	}

	public void setPaper(int paper) {
		this.paper = paper;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void accpetCheck(AwardCheck ack) {
		ack.check(this);
	}
	
	
}
