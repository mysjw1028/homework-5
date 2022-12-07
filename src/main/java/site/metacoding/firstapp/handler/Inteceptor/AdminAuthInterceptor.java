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
		System.out.println("===========================================");
		System.out.println("AdminAuthInterceptor시작!!");
		System.out.println("디버그 :  일반 관리자 인터셉터");


		// url요청의 {id}
		String uri = request.getRequestURI();

		
		String[] uriArray = uri.split("/");
		String reqId = "/s/product/insert";
		System.out.println("위치  " + uriArray[uriArray.length - 1]);
		reqId.split(reqId);
		
		System.out.println("디버그 : " + reqId);

		// 세션의 id
		HttpSession session = request.getSession();
		Admin sessionAdmin = (Admin) session.getAttribute("principal");
		int sessionAdminId = sessionAdmin.getId();
		System.out.println("디버그 : " + sessionAdminId);

		// 업데이트 보여주기
		String httpMethod = request.getMethod();
		if (httpMethod.equals("POST") || httpMethod.equals("GET")) {
	
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			throw new RuntimeException("권한이 없습니다.");
		}

		return true;
	}
}
