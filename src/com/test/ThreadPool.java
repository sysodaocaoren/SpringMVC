package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
		List<ThreadTesk> tasks=new ArrayList<ThreadTesk>();
		String [] indexs={"A","B","C","D"};
		long a=System.currentTimeMillis();
		for (int j=0;j<indexs.length;j++){
			ThreadTesk tk=new ThreadTesk(indexs[j]);
			tasks.add(tk);
		}
		try {
			 executor.invokeAll(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.println("-----------------end-------------");
		//System.out.println("线程时间："+(System.currentTimeMillis()-a));
		long b=System.currentTimeMillis();
		for(int j=0;j<1000;j++){
			System.out.println("a");
		}
		for(int j=0;j<1000;j++){
			System.out.println("b");
		}
		for(int j=0;j<1000;j++){
			System.out.println("c");
		}
		for(int j=0;j<1000;j++){
			System.out.println("d");
		}
		System.out.println("-----------------end-------------");
		System.out.println("非线程时间："+(System.currentTimeMillis()-b));
		
//		Map<String,Map<String,String>> maps=new HashMap<String,Map<String,String>>();
//		for(int i=0;i<20;i++){
//			Map<String,String> map=new HashMap<String,String>();
//			for(int j=0;j<10;j++){
//				map.put("code"+Integer.toString(j), Integer.toString(j));
//			}
//			maps.put("批次"+Integer.toString(i),map);
//			
//		}
//		System.out.println(maps);
//		Iterator<Entry<String,Map<String,String>>> iterator=maps.entrySet().iterator();
//		while(iterator.hasNext()){
//			Entry<String,Map<String,String>> entry=iterator.next();
//			Map<String,String> mapString=entry.getValue();
//			for(String code:mapString.keySet()){
//				String index=mapString.get(code);
//				System.out.println(code+":"+index);
//			}
//			System.out.println("2--------------------------------------------------4");
//		}
	}

}
