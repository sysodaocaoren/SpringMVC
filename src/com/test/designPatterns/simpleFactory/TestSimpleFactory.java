package com.test.designPatterns.simpleFactory;

/**
 * �򵥹���������
 * �򵥹���;��������ʱ����¶������߼�������ͨ��һ������Ľ����������ʵ�������ݿ������
 * 1��һ���������봴��һ������ֻҪ֪�������ƾͿ����ˡ�
 * 2����չ�Ըߣ����������һ����Ʒ��ֻҪ��չһ��������Ϳ��ԡ� 
 * 3�����β�Ʒ�ľ���ʵ�֣�������ֻ���Ĳ�Ʒ�Ľӿڡ�
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
