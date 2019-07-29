package com.neuedu.exam.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("进入PreHandle");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		if (id != null) {
			return true;
		} else {
			System.out.println("拦截");
			response.sendRedirect("/exam/index.html");
			return false;
		}
	}

}
