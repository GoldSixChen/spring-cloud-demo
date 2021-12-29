package com.neko.review.consumers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignConfiguration {

	@Bean
	Logger.Level feignLoggingLevel(){
		return Logger.Level.FULL;
	}
}
