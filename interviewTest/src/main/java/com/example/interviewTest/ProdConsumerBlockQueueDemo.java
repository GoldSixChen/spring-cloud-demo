package com.example.interviewTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProdConsumerBlockQueueDemo {
	private volatile boolean FLAG=true;//默认开启，进行生产+消费
	private AtomicInteger atomicInteger=new AtomicInteger();
	private BlockingQueue<String> blockQueue=null;
	//通过构造方法传递阻塞队列
	public ProdConsumerBlockQueueDemo(BlockingQueue<String> blockQueue) {
		super();
		this.blockQueue = blockQueue;
	}
	public void myProd() throws Exception {
		String data=null;
		boolean retValue=false;
		while(FLAG) {
			data=atomicInteger.incrementAndGet()+"";
			retValue=blockQueue.offer(data,2,TimeUnit.SECONDS);
			if(retValue) {
				System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
			}else {
				System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
			}
		}
	}
	public void myCustomer() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
