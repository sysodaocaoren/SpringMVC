package com.test.designPatterns.visitor;

import java.util.ArrayList;

public class AwarderCreater {
	private ArrayList<Awarder> list=new ArrayList<Awarder>();
	
	public void add(Awarder adr){
		list.add(adr);
	}
	
	public void acceptCheck(AwardCheck ack){
		for(Awarder ader:list){
			ader.accpetCheck(ack);
		}
	}
	
}
