package site.metacoding.firstapp.handler.Inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import site.metacoding.firstapp.util.Auth;
import site.metacoding.firstapp.util.MultiValueAnnotation;
import site.metacoding.firstapp.web.dto.Response.SessionUsers;

@Component
public class RoleInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("디버그 : " + " ROLE 인터셉터 작동");

		HandlerMethod method = (HandlerMethod) handler; // 요청을 처리할 메서드
		Auth auth = method.getMethodAnnotation(Auth.class); // 어노테이셔 ㄴ값 받아오기
		System.out.println("디버그 : " + auth);
		if (auth == null) {
			System.out.println("====================================");
			System.out.println("디버그 : " + auth);
			System.out.println("====================================");
			return true;
		} // 어노테이션이 없는 경우, 권한 필요 없는 메서드임 => 통과

		// 1. 세션 체크 => 근데 필터로 거르니 체크 안 해도 됨
		HttpSession session = request.getSession();
		

		// 2. 권한 체크
		int role = auth.role(); // 0 일반 1 일반관리자 2중앙 관리자
		SessionUsers test = (SessionUsers) session.getAttribute("sessionUser");
		int sessionUserRole = test.getId();

		if (role == sessionUserRole) {
			System.out.println("디버그 : " + "role 통과");
			return true;
		}

// 위 코드와 다름
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		// response.sendRedirect("HttpServletResponse.SC_BAD_REQUEST");
		throw new RuntimeException("권한이 없습니다.");
	}
}

// Unreachable code -> 도달할수 없는 코드 = > 위 코드에서
//response.sendError(HttpServletResponse.SC_BAD_REQUEST);
//// response.sendRedirect("HttpServletResponse.SC_BAD_REQUEST");
//throw new RuntimeException("권한이 없습니다.");
// 와 같은 코드가 있어서 다음 코드로 실행이 되지 않고 바로 위에서 막혀 버리게 된다.