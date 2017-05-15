package com.test.mashibing.muniu;

import java.util.ArrayList;
import java.util.List;

public class Pasture {
	
	List<Crow> crows=new ArrayList<Crow>();
	
	public Pasture(List<Crow> crows){
		this.crows=crows;
	}

	public List<Crow> getCrows() {
		return crows;
	}

	public void setCrows(List<Crow> crows) {
		this.crows = crows;
	}
	
	public int getTotal(){
		return crows.size();
	}
	
	public void developYear(int year){
		for(int i=1;i<=year;i++){
			List<Crow> newCrows=new ArrayList<Crow>();
			for(int j=0;j<this.crows.size();j++){
				Crow crow=this.crows.get(j);
				crow.setAge(crow.getAge()+1);
				if(crow.produce()!=null){
					newCrows.add(crow.produce());
				}
			}
			this.crows.addAll(newCrows);
			System.out.println("第"+i+"年产出新牛"+newCrows.size()+"头，"+"此时共有母牛"+this.crows.size()+"头。");
		}
	}
	
}
