package com.test.designPatterns.strategy;

public class TestPlane {
	
	public static void main(String[] args){
		ContextGetter ct=new ContextGetter();
		Helicopter hr=new Helicopter();
		ct.getPlaneType(hr);
	}
	
}
