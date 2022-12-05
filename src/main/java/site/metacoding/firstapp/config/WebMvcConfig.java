package site.metacoding.firstapp.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import site.metacoding.firstapp.handler.UserInterceptor;

public class WebMvcConfig implements WebMvcConfigurer {

	public void addInterceptorsUser(InterceptorRegistry registry) {
		registry.addInterceptor(new UserInterceptor()).addPathPatterns("/s/**");
	}
}
// 같은 주소 사용해서 세션으로 구분
