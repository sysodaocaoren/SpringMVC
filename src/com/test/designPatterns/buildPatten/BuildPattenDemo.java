package com.test.designPatterns.buildPatten;

public class BuildPattenDemo {

	public static void main(String[] args) {
		MealBulider mealBuild=new MealBulider();
		
		Meal vegMeal=mealBuild.vegMeal();
		System.out.println("vegMeal");
		vegMeal.showName();
		System.out.println("totalCost:"+vegMeal.getCost());
		
		Meal chickMeal=mealBuild.ChickMeal();
		System.out.println("chickMeal");
		chickMeal.showName();
		System.out.println("totalCost:"+chickMeal.getCost());
	}

}
