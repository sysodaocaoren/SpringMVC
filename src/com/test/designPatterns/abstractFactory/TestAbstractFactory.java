package com.test.designPatterns.abstractFactory;

import com.test.designPatterns.simpleFactory.Shape;
/**
 * 工厂模式总结：
 * 由工厂来创建对象而不是自己创建
 * 对象的方法由对象的基类来调用，客户端看不到具体的对象
 * 扩展一个对象只需要增加一个对象的工厂方法，而不需要修改工厂，体现了‘关闭-开发’的原则
 */
public class TestAbstractFactory {

	public static void main(String[] args) {
		ShapeFactory shapeFactory=new ShapeFactory();
		ColorFactory colorFactory=new ColorFactory();
		RedColorFactory redColorFactory=new RedColorFactory();
		
		Shape shape=shapeFactory.getShape("circle");
		Color color=colorFactory.getColor("blue");
		
		Color color2=redColorFactory.getColor();
		color2.fill();
		shape.draw();
		color.fill();
	}

}
