package site.metacoding.firstapp.handler.Inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import site.metacoding.firstapp.web.dto.Response.SessionUsers;


@Component
public class MainAdminAuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// url요청의 {id}
		String uri = request.getRequestURI();//아이디값이 = 세션아이디값이 같도록 
		String[] uriArray = uri.split("/");
		int mainadminId = Integer.parseInt(uriArray[uriArray.length - 1]);
		System.out.println("디버그 : " + mainadminId);

		// 세션의 id
		HttpSession session = request.getSession();
		SessionUsers sessionUser = (SessionUsers) session.getAttribute("sessionUser");
		int sessionUserId = sessionUser.getId();

		// 업데이트 보여주기
		String httpMethod = request.getMethod();
		if (httpMethod.equals("POST") || httpMethod.equals("GET")) {
			if (mainadminId == sessionUserId) {
				System.out.println("디버그 : " + "MainAdminAuth 인터셉터 통과");
				return true;
			}
			throw new RuntimeException("권한이 없습니다.");
		}

		return true;
	}
}
