package com.test.designPatterns.abstractFactory;

import com.test.designPatterns.simpleFactory.Shape;
/**
 * ����ģʽ�ܽ᣺
 * �ɹ�������������������Լ�����
 * ����ķ����ɶ���Ļ��������ã��ͻ��˿���������Ķ���
 * ��չһ������ֻ��Ҫ����һ������Ĺ���������������Ҫ�޸Ĺ����������ˡ��ر�-��������ԭ��
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
