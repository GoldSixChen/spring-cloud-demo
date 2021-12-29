package com.neko.review.consumers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
	@Autowired
	MyFeignClient myFeignClient;
	
	@RequestMapping("/hello")
	public String hello() {
		return myFeignClient.hello();
	}
}
