package com.example.interviewTest;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

import org.springframework.boot.autoconfigure.web.ServerProperties.Jetty.Threads;

public class TestDemo {
	public static void main(String[] args) {
		HashMap<String,String> map=new HashMap<>();
		CountDownLatch sdl=new CountDownLatch(10);
		System.out.println("test");
		for(int i =1;i<7;i++){
			new Thread(()->{
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("单个执行"+Thread.currentThread().getName());
				sdl.countDown();
				
			},CountryEnum.foreach_countryenum(i).getRetName()).start();
		}
		try {
			sdl.await();
			System.out.println("the last one is " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
