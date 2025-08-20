package com.goodee.proj.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.goodee.proj.account.AccountDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminCheckerInterceptor implements HandlerInterceptor {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		if (accountDTO == null || accountDTO.getAdmin() == false) {
			modelAndView.addObject("resultMsg", "권한이 없습니다.");
			modelAndView.addObject("resultIcon", "warning");
			modelAndView.addObject("url", "/");
			modelAndView.setViewName("/common/result");
		}
	}
}
