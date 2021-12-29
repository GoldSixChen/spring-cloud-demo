package com.neko.review.consumers.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neko.review.consumers.FeignConfiguration;

@FeignClient(name="provider",configuration = FeignConfiguration.class)
public interface MyFeignClient {
	@RequestMapping(value="/hello")
	public String hello();
}
