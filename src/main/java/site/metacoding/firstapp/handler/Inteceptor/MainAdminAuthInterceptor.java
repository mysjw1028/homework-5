package site.metacoding.firstapp.handler.Inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.MainAdmin;
import site.metacoding.firstapp.web.dto.Response.SessionMainAdmin;
import site.metacoding.firstapp.web.dto.Response.SessionUsers;

@Component
public class MainAdminAuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("===========================================");
		System.out.println("MainAdminAuthInterceptor시작!!");
		System.out.println("디버그 :  중앙관리자 인터셉터");

		// url요청의 {id}
		String uri = request.getRequestURI();// 아이디값이 = 세션아이디값이 같도록
		String[] uriArray = uri.split("/");
		System.out.println(uriArray.length);
		System.out.println("주소 위치 변경" + uriArray[uriArray.length - 1]);
		int reqId = Integer.parseInt(uriArray[uriArray.length - 1]);
		System.out.println("디버그 : " + reqId);

		// 세션의 id
		HttpSession session = request.getSession();

		MainAdmin sessionMainadmin = (MainAdmin) session.getAttribute("principal");

		int sessionMainAdminId = sessionMainadmin.getId();
		System.out.println("디버그 : " + sessionMainAdminId);
		// 업데이트 보여주기
		String httpMethod = request.getMethod();
		if (httpMethod.equals("POST") || httpMethod.equals("GET")) {
			if (reqId == sessionMainAdminId) {
				System.out.println("디버그 : " + "MainAdminAuth 인터셉터 통과");
				return true;
			}
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			throw new RuntimeException("권한이 없습니다.");
		}

		return true;
	}

}
