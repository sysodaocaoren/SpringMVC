package com.test.set;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.wg.bean.User;

/**
 * mapԴ���������ϰ
 * http://tengj.top/2016/04/15/javajh3hashmap/
 * @author zhuyumeng
 * 
 */

public class TestMap {
	public static void main(String[] args){
		Map<String,Integer> map1=new HashMap<String,Integer>();
		
		map1.put("1", 1);
		map1.put("2", 2);
		map1.put("3", 3);
		map1.put("4", 4);
		map1.put("5", 5);
		map1.put("6", 6);
		
		//IteratorMap (map1);
		//forchEachMap(map1);
		//ItratorKey(map1);
		//testHashCode();
		testTreeMap();
	}
	/**
	 * ����mapֵ
	 * @param map1
	 */
	private static void IteratorMap(Map<String, Integer> map1) {
		Iterator<Entry<String,Integer>> iterator=map1.entrySet().iterator();
		System.out.println("-------��������------");
		while (iterator.hasNext()){
			Entry<String,Integer> entry=iterator.next();
			String key=entry.getKey();
			int value=entry.getValue();
			System.out.println("key:"+key+",value:"+value);
		}
		System.out.println("------------------");
	}
	
	/**
	 * forEach ѭ��key
	 */
	public static void forchEachMap(Map<String, Integer> map1){
		System.out.println("-------forEachѭ��key------");
		for(String key:map1.keySet()){
			System.out.println("key:"+key+",value:"+map1.get(key));
		}
		System.out.println("-------------------------");
	}
	
	/**
	 * ����ѭ��key ѭ��key
	 */
	public static void ItratorKey(Map<String, Integer> map1){
		System.out.println("-------����ѭ��key------");
		for(Iterator<String> i=map1.keySet().iterator();i.hasNext();){
			String key=i.next();
			System.out.println("key:"+key+",value:"+map1.get(key));
		}
		System.out.println("-------------------------");
	}
	
	/**
	 * ���Բ���дhashcode��equalsʱ�����
	 */
	public static void testHashCode(){
		Map<User,String> userMap=new HashMap<User,String>();
		userMap.put(new User(1l,"2","3"),"1");
		userMap.put(new User(2l,"3","4"),"2");
		userMap.put(new User(3l,"4","5"),"3");
		
		boolean flag=userMap.containsKey(new User(2l,"4","4"));
		System.out.println(flag);
	}
	
	/**
	 * treeMap �����Map
	 * ���ݽṹ�Ƕ�����
	 */
	public static void testTreeMap(){
		TreeMap<String,String> treeMap=new TreeMap<String,String>();
		treeMap.put("1", "1");
		treeMap.put("2", "3");
		treeMap.put("3", "5");
		treeMap.put("4", "7");
		treeMap.put("5", "9");
		treeMap.put("6", "11");
		treeMap.put("7", "13");
		
		Iterator<String> it1=treeMap.keySet().iterator();
		while(it1.hasNext()){
			String key=it1.next();
			System.out.println("key:"+key+",value:"+treeMap.get(key));
		}
		System.out.println("floorKey:3----"+treeMap.lowerKey("3"));
		System.out.println("treeMap----"+treeMap);
		
	}
}
