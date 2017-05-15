package com.test.designPatterns.abstractFactory;

import com.test.designPatterns.simpleFactory.Shape;

public abstract class AbstactFactory {
	 abstract Shape getShape(String name);
	 abstract Color getColor(String name);
}
