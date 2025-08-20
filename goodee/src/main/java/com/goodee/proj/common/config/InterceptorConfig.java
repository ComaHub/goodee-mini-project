package com.goodee.proj.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.goodee.proj.common.interceptor.AdminCheckerInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AdminCheckerInterceptor())
			.addPathPatterns("/account/list")
			.addPathPatterns("/product/add", "/product/update", "/product/delete");
	}
}
