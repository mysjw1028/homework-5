package site.metacoding.firstapp.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.Service.MainAdminService;
import site.metacoding.firstapp.domain.Admin;
import site.metacoding.firstapp.domain.AdminDao;
import site.metacoding.firstapp.domain.MainAdmin;
import site.metacoding.firstapp.domain.MainAdminDao;
import site.metacoding.firstapp.domain.Users;
import site.metacoding.firstapp.domain.UsersDao;
import site.metacoding.firstapp.web.dto.CMRespDto;
import site.metacoding.firstapp.web.dto.LoginRespDto;

import site.metacoding.firstapp.web.dto.request.mainadmin.AdminListDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.AdminUpdateDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.MainAdminJoinDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.MainAdminLoginDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.UsersListDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.UsersUpdateDto;

@RequiredArgsConstructor
@Controller
public class MainAdminController {
	private final HttpSession session;
	private final MainAdminDao mainAdminDao;
	private final MainAdminService mainAdminService;
	private final AdminDao adminDao;
	private final UsersDao usersDao;

	@GetMapping("/Mainadmin/joinpage")
	public String mainadminjoin() {
		return "mainadmin/mainadminjoin";// 회원가입시 중앙관리자 패스워드 번호를 if 문 돌려서 4567아니면 메인 페이지로 이동
	}

	@PostMapping("/Mainadmin/joinpage/insert")
	public @ResponseBody CMRespDto<?> 중앙관리자회원가입(@RequestBody MainAdminJoinDto mainAdminJoinDto) {
		if (mainAdminJoinDto.getPasswordMainadmin().equals("5678")) {// String은 객체여서 equals("비교값")로 비교해야 한다.
			mainAdminService.중앙관리자회원가입(mainAdminJoinDto);
			System.out.println("중앙관리자 회원가입 : " + mainAdminJoinDto.getMainadminName());
			System.out.println("중앙관리자 회원가입 : " + mainAdminJoinDto.getPassword());
			System.out.println("중앙관리자 회원가입 : " + mainAdminJoinDto.getPasswordMainadmin());
			return new CMRespDto<>(1, "중앙관리자회원가입 성공", null);

		} else {
			return new CMRespDto<>(0, "중앙관리자회원가입 실패", null);
		}
		// 로그인시 중앙관리자 패스워드 번호를 if 문 돌려서 4567아니면 구매자 / 일반관리자 페이지로 이동
	}// 회원가입시 PasswordMainadmin에 5678을 넣지 않으면 가입불가

	@GetMapping("/join/MainAdminNameCheck")
	public @ResponseBody CMRespDto<Boolean> MainAdminNameSameCheck(String MainAdminName) {
		boolean isSame = mainAdminService.중앙관리자중복체크(MainAdminName);
		return new CMRespDto<>(1, "성공", isSame);
	}

	@GetMapping("/mainadmin/loginpage")
	public String mainadminlogin() {// 주소창 입력시 화면에 출력
		return "mainadmin/mainadminlogin";
	}

	@PostMapping("/Mainadmin/loginpage")
	public String 중앙관리자로그인(MainAdminLoginDto mainAdminLoginDto) {
		MainAdmin mainAdmin = mainAdminDao.login(mainAdminLoginDto);
		System.out.println("중앙관리자 로그인 : " + mainAdminLoginDto.getMainadminName());
		System.out.println("중앙관리자 로그인 : " + mainAdminLoginDto.getPassword());
		System.out.println("중앙관리자 로그인 : " + mainAdminLoginDto.getPasswordMainadmin());
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

	@GetMapping("/Mainadmin/join/MainadminNameCheck")
	public @ResponseBody CMRespDto<Boolean> adminameSameCheck(String MainAdminName) {
		boolean isSame = mainAdminService.중앙관리자중복체크(MainAdminName);
		return new CMRespDto<>(1, "성공", isSame);
	}

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

	@PostMapping("/Mainadmin/adminlist/{adminId}/delete") // 변수랑 주소명 좀 맞춰라 ;;
	public String 관리자삭제(@PathVariable Integer adminId) {
		Admin adminPS = adminDao.findById(adminId);
		adminDao.deleteById(adminId);
		return "redirect:/";
	}

	@PostMapping("/Mainadmin/adminlist/{adminId}/edit")
	public String 관리자정보수정(@PathVariable Integer adminId, AdminUpdateDto adminUpdateDto) {
		mainAdminService.관리자정보수정(adminId, adminUpdateDto);
		return "redirect:/";
	}

	@GetMapping("/Mainadmin/adminlist/{adminId}/edit")
	public String adminedit(@PathVariable Integer adminId, Model model) {
		Admin adminPS = adminDao.findById(adminId);
		model.addAttribute("admin", adminPS);
		return "mainadmin/adminupdate";
	}

	@GetMapping("/Mainadmin/userlist/{id}")
	public String userslist(@PathVariable Integer id, Model model) {// 주소창 입력시 화면에 출력
		List<UsersListDto> userslist = mainAdminDao.usersList(id);
		for (UsersListDto e : userslist = mainAdminDao.usersList(id)) {
			System.out.println(e.getId());
		}
		model.addAttribute("users", userslist);
		return "mainadmin/userlist";
	}

	@PostMapping("/Mainadmin/userlist/{id}/delete") // 변수랑 주소명 좀 맞춰라 ;;
	public String 구매자삭제(@PathVariable Integer id) {
		Users usersPS = usersDao.findById(id);
		usersDao.deleteById(id);
		return "redirect:/";
	}

	@PostMapping("/Mainadmin/userlist/{id}/edit")
	public String 구매자정보수정(@PathVariable Integer id, UsersUpdateDto usersUpdateDto) {
		Users usersPS = usersDao.findById(id);
		mainAdminService.구매자정보수정(id, usersUpdateDto);
		return "redirect:/";
	}

	@GetMapping("/Mainadmin/userlist/{id}/edit")
	public String usersedit(@PathVariable Integer id, Model model) {
		Users usersPS = usersDao.findById(id);
		model.addAttribute("users", usersPS);
		return "mainadmin/userupdate";
	}

}
