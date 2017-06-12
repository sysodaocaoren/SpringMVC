package com.test.designPatterns.decorator;

public class FinalEncryption extends DecoratorAbs{

	public FinalEncryption(Encryption etn) {
		super(etn);
	}
	
	public void encrypt(String str){
		super.encrypt(str);
		this.finalEncryption(str);
	}
	
	public void finalEncryption(String str){
		System.out.println("对"+str+"进行取模加密！！");
	}
	
}
