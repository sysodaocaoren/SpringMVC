package com.test.designPatterns.simpleFactory;

public class ShapeFactory {
	public Shape getShape(String ShapeName){
		if(ShapeName==null){
			return null;
		}
		if("circle".equals(ShapeName)){
			return new Circle();
		}else if ("rectangle".equals(ShapeName)){
			return new Rectangle();
		}else if ("square".equals(ShapeName)){
			return new Square();
		}else{
			return null;
		}
	}
}
