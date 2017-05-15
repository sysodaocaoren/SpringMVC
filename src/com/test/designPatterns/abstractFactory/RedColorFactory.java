package com.test.designPatterns.abstractFactory;

import com.test.designPatterns.simpleFactory.Shape;

public class RedColorFactory extends AbstactFactory{


	@Override
	Color getColor(String name) {
		return new Red();
	}
	
	Color getColor() {
		return new Red();
	}

	@Override
	Shape getShape(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
