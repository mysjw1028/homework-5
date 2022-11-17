package site.metacoding.firstapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.MainAdmin;
import site.metacoding.firstapp.domain.MainAdminDao;
import site.metacoding.firstapp.domain.UsersDao;
import site.metacoding.firstapp.web.dto.LoginRespDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.MainAdminLoginDto;
import site.metacoding.firstapp.web.dto.request.users.LoginDto;

@RequiredArgsConstructor
@Controller
public class MainAdminController {
	private final HttpSession session;
	private final MainAdminDao mainAdminDao;
	private final UsersDao usersDao;

	@GetMapping("/Mainadmin/joinpage")
	public String mainadminjoin() {
		return "mainadmin/mainadminjoin";// 회원가입시 중앙관리자 패스워드 번호를 if 문 돌려서 4567아니면 메인 페이지로 이동
	}

	@PostMapping("/Mainadmin/joinpage/insert")
	public String 중앙관리자회원가입(MainAdmin mainAdmin) {// 로그인시 중앙관리자 패스워드 번호를 if 문 돌려서 4567아니면 구매자 / 일반관리자 페이지로 이동
		System.out.println(mainAdmin.getMainadminName());
		System.out.println(mainAdmin.getPasswordMainadmin());
		if (mainAdmin.getPasswordMainadmin().equals("5678")) {
			System.out.println(mainAdmin.getPasswordMainadmin());
			mainAdminDao.insert(mainAdmin);
			return "mainadmin/mainadminlogin";
		} else {
			return "mainadmin/mainadminjoin";
		}
	}// 회원가입시 PasswordMainadmin에 5678을 넣지 않으면 가입불가

	@GetMapping("/mainadmin/loginpage")
	public String mainadminlogin() {// 주소창 입력시 화면에 출력
		return "mainadmin/mainadminlogin";
	}

	@PostMapping("/Mainadmin/loginpage")
	public String 중앙관리자로그인(MainAdminLoginDto mainAdminLoginDto) {
		LoginRespDto loginRespDto = new LoginRespDto(mainAdminDao.login(mainAdminLoginDto));
		session.setAttribute("principal", loginRespDto);
		if (loginRespDto != null) {
			return "redirect:/";
		}
		return "mainadmin/mainadminlogin";// 인증실패하면 다시 로그인해야함
	}// 회원가입하면서 중앙관리자 체크함

	@GetMapping("/Mainadmin/userlist")
	public String userlist() {// 주소창 입력시 화면에 출력
		//@PathVariable Integer userId, Model model
//		model.addAttribute("users", usersDao.findById(userId));
		return "mainadmin/userlist";

	}

	@GetMapping("/Mainadmin/adminlist")
	public String adminlist() {// 주소창 입력시 화면에 출력
		return "mainadmin/adminlist";
	}
}
