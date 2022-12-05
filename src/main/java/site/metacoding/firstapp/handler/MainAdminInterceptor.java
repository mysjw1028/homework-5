package site.metacoding.firstapp.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import site.metacoding.firstapp.web.dto.Response.SessionUsers;

public class MainAdminInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		SessionUsers sessionUser = (SessionUsers) session.getAttribute("principal");

		String httpMethod = request.getMethod();
		if (httpMethod.equals("POST") || httpMethod.equals("GET")) {
			if (sessionUser != null) {
				if (sessionUser.getRole.equals("중앙 관리자")) {
					return true;
				}
				throw new RuntimeException("권한이 없습니다.");
			}
			throw new RuntimeException("로그인이 필요합니다.");
		}

		return false;
	}
}
