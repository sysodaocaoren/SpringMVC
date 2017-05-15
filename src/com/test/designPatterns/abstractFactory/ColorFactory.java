package com.test.designPatterns.abstractFactory;

import com.test.designPatterns.simpleFactory.Shape;

public class ColorFactory extends AbstactFactory{
	public Color getColor(String colorName){
		if(colorName==null){
			return null;
		}
		if("red".equals(colorName)){
			return new Red();
		}else if("blue".equals(colorName)){
			return new Blue();
		}else{
			return null;
		}
	}

	@Override
	Shape getShape(String name) {
		return null;
	}
}
