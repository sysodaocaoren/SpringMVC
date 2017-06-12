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
		System.out.println("��"+str+"����ȡģ���ܣ���");
	}
	
}
