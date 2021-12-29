package com.example.interviewTest;
 
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {
	public static Object object=new Object();
	class CustomeThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}

	class CustomeThread2 extends Thread{
		@Override
		public void run() {
			synchronized (object) {
				System.out.println(Thread.currentThread().getName()+"is starting!");
				try {
					object.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" gets the sync lock.");
			}
		}
	}

	class CustomeThread3 implements Callable<String>{

		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
 public static void main(String[] args) {
	AtomicInteger ai=new AtomicInteger(5);
}
}
