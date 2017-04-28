package com.test.testThread;


/**
 * 
 * @author zhuyumeng
 * 1.����ʲô�������ʲô������ִ�� notify(), notifyAll(),wait(), wait(long), wait(long, int)������
 * ����ͻᱨIllegalMonitorStateException�쳣��
 * 2.wait()����ִ�к󣬸��̴߳���block״̬���ȴ������̵߳�notify()������wait��������ʹ��ǰ�߳������ͷŻ�����.
 * 3.notify();ֱ����ǰ�̷߳����˶����ϵ����������ܼ���ִ�б����ѵ��̡߳������ѵ��߳̽��Գ��淽ʽ���ڸö���������ͬ�������������߳̽��о�����
 * 
 *  synchronized�ֶ�:
 *  exapmle 1,��������������ʵ������:
	public synchronized void method����{
	    //Ȼ��Ϳ��Ե��ã�this.notify()...
	    //����ֱ�ӵ���notify()...
	}
	exapmle 2,��������������ʵ����Class:
	public Class Test{
	 public static synchronized void method����{
	    //Ȼ����ã�Test.class.notify()...
	 }
	}
	exapmle 3,������������:
	public Class Test{
	public Object lock = new Object();
	 public static void method����{
	    synchronized (lock) {
	     //��Ҫ���� lock.notify();
	    } 
	 }
	}
	4.�ͷ�����1.���������Ĵ����2.�����г���3.wait����������sleep().yield()�����ͷ�����
 * 
 */
public class TestbankThread {
	public int money;
	public TestbankThread(int money){
		this.money=money;
	}
	
	public synchronized  void getMoney(int money){
		while(this.money<money){
			System.out.println("ȡ�"+money+" ��"+this.money+" ���㣬���ڵȴ����......");
			try {
				wait();//�̴߳���blocked״̬���ȴ�������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.money=this.money-money;  
		System.out.println("ȡ����"+money+" ��ʣ�ࣺ"+this.money);
	}
	
	public synchronized  void setMoney(int money){
		try {
			Thread.sleep(100);//sleep�����ͷ���
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.money=this.money+money;
		System.out.println("�´��룺"+money+" ���ƣ�"+this.money);  
		notify();//����Ǯ��֮�󣬻���ȡǮ���߳�
	}
	
	public static void main(String[] args){
		TestbankThread td=new TestbankThread(0);
		Bank bk=new Bank(td);
		Consumer cs=new Consumer(td);
		Thread thread1=new Thread(bk);
		Thread thread2=new Thread(cs);
		thread1.start();
		thread2.start();
	}
}

class Bank implements Runnable{
	TestbankThread testbankThread;
	public Bank(TestbankThread testbankThread){
		this.testbankThread=testbankThread;
	}
	public void run() {
		while(true){
			int money=(int)(Math.random()*1000);
			testbankThread.setMoney(money);
		}
	}
}


class Consumer implements Runnable{
	TestbankThread testbankThread;
	public Consumer(TestbankThread testbankThread){
		this.testbankThread=testbankThread;
	}
	public void run() {
		while(true){
			int money=(int)(Math.random()*1000);
			testbankThread.getMoney(money);
		}
	}
}