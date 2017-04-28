package com.test.testThread;


/**
 * 
 * @author zhuyumeng
 * 1.锁定什么对象就用什么对象来执行 notify(), notifyAll(),wait(), wait(long), wait(long, int)操作，
 * 否则就会报IllegalMonitorStateException异常。
 * 2.wait()方法执行后，该线程处于block状态，等待其他线程的notify()方法。wait（）方法使当前线程主动释放互斥锁.
 * 3.notify();直到当前线程放弃此对象上的锁定，才能继续执行被唤醒的线程。被唤醒的线程将以常规方式与在该对象上主动同步的其他所有线程进行竞争；
 * 
 *  synchronized字段:
 *  exapmle 1,锁定方法所属的实例对象:
	public synchronized void method（）{
	    //然后就可以调用：this.notify()...
	    //或者直接调用notify()...
	}
	exapmle 2,锁定方法所属的实例的Class:
	public Class Test{
	 public static synchronized void method（）{
	    //然后调用：Test.class.notify()...
	 }
	}
	exapmle 3,锁定其他对象:
	public Class Test{
	public Object lock = new Object();
	 public static void method（）{
	    synchronized (lock) {
	     //需要调用 lock.notify();
	    } 
	 }
	}
	4.释放锁：1.运行完锁的代码块2.运行中出错3.wait（）方法。sleep().yield()不会释放锁。
 * 
 */
public class TestbankThread {
	public int money;
	public TestbankThread(int money){
		this.money=money;
	}
	
	public synchronized  void getMoney(int money){
		while(this.money<money){
			System.out.println("取款："+money+" 余额："+this.money+" 余额不足，正在等待存款......");
			try {
				wait();//线程处于blocked状态，等待被唤醒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.money=this.money-money;  
		System.out.println("取出："+money+" 还剩余："+this.money);
	}
	
	public synchronized  void setMoney(int money){
		try {
			Thread.sleep(100);//sleep不会释放锁
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.money=this.money+money;
		System.out.println("新存入："+money+" 共计："+this.money);  
		notify();//存入钱了之后，唤醒取钱的线程
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