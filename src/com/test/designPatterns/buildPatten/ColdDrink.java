package com.test.designPatterns.buildPatten;

public abstract class ColdDrink implements Item{
	public Packing packing(){
		return new Bottle();
	}
	public abstract float price();
}
