package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainAdminController {
	@GetMapping("/Mainadmin/joinpage") // 화면 출력되는지 확인 완료
	public String mainadminjoin() {
		return "mainadmin/mainadminjoin";//회원가입시 중앙관리자 패스워드 번호를 if 문 돌려서 4567아니면 메인 페이지로 이동
	}

	@GetMapping("/Mainadmin/loginpage") // 화면 출력되는지 확인 완료
	public String mainadminlogin() {// 주소창 입력시 화면에 출력
		return "mainadmin/mainadminlogin";//로그인시 중앙관리자 패스워드 번호를 if 문 돌려서 4567아니면 구매자 / 일반관리자 페이지로 이동
	}
	
	@GetMapping("/Mainadmin/userlist") // 화면 출력되는지 확인 완료
	public String userlist() {// 주소창 입력시 화면에 출력
		return "mainadmin/userlist";
	}
}
