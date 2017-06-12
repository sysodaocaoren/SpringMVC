package com.test.designPatterns.composite;

public class File extends Compone{
	
	private String name;
	public File(String name){
		this.name=name;
	}
	@Override
	public void killVirSu() {
		System.out.println("--对文件"+name+"进行杀毒~~--");
	}
	
}
