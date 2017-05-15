package com.test.designPatterns.buildPatten;

public class ChickBurger extends Burger{

	public String name() {
		return "ChickBurger";
	}

	@Override
	public float price() {
		return 8.9f;
	}

}
