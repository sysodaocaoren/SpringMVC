package com.test.designPatterns.buildPatten;


public class MealBulider {
	public Meal vegMeal(){
		Meal meal =new Meal();
		meal.add(new VegBurger());
		meal.add(new Cock());
		return meal;
	}
	
	public Meal ChickMeal(){
		Meal meal =new Meal();
		meal.add(new ChickBurger());
		meal.add(new Pepsi());
		return meal;
	}
}
