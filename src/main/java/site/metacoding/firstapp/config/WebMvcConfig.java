package site.metacoding.firstapp.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class WebMvcConfig implements WebMvcConfigurer {

	public void addInterceptorsUser(InterceptorRegistry registry) {
	}
}
// 같은 주소 사용해서 세션으로 구분
