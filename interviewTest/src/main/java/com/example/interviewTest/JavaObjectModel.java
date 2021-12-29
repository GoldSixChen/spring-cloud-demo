package com.example.interviewTest;

import org.openjdk.jol.info.ClassLayout;

public class JavaObjectModel {
private static Object o =new Object();

public static void main(String[] args) {
	//o.hashCode();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int i=0;i<5;i++) {
		new Thread().start();
	}
	System.out.println(ClassLayout.parseInstance(o).toPrintable());
	synchronized (o) {
		System.out.println(ClassLayout.parseInstance(o).toPrintable());
	}
	System.out.println(ClassLayout.parseInstance(o).toPrintable());
}
}
