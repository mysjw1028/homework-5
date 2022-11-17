package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.MainAdmin;
import site.metacoding.firstapp.domain.MainAdminDao;

@RequiredArgsConstructor
@Controller
public class MainAdminController {

	private final MainAdminDao mainAdminDao;

	@GetMapping("/Mainadmin/joinpage")
	public String mainadminjoin() {
		return "mainadmin/mainadminjoin";// 회원가입시 중앙관리자 패스워드 번호를 if 문 돌려서 4567아니면 메인 페이지로 이동
	}

	@PostMapping("/Mainadmin/joinpage/insert")
	public String 중앙관리자회원가입(MainAdmin mainAdmin) {// 로그인시 중앙관리자 패스워드 번호를 if 문 돌려서 4567아니면 구매자 / 일반관리자 페이지로 이동
		mainAdminDao.insert(mainAdmin);
		return "mainadmin/mainadminlogin";
	}

	@GetMapping("/Mainadmin/loginpage")
	public String mainadminlogin() {// 주소창 입력시 화면에 출력
		return "mainadmin/mainadminlogin";// 로그인시 중앙관리자 패스워드 번호를 if 문 돌려서 4567아니면 구매자 / 일반관리자 페이지로 이동
	}

	@PostMapping("/Mainadmin/loginpage")
	public String 중앙관리자로그인() {
		return "mainadmin/mainadminlogin";// 로그인시 중앙관리자 패스워드 번호를 if 문 돌려서 4567아니면 구매자 / 일반관리자 페이지로 이동
	}

	@GetMapping("/Mainadmin/userlist")
	public String userlist() {// 주소창 입력시 화면에 출력
		return "mainadmin/userlist";
	}
}
