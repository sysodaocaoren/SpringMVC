package com.test.designPatterns.abstractFactory;

import com.test.designPatterns.simpleFactory.Circle;
import com.test.designPatterns.simpleFactory.Rectangle;
import com.test.designPatterns.simpleFactory.Shape;
import com.test.designPatterns.simpleFactory.Square;

public class ShapeFactory extends AbstactFactory{
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

	@Override
	Color getColor(String name) {
		return null;
	}

}
