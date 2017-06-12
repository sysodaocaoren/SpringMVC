package com.test.designPatterns.decorator;

public class TestEncryption {
	public static void main(String[] args){
		//简单的进行字母位移加密
		Encryption et=new BasicEncryption();
		et=new DeepEncryption(et);
		et=new FinalEncryption(et);
		et.encrypt("String");
	}
}
