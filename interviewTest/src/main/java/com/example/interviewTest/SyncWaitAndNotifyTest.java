package com.example.interviewTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SyncWaitAndNotifyTest {
  public static void main(String[] args) {
	Object lock=new Object();
	ConcurrentHashMap chm=new ConcurrentHashMap();
	Thread a=new Thread(()->{
		synchronized (lock) {
			chm.put("1", "2");
			System.out.println(Thread.currentThread().getName()+" gets lock!");
			
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+" "+chm.get("1"));
				lock.wait();
				System.out.println(Thread.currentThread().getName()+" "+chm.get("1"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" ends lock!");
		}
	},"A");
	
	Thread b=new Thread(()->{
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName()+" gets lock!");
			System.out.println(Thread.currentThread().getName()+" "+chm.get("1"));
			chm.put("1", "3");
			try {
				Thread.sleep(1000);
				lock.notify();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" ends lock!");
		}
	},"B");
	  a.start();
	  b.start();
	  
	  Thread c =new Thread(()->{
		  
	  },"C");
	  
	  ThreadD d =new ThreadD("D");
	  new Thread(d).start();
	  
	  new Thread(new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("e start!");
			
		}
	  }).start();
	  
	  FutureTask<Object> ft=new FutureTask<Object>(new ThreadF());
	  Thread tf = new Thread(ft,"thread-F");
	  tf.start();
	  try {
		System.out.println("callable:"+ft.get());
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
} 
}

class ThreadD implements Runnable{
	private String name;
	ThreadD(String name){
		this.name=name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name+" start!");
	}
	
}

class ThreadF implements Callable<Object>{

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return 1;
	}
	
}
