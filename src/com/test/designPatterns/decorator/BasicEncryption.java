package com.test.designPatterns.decorator;

public class BasicEncryption implements Encryption{
	
	public void encrypt(String str) {
		System.out.println("��"+str+"������ĸλ�ƽ��м��ܣ�");
	}

}
