package com.test.set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * LinkedList
 * @author zhuyumeng
 * LinkedList 采用双向循环链表的数据结构存储数据，entry对象
 * 新增，删除，修改的时候比较快捷，查询的时候比较慢，需要遍历所有的entry对象
 * 遍历的时候使用foreach遍历比较快
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
		
		//测试用两种for循环遍历的速度
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
	  * 测试用两种for循环遍历的速度
	  * 结论：LinkedList 用普通for循环真是令人发指
	  */
	 private static void loopList(List<Integer> list)
	    {
	        long startTime = System.currentTimeMillis();
	        for (int i = 0; i < list.size(); i++)
	        {
	            list.get(i);
	        }
	        System.out.println(list.getClass().getSimpleName() + "使用普通for循环遍历时间为" + 
	                (System.currentTimeMillis() - startTime) + "ms");
	        
	        startTime = System.currentTimeMillis();
	        for (Integer i : list)
	        {
	            
	        }
	        System.out.println(list.getClass().getSimpleName() + "使用foreach循环遍历时间为" + 
	                (System.currentTimeMillis() - startTime) + "ms");
	    }
}
