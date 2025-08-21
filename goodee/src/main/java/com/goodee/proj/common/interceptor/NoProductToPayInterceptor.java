package com.goodee.proj.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class NoProductToPayInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String[] checkedProducts = request.getParameterValues("checkedProduct");
		
		if (checkedProducts == null) {
			request.setAttribute("resultMsg", "구매하실 제품을 선택 후 결제해주세요.");
			request.setAttribute("resultIcon", "warning");
			request.setAttribute("url", "/cart/list");
			request.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(request, response);
			return false;
		}
		
		return true;
	}

	
}
