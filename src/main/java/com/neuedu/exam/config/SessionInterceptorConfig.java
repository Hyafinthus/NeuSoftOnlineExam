package com.neuedu.exam.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.neuedu.exam.interceptor.SessionInterceptor;

@Configuration
public class SessionInterceptorConfig implements WebMvcConfigurer {

	List<String> include = Arrays.asList("/**");
	List<String> exclude = Arrays.asList("/js/**", "/css/**", "/fonts/**", "/img/**",
										"/index.html", "/*login.html",
										"/login/**", "/admin/**", "/personal/**");
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionInterceptor()).addPathPatterns(include).excludePathPatterns(exclude);
	}
	
}
