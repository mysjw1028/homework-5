package site.metacoding.firstapp.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import site.metacoding.firstapp.handler.ex.AdminInterceptor;
import site.metacoding.firstapp.handler.ex.MainAdminInterceptor;
import site.metacoding.firstapp.handler.ex.UserInterceptor;

public class WebMvcConfig implements WebMvcConfigurer {

	public void addInterceptorsUser(InterceptorRegistry registry) {
		registry.addInterceptor(new UserInterceptor()).addPathPatterns("/s/**");
	}

	public void addInterceptorsAdmin(InterceptorRegistry registry) {
		registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/ad/**");
	}

	public void addInterceptorsMainAdmin(InterceptorRegistry registry) {
		registry.addInterceptor(new MainAdminInterceptor()).addPathPatterns("/md/**");
	}
}
