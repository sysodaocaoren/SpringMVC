package com.test.mashibing.muniu;

public class Crow {
	private int age;
	private int pruduceAge;
	
	public Crow(int age,int produce){
		this.age=age;
		this.pruduceAge=produce;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPruduceAge() {
		return pruduceAge;
	}

	public void setPruduceAge(int pruduceAge) {
		this.pruduceAge = pruduceAge;
	}
	
	public Crow produce(){
		if(age<pruduceAge){
			return null;
		}else{
			return new Crow(0,5);
		}
	}
}
