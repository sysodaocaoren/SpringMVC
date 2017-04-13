package com.test.set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * LinkedList
 * @author zhuyumeng
 * LinkedList ����˫��ѭ����������ݽṹ�洢���ݣ�entry����
 * ������ɾ�����޸ĵ�ʱ��ȽϿ�ݣ���ѯ��ʱ��Ƚ�������Ҫ�������е�entry����
 * ������ʱ��ʹ��foreach�����ȽϿ�
 */

public class TestLinkedList {
	final static int SIZE=111111;
	public static void main(String[] args){
		LinkedList<Object> linkList1=new LinkedList<Object>();
		linkList1.add("testLinkedList1");
		linkList1.add(11111);
		linkList1.add(false);
		
		LinkedList<Object> linkList2=new LinkedList<Object>();
		linkList2.add(false);
		linkList2.add("testLinkedList2");
		linkList2.add(1111);
		
		//linkList2.retainAll(linkList1);
		//System.out.println("linkList2.retainAll(linkList1):"+linkList2.toString());
		linkList2.remove(linkList1);
		System.out.println("linkList2.remove(linkList1):"+linkList2.toString());
		
		//����������forѭ���������ٶ�
		List<Integer> arrayList = new ArrayList<Integer>(SIZE);
        List<Integer> linkedList = new LinkedList<Integer>();
        
        for (int i = 0; i < SIZE; i++)
        {
            arrayList.add(i);
            linkedList.add(i);
        }
        
        loopList(arrayList);
        loopList(linkedList);
        System.out.println();
	}
	 /*
	  * ����������forѭ���������ٶ�
	  * ���ۣ�LinkedList ����ͨforѭ���������˷�ָ
	  */
	 private static void loopList(List<Integer> list)
	    {
	        long startTime = System.currentTimeMillis();
	        for (int i = 0; i < list.size(); i++)
	        {
	            list.get(i);
	        }
	        System.out.println(list.getClass().getSimpleName() + "ʹ����ͨforѭ������ʱ��Ϊ" + 
	                (System.currentTimeMillis() - startTime) + "ms");
	        
	        startTime = System.currentTimeMillis();
	        for (Integer i : list)
	        {
	            
	        }
	        System.out.println(list.getClass().getSimpleName() + "ʹ��foreachѭ������ʱ��Ϊ" + 
	                (System.currentTimeMillis() - startTime) + "ms");
	    }
}
