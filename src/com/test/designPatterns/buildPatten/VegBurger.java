package com.test.designPatterns.buildPatten;

public class VegBurger extends Burger{

	public String name() {
		return "VegBurger";
	}

	@Override
	public float price() {
		return 5.6f;
	}

}
