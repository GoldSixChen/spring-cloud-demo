package com.neko.review.providers.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Value("${provider.name}")
	private String name;
	@Value("${server.port}")
	private String port;
	@RequestMapping("/hello")
	public String hello() {
		String str = name + ":" +port;
		return str;
	}
}
