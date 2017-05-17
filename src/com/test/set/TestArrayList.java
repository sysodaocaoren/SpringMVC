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
		
		ArrayList<Object> list3=new ArrayList<Object>(23);//������������ʱ����������
		//������֮�����Ҫȷ�����������Բ���ensureCapacity���ƶ����ϵ��������������Ч��
		//ԭ���Ǽ������ڲ����ʱ����Ϊ�����������´�������Ĺ���
		list3.ensureCapacity(50);
		list3=(ArrayList<Object>) list2.clone();
		System.out.println(list3.contains("test2"));
		list2.removeAll(list1);
		//System.out.println(list3.toString());
		//testEnsurecapacity();//�������������Ͳ���������Ч�ʵıȽ�
		//queryList();
	}
	
	/**
	 * ���鸴�Ƶķ�������ArrayList�����ĵײ㣬�ܶ඼��ʹ������Щ������
	 * System. arraycopy(elementData, index+1, elementData, index, numMoved);
	 * ���������ǣ�ԭ�������飬���Ƶ���ʼλ�ã�Ҫ���Ƶ����飬��ʲô�ط���ʼ���ƣ����Ƶĸ���
	 */
	
	
	/**
	 * �������������Ͳ���������Ч�ʵıȽ�
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
	 * ArrayList�ı���
	 * ����  �������ָ��Ч�����
	 */
	public static void queryList(){
		List<Object> list1=new ArrayList<Object>();
		list1.add("test");
		list1.add(11111);
		list1.add(true);
		list1.add("3");
		
		//������
		Iterator iterator=list1.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		//���ָ��
		for(int i=0;i<list1.size();i++){
			System.out.println(list1.get(i));
		}
		//for
		for(Object obj:list1){
			System.out.println(obj);
		}
	}
}
