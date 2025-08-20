package com.goodee.proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class GoodeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodeeApplication.class, args);
	}

}
