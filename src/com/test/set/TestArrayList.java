package com.test.set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.StyledEditorKit.ItalicAction;

public class TestArrayList {
	public static void main(String[] args){
		List<Object> list1=new ArrayList<Object>();
		list1.add("test");
		list1.add(11111);
		list1.add(true);
		list1.add("3");
		ArrayList<Object> list2=new ArrayList<Object>();
		list2.add("test2");
		list2.add(22222);
		list2.add(true);
		list2.add("3");
		
		ArrayList<Object> list3=new ArrayList<Object>(23);//可以在声明的时候声明容量
		//在声明之后如果要确定容量，可以采用ensureCapacity来制定集合的容量，可以提高效率
		//原理是减少了在插入的时候因为容量不够重新创建数组的过程
		list3.ensureCapacity(50);
		list3=(ArrayList<Object>) list2.clone();
		System.out.println(list3.contains("test2"));
		list2.removeAll(list1);
		//System.out.println(list3.toString());
		//testEnsurecapacity();//测试设置容量和不设置容量效率的比较
		//queryList();
	}
	
	/**
	 * 数组复制的方法（在ArrayList操作的底层，很多都是使用了这些方法）
	 * System. arraycopy(elementData, index+1, elementData, index, numMoved);
	 * 参数依次是：原来的数组，复制的起始位置，要复制的数组，从什么地方开始复制，复制的个数
	 */
	
	
	/**
	 * 测试设置容量和不设置容量效率的比较
	 */
	public static void testEnsurecapacity(){
		long noStartTime=System.currentTimeMillis();
		ArrayList<Integer> listInt1=new ArrayList<Integer>();
		for(int i=1;i<1000000;i++){
			listInt1.add(i);
		}
		long noEndTime=System.currentTimeMillis();
		
		long StartTime=System.currentTimeMillis();
		ArrayList<Integer> listInt2=new ArrayList<Integer>();
		listInt2.ensureCapacity(1000);
		for(int i=1;i<1000000;i++){
			listInt2.add(i);
		}
		long EndTime=System.currentTimeMillis();
		
		System.out.println(noEndTime-noStartTime);
		System.out.println(EndTime-StartTime);
	}
	/**
	 * ArrayList的遍历
	 * 三种  其中随机指向效率最高
	 */
	public static void queryList(){
		List<Object> list1=new ArrayList<Object>();
		list1.add("test");
		list1.add(11111);
		list1.add(true);
		list1.add("3");
		
		//迭代器
		Iterator iterator=list1.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		//随机指向
		for(int i=0;i<list1.size();i++){
			System.out.println(list1.get(i));
		}
		//for
		for(Object obj:list1){
			System.out.println(obj);
		}
	}
}
