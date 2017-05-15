package com.test.designPatterns.buildPatten;


public class Pepsi extends ColdDrink{

	public String name() {
		return "pepsi";
	}

	@Override
	public float price() {
		return 3f;
	}

}
