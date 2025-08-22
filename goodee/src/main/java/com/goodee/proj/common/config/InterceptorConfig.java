package com.goodee.proj.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.goodee.proj.common.interceptor.AdminCheckerInterceptor;
import com.goodee.proj.common.interceptor.LoginCheckerInterceptor;
import com.goodee.proj.common.interceptor.NoProductToPayInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	private NoProductToPayInterceptor noProductToPayInterceptor;
	@Autowired
	private LocaleChangeInterceptor localeChangeInterceptor;

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
			.addPathPatterns("/product/like", "/cart/**", "/product/buy", "/comapay/**", "/like/**");
		
		// 구매 요청 시 체크된 제품이 없는 경우
		registry.addInterceptor(noProductToPayInterceptor)
						.addPathPatterns("/comapay/checkout");
		
		// 언어 설정
		registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
	}
}
