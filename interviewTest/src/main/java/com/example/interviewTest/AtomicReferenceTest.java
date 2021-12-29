package com.example.interviewTest;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicReferenceTest {
public static void main(String[] args) {
//	AtomicInteger ai =new AtomicInteger(0);
//	//ai.addAndGet(11);
//	for(int i=0;i<10;i++) {
//		new Thread(()->{
//			System.out.println(Thread.currentThread().getName()+":"+ai.addAndGet(1));
//		},"Thread-"+i).start();
//	}
	Object obj=new Object();
	Object ob2=new Object();
	AtomicStampedReference<Object> asr=new AtomicStampedReference<Object>(obj, 0);
	asr.set(ob2, 1);
	ThreadModel threadModel=new ThreadModel(1);
	
		for(int i=0;i<5;i++) {
			new Thread(()->{
			int a=threadModel.add();
			System.out.println(Thread.currentThread().getName()+":"+a);
			},"Thread-"+i).start();
		}

		for(int i=5;i<10;i++) {
			new Thread(()->{
			int a=threadModel.desc();
			System.out.println(Thread.currentThread().getName()+":"+a);
			},"Thread-"+i).start();
		}
	System.out.println(Thread.currentThread().isDaemon());

}

}
class ThreadModel{
	private AtomicInteger ai;
	
	public ThreadModel(int num) {
		this.ai=new AtomicInteger(num);
	}
	
	public int add() {
		return ai.addAndGet(1);
	}
	
	public int desc() {
		return ai.decrementAndGet();
	}
}