package site.metacoding.firstapp.handler.Inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import site.metacoding.firstapp.web.dto.Response.SessionUsers;

@Component
public class UsersAuthInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("===========================================");
		System.out.println("UsersAuthInterceptor시작!!");
		System.out.println("디버그 :  구매자 인터셉터");

		String uri = request.getRequestURI();

		String[] uriArray = uri.split("/");// /를 기준으로 잡아서 잘라서 구분을 한다
		int reqId = Integer.parseInt(uriArray[uriArray.length - 1]);
		System.out.println("디버그 : " + reqId);

		HttpSession session = request.getSession();
		SessionUsers sessionUser = (SessionUsers) session.getAttribute("principal");
		System.out.println("=============================");
		System.out.println("디버그 : " +  session.getAttribute("principal"));
		System.out.println("=============================");
		int sessionUserId = sessionUser.getId();
		String httpMethod = request.getMethod();
		if (httpMethod.equals("POST") || httpMethod.equals("GET")) {
			if (reqId == sessionUserId) {
				System.out.println("디버그 : " + "구매자 인터셉터 통과");
				return true;
			}
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);

			throw new RuntimeException("권한이 없습니다.");
		}

		return true;
	}
}
