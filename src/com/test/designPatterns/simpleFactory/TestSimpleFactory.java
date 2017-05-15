package com.test.designPatterns.simpleFactory;

/**
 * 简单工厂测试类
 * 简单工厂;创建对象时不暴露对象的逻辑，而是通过一个抽象的借口来创建，实例：数据库的连接
 * 1、一个调用者想创建一个对象，只要知道其名称就可以了。
 * 2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。 
 * 3、屏蔽产品的具体实现，调用者只关心产品的接口。
 * @author zhuyumeng
 *
 */
public class TestSimpleFactory {
	public static void main(String[] args){
		ShapeFactory shapeFactory=new ShapeFactory();
		Shape shapeCircle=shapeFactory.getShape("circle");
		Shape shapeRectangle=shapeFactory.getShape("rectangle");
		Shape shapeSquare=shapeFactory.getShape("square");
		shapeCircle.draw();
		shapeRectangle.draw();
		shapeSquare.draw();
	}
}
