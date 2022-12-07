package site.metacoding.firstapp.handler.Inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import site.metacoding.firstapp.domain.Admin;
import site.metacoding.firstapp.web.dto.Response.SessionAdmin;
import site.metacoding.firstapp.web.dto.Response.SessionUsers;

@Component
public class AdminAuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("디버그 :  일반 관리자 인터셉터");

		// url요청의 {id}
		String uri = request.getRequestURI();
		String[] uriArray = uri.split("/");
		int reqId = Integer.parseInt(uriArray[uriArray.length - 1]);
		System.out.println("디버그 : " + reqId);

		// 세션의 id
		HttpSession session = request.getSession();
		Admin sessionAdmin = (Admin) session.getAttribute("principal");
		int sessionAdminId = sessionAdmin.getId();

		// 업데이트 보여주기
		String httpMethod = request.getMethod();
		if (httpMethod.equals("POST") || httpMethod.equals("GET")) {
			if (reqId == sessionAdminId) {
				System.out.println("디버그 : " + "AdminAuth 인터셉터 통과");
				return true;
			}
			throw new RuntimeException("권한이 없습니다.");
		}

		return true;
	}
}
