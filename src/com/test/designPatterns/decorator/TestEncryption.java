package com.test.designPatterns.decorator;

public class TestEncryption {
	public static void main(String[] args){
		//�򵥵Ľ�����ĸλ�Ƽ���
		Encryption et=new BasicEncryption();
		et=new DeepEncryption(et);
		et=new FinalEncryption(et);
		et.encrypt("String");
	}
}
