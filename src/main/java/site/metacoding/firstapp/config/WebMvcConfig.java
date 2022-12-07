package site.metacoding.firstapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import site.metacoding.firstapp.handler.Inteceptor.AdminAuthInterceptor;
import site.metacoding.firstapp.handler.Inteceptor.MainAdminAuthInterceptor;
import site.metacoding.firstapp.handler.Inteceptor.RoleInterceptor;
import site.metacoding.firstapp.handler.Inteceptor.UsersAuthInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UsersAuthInterceptor()).addPathPatterns("/s/user/**")// 포함하고
				.addPathPatterns("/s/buy/**");
		registry.addInterceptor(new AdminAuthInterceptor()).addPathPatterns("/s/admin/**")
				.addPathPatterns("/s/product/**");

		registry.addInterceptor(new MainAdminAuthInterceptor()).addPathPatterns("/s/Mainadmin/**")
				.addPathPatterns("/s/product/**").excludePathPatterns("/s/Mainadmin/userlist/**")
				.excludePathPatterns("/s/Mainadmin/adminlist/**");
		// 권한이 없다고 계속 나와서 예외로 뺌 (excludePathPatterns -> 예외로 빼는것)

	}

}
