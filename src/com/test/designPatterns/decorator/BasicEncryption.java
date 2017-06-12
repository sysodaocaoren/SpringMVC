package com.test.designPatterns.decorator;

public class BasicEncryption implements Encryption{
	
	public void encrypt(String str) {
		System.out.println("对"+str+"进行字母位移进行加密！");
	}

}
