package com.test.designPatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Fold extends Compone{
	
	private String name;
	private List<Compone> compones=new ArrayList<Compone>();
	
	public Fold(String name){
		this.name=name;
	}
	
	public void add(Compone c){
		this.compones.add(c);
	}
	
	public void remove(Compone c){
		this.compones.remove(c);
	}
	
	public Compone getChild(int i){
		return this.compones.get(i);
	}
	@Override
	public void killVirSu() {
		System.out.println("***对文件"+name+"进行杀毒~~***");
		for(Compone c:this.compones){
			c.killVirSu();
		}
	}
	
}
