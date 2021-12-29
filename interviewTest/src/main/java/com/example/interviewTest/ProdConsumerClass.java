package com.example.interviewTest;

public class ProdConsumerClass {
	/* private volatile int num;
	
	public ProdConsumerClass(int num) {
		this.num=num;
	}
	public void add() {
		num++;
	}
	
	public void desc() {
		num--;
	}
	
	public static void main(String[] args) {
		ProdConsumerClass pcc=new ProdConsumerClass(0);
		Thread a = new Thread(()->{
			synchronized (pcc) {
				for(int i=0;i<5;i++) {
					pcc.add();
					System.out.println("add:"+pcc.num);
					try {
						pcc.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread b = new Thread(()->{
			synchronized (pcc) {
				for(int i=0;i<5;i++) {
					pcc.desc();
					System.out.println("desc:"+pcc.num);
					pcc.notify();
				}
			}
		});
		a.start();
		b.start();
		try {
			b.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pcc.num);
	}
	*/
}
