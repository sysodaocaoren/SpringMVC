package com.test.designPatterns.observer;

import java.util.ArrayList;

public abstract class ShareControllerCenter {
	
	protected  ArrayList<Shareder> shareders=new ArrayList<Shareder>();
	
	protected  String allName;

	public String getAllName() {
		return allName;
	}

	public void setAllName(String allName) {
		this.allName = allName;
	}
	
	public void join (Shareder shareder){
		shareders.add(shareder);
		System.out.println(shareder.getName()+",�����˹�ƱȺ����");
	}
	
	public void remove(Shareder shareder){
		shareders.remove(shareder);
		System.out.println(shareder.getName()+",�뿪�˹�ƱȺ����");
	}
	public abstract void notifyAll (String name);
}
