package com.test.designPatterns.buildPatten;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	public List<Item> items=new ArrayList<Item>();
	
	public void add(Item item){
		items.add(item);
	}
	
	public float getCost(){
		float totalFloat=0;
		for(Item item:items){
			totalFloat+=item.price();
		}
		return totalFloat;
	}
	
	public void showName(){
		for(Item item:items){
			System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
		}
	}
}
