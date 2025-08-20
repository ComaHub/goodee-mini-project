package com.goodee.proj.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.goodee.proj.common.interceptor.AdminCheckerInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 관리자 권한 체크
		registry.addInterceptor(new AdminCheckerInterceptor())
			.addPathPatterns("/account/list")
			.addPathPatterns("/animal/add", "/animal/update", "/animal/delete")
			.addPathPatterns("/product/add", "/product/update", "/product/delete");
		// 로그인 체크
//		registry.addInterceptor(new LoginCheckerInterceptor())
//			.addPathPatterns("/account/detail", "/account/update", "/account/delete")
//			.addPathPatterns("/product/like", "/cart/**", "/product/buy");
	}
}
