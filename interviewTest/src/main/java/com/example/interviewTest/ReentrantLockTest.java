package com.example.interviewTest;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReentrantLockTest {
	
	ReentrantLock lock=new ReentrantLock();
	
	ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();
	
	ReadLock readLock = rwlock.readLock();
	
	WriteLock writeLock = rwlock.writeLock();
	
	private static int count=0;
	
	public void inc() {
		try {
			lock.lock();
			Thread.sleep(1);
			count++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}
	
public static void main(String[] args) {
	ReentrantLockTest test=new ReentrantLockTest();
	
	for(int i =0;i<1000;i++) {
		new Thread(()->{
			test.inc();
		}).start();
	}
	try {
		Thread.sleep(1300);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(test.count);
}
}


