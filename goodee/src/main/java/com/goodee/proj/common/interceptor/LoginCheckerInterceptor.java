package com.goodee.proj.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.goodee.proj.account.AccountDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCheckerInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		if (accountDTO == null) {
			request.setAttribute("resultMsg", "로그인된 사용자만 이용 가능합니다.");
			request.setAttribute("resultIcon", "warning");
			request.setAttribute("url", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(request, response);
		}
		return false;
	}
}
