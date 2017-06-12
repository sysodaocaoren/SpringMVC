package com.test.designPatterns.decorator;

public class DeepEncryption extends DecoratorAbs{

	public DeepEncryption(Encryption etn) {
		super(etn);
	}

	public void encrypt(String str) {
		super.encrypt(str);
		this.deepEncrtpt(str);
	}
	public void deepEncrtpt(String str){
		System.out.println("对"+str+"进行逆向加密！！");
	}
	
}
