package com.test.testThread;

public class TestNoSynchronized {

	public static void main(String[] args) {
			new TestNoSynchronized().init();
	}
	
	
	public  void init(){
		new Thread(new Runnable(){
			public  void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					output("zhuyumeng");
				}
			}
		}).start();
		new Thread(new Runnable(){
			public  void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					output("limin");
				}
			}
		}).start();
	}
	public synchronized static void output(String name){
		int length=name.length();
		for(int i=0;i<length;i++){
			System.out.print(name.charAt(i));
		}
		System.out.println();
	}
}
