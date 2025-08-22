package com.goodee.proj.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.goodee.proj.common.interceptor.AdminCheckerInterceptor;
import com.goodee.proj.common.interceptor.LoginCheckerInterceptor;
import com.goodee.proj.common.interceptor.NoProductToPayInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	private NoProductToPayInterceptor noProductToPayInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 관리자 권한 체크
		registry.addInterceptor(new AdminCheckerInterceptor())
			.addPathPatterns("/account/list")
			.addPathPatterns("/animal/add", "/animal/update", "/animal/delete")
			.addPathPatterns("/product/add", "/product/update", "/product/delete");
		// 로그인 체크
		registry.addInterceptor(new LoginCheckerInterceptor())
			.addPathPatterns("/account/detail", "/account/update", "/account/delete")
			.addPathPatterns("/product/like", "/cart/**", "/product/buy");
		// 구매 요청 시 체크된 제품이 없는 경우
		registry.addInterceptor(noProductToPayInterceptor)
						.addPathPatterns("/comapay/checkout");
	}
}
