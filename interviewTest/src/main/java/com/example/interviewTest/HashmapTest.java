package com.example.interviewTest;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashmapTest {
	public static void main(String[] args) {
		HashMap<String,String> hashmap =new HashMap<String, String>();
		hashmap.put("1", "2");
		String value = hashmap.put("1", "3");
		System.out.println(value);
		ConcurrentHashMap<String,String> currentHashmap =new ConcurrentHashMap<String,String>();
		currentHashmap.put("2", "3");
	}
}
