package com.example.interviewTest;

import java.util.concurrent.Callable;

public class MyThread {
	
class CustomThreadOne extends Thread{
	public int i;
	final Object lock=new Object();
	CustomThreadOne(int i){
		this.i=i;
	}
	@Override
	public void run() {
		synchronized (lock) {
			i++;
		}
	}
	
}

class CustomThreadTwo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

class CustomeThreadThree implements Callable<Object>{

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}



public static void main(String[] args) {
	System.out.println("start:"+Thread.currentThread().getName());
	try {
		ThreadB b = new ThreadB();
		ThreadA a = new ThreadA(b);
		ThreadC c = new ThreadC(b);
		a.start();
		Thread.sleep(2000);
		c.start();
	}catch(InterruptedException e) {
		e.printStackTrace();
	}
}
}

class ThreadA extends Thread {
	private ThreadB b;
	public ThreadA(ThreadB b) {
		super();
		this.b=b;
		this.setName("thread-A");
	}
	@Override
	public void run() {
		try {
			synchronized (b) {
				System.out.println(Thread.currentThread().getName()+"aaa");
				b.start();
				//Thread.sleep(5000);
				System.out.println(Thread.currentThread().getName()+"aba");
				b.join();
				System.out.println(Thread.currentThread().getName()+"aca");
				for(int i=0;i<100;i++) {
					System.out.print(i);
				}
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadB extends Thread{
	public ThreadB(){
	super("thread-B");
	}
	@Override
	public void run() {
		try {
			System.out.println("b run begin timer="+System.currentTimeMillis()+"-"+Thread.currentThread().getName());
			Thread.sleep(3000);
			System.out.println("b run end timer="+System.currentTimeMillis()+"-"+Thread.currentThread().getName());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	synchronized public void bService() {
		System.out.println(" b service run timer="+System.currentTimeMillis()+"-"+Thread.currentThread().getName());
	}
}

class ThreadC extends Thread{
	private ThreadB b;
	public ThreadC(ThreadB b){
		super();
		this.b=b;
		this.setName("thread-C");
	}
	@Override
	public void run() {
		b.bService();
	}
}
