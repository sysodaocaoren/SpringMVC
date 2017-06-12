package com.test.designPatterns.decorator;

public abstract class DecoratorAbs implements Encryption{
	
	private Encryption etn;
	
	public DecoratorAbs(Encryption etn){
		this.etn=etn;
	}
	
	public  void encrypt(String str){
		etn.encrypt(str);
	}
}
