package site.metacoding.firstapp.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Admin;
import site.metacoding.firstapp.domain.AdminDao;
import site.metacoding.firstapp.domain.MainAdmin;
import site.metacoding.firstapp.domain.MainAdminDao;
import site.metacoding.firstapp.web.dto.LoginRespDto;

import site.metacoding.firstapp.web.dto.request.mainadmin.AdminListDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.MainAdminLoginDto;

@RequiredArgsConstructor
@Controller
public class MainAdminController {
	private final HttpSession session;
	private final MainAdminDao mainAdminDao;
	private final AdminDao adminDao;

	@GetMapping("/Mainadmin/joinpage")
	public String mainadminjoin() {
		return "mainadmin/mainadminjoin";// 회원가입시 중앙관리자 패스워드 번호를 if 문 돌려서 4567아니면 메인 페이지로 이동
	}

	@PostMapping("/Mainadmin/joinpage/insert")
	public String 중앙관리자회원가입(MainAdmin mainAdmin) {// 로그인시 중앙관리자 패스워드 번호를 if 문 돌려서 4567아니면 구매자 / 일반관리자 페이지로 이동
		if (mainAdmin.getPasswordMainadmin().equals("5678")) {// String은 객체여서 equals("비교값")로 비교해야 한다.
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
		MainAdmin mainAdmin = mainAdminDao.login(mainAdminLoginDto);
		if (mainAdmin == null) {
			return "mainadmin/mainadminlogin";
		}
		LoginRespDto loginRespDto = new LoginRespDto(mainAdmin);
		session.setAttribute("principal", loginRespDto);
		return "redirect:/";
	}
	// 회원가입하면서 중앙관리자 체크함
	// mainAdminLoginDto이 null이니까 LoginRespDto에 값을 넣어줄때 mainAdmin이 null일때
	// maindamin.get... 메서드가 생성자체가 되지 않았고 그러므로 업는 값이라고 나타남

	@GetMapping("/Mainadmin/adminlist/{id}")
	public String adminlist(@PathVariable Integer id, Model model) {// 주소창 입력시 화면에 출력
		// 아이디를 받기 // 리스트에 담고
		List<AdminListDto> adminList = mainAdminDao.adminList(id);
		for (AdminListDto e : adminList = mainAdminDao.adminList(id)) {
			System.out.println(e.getId());
		}
		model.addAttribute("admin", adminList);
		return "mainadmin/adminlist";
	}

	@PostMapping("/Mainadmin/adminlist/{id}/delete")
	public String 관리자삭제(@PathVariable Integer id, AdminListDto adminListDto) {
		System.out.println("디버그: " + adminListDto.getAdminName());
		mainAdminDao.deleteById(id);
		adminDao.deleteById(id);
		return "redirect:/";
	}

	@PostMapping("/Mainadmin/adminlist/{adminId}/edit")
	public String 관리자정보수정(@PathVariable Integer adminId, Admin admin) {
		Admin adminPS = adminDao.findById(adminId);
		adminPS.update(admin);
		adminDao.update(adminPS);
		return "redirect:/";
	}

	@GetMapping("/Mainadmin/adminlist/{adminId}/edit")
	public String adminedit(@PathVariable Integer adminId, Model model) {
		Admin adminPS = adminDao.findById(adminId);
		model.addAttribute("admin", adminPS);
		System.out.println(adminId);
		return "mainadmin/adminupdate";
	}

	@GetMapping("/Mainadmin/userlist")
	public String userlist() {// 주소창 입력시 화면에 출력
		return "mainadmin/userlist";
	}
}
