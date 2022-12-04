package site.metacoding.firstapp.web;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	private final AdminDao adminDao;
	private final UsersDao usersDao;
	private final MainAdminService mainAdminService;

	@GetMapping("/Mainadmin/joinpage")
	public String mainadminjoin() {
		return "mainadmin/mainadminjoin";// 회원가입시 중앙관리자 패스워드 번호를 if 문 돌려서 4567아니면 메인 페이지로 이동
	}

	@PostMapping("/Mainadmin/joinpage/insert") // String은 객체여서 equals("비교값")로 비교해야 한다.
	public @ResponseBody CMRespDto<?> 중앙관리자회원가입(@RequestBody MainAdminJoinDto mainAdminJoinDto) {
		if (mainAdminJoinDto.getMainadminName() == null || mainAdminJoinDto.getMainadminName().equals("")) {
			System.out.println("중앙관리자 이름 " + mainAdminJoinDto.getMainadminName());
			System.out.println("막음!");
			return new CMRespDto<>(-1, "중앙관리자회원가입 실패", null);
		}
		if (mainAdminJoinDto.getPassword() == null || mainAdminJoinDto.getPassword().isEmpty()) {
			System.out.println("중앙관리자 비밀번호 " + mainAdminJoinDto.getPassword());
			System.out.println("막음!");
			return new CMRespDto<>(-1, "중앙관리자회원가입 실패", null);
		}

		if (mainAdminJoinDto.getPasswordMainadmin() == null || mainAdminJoinDto.getPasswordMainadmin().isEmpty()) {
			System.out.println("중앙관리자 중앙관리자비밀번호 " + mainAdminJoinDto.getPasswordMainadmin());
			System.out.println("막음!!");
			return new CMRespDto<>(-1, "중앙관리자회원가입 실패", null);
		}
		if (mainAdminJoinDto.getPasswordMainadmin() == null || mainAdminJoinDto.getPasswordMainadmin().equals("5678")
				|| mainAdminJoinDto.getPasswordMainadmin().isEmpty()) {
			System.out.println("중앙관리자 전용 비밀번호" + mainAdminJoinDto.getPasswordMainadmin());
			System.out.println("막음!");
		}
		System.out.println("이멜 실행됨!!!!!!!!!!!!");
		if (mainAdminJoinDto.getEmail() == null || mainAdminJoinDto.getEmail().isEmpty()) {
			System.out.println("중앙관리자 이메일" + mainAdminJoinDto.getEmail());
			System.out.println("막음!");
			return new CMRespDto<>(-1, "중앙관리자회원가입 실패", null);
		}
		if (mainAdminJoinDto != null) {
			System.out.println("==============성공시======================");
			System.out.println(mainAdminJoinDto.getMainadminName());
			System.out.println(mainAdminJoinDto.getPassword());
			System.out.println(mainAdminJoinDto.getPasswordMainadmin());
			System.out.println(mainAdminJoinDto.getEmail());
			System.out.println("==============성공시======================");
			mainAdminService.중앙관리자회원가입(mainAdminJoinDto);
		}
		return new CMRespDto<>(1, "관리자회원가입 성공", null);
	}

	// 로그인시 중앙관리자 패스워드 번호를 if 문 돌려서 4567아니면 구매자 / 일반관리자 페이지로 이동// 회원가입시
	// PasswordMainadmin에 5678을 넣지 않으면 가입불가

	@GetMapping("/join/MainAdminNameCheck")
	public @ResponseBody CMRespDto<Boolean> MainAdminNameSameCheck(String MainAdminName) {
		boolean isSame = mainAdminService.중앙관리자중복체크(MainAdminName);
		return new CMRespDto<>(1, "성공", isSame);
	}

	@GetMapping("/mainadmin/loginpage")
	public String mainadminlogin(Model model, HttpServletRequest request) {// 주소창 입력시 화면에 출력
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("mainadminName")) {
				model.addAttribute(cookie.getName(), cookie.getValue());
			}
		}
		return "mainadmin/mainadminlogin";
	}

	@PostMapping("/mainadmin/loginpage")
	public @ResponseBody CMRespDto<?> 중앙관리자로그인(@RequestBody MainAdminLoginDto mainAdminLoginDto,
			HttpServletResponse response) {

		if (mainAdminLoginDto.isRemember()) {
			Cookie cookie = new Cookie("mainadminName", mainAdminLoginDto.getMainadminName());
			cookie.setMaxAge(60 * 60 * 24);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("mainadminName", null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		MainAdmin principal = mainAdminService.중앙관관리자로그인(mainAdminLoginDto);
		if (principal == null) {
			return new CMRespDto<>(-1, "로그인실패", null);
		}
		session.setAttribute("principal", principal);
		return new CMRespDto<>(1, "로그인성공", null);
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
	public @ResponseBody CMRespDto<?> 관리자정보수정(@PathVariable Integer adminId,
			@RequestBody AdminUpdateDto adminUpdateDto) {
		if (adminUpdateDto.getAdminName() == null || adminUpdateDto.getAdminName().isEmpty()) {
			System.out.println("이름 : " + adminUpdateDto.getAdminName());
			System.out.println("실패!");
			return new CMRespDto<>(-1, "구매자정보수정실패", null);
		} else if (adminUpdateDto.getEmail() == null || adminUpdateDto.getEmail().equals("")) {
			System.out.println(" 이메일변경  : " + adminUpdateDto.getEmail());
			System.out.println("실패!");
			return new CMRespDto<>(-1, "구매자정보수정 실패", null);
		}
		mainAdminService.관리자정보수정(adminId, adminUpdateDto);
		System.out.println("===========성공시================");
		System.out.println(adminUpdateDto.getAdminName());
		System.out.println(adminUpdateDto.getEmail());
		System.out.println("===============성공시========");
		return new CMRespDto<>(1, "구매자정보수정 성공", null);
	}

	@GetMapping("/Mainadmin/adminlist/{id}/edit")
	public String adminedit(@PathVariable Integer id, Model model) {
		Admin adminPS = adminDao.findById(id);
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
	public @ResponseBody CMRespDto<?> 구매자정보수정(@PathVariable Integer id, @RequestBody UsersUpdateDto usersUpdateDto) {

		if (usersUpdateDto.getUserName() == null || usersUpdateDto.getUserName().isEmpty()) {
			System.out.println("이름 : " + usersUpdateDto.getUserName());
			System.out.println("실패!");
			return new CMRespDto<>(-1, "구매자정보수정실패", null);

		} else if (usersUpdateDto.getEmail() == null || usersUpdateDto.getEmail().equals("")) {
			System.out.println(" 이메일변경  : " + usersUpdateDto.getEmail());
			System.out.println("실패!");
			return new CMRespDto<>(-1, "구매자정보수정 실패", null);

		}
		mainAdminService.구매자정보수정(id, usersUpdateDto);
		System.out.println("===========성공시================");
		System.out.println(usersUpdateDto.getUserName());
		System.out.println(usersUpdateDto.getEmail());
		System.out.println("===============성공시========");
		return new CMRespDto<>(1, "구매자정보수정 성공", null);
	}

//		  Users usersPS = usersDao.findById(id); mainAdminService.구매자정보수정(id,
//		  usersUpdateDto); if (id == null || id.equals("")) { return
//		  "mainadmin/userupdate"; } if (usersUpdateDto.getUserName() == null ||
//		  usersUpdateDto.getUserName().isEmpty()) { return "mainadmin/userupdate"; } if
//		  (usersUpdateDto.getEmail() == null || usersUpdateDto.getEmail().isEmpty()) {
//		  return "mainadmin/userupdate"; } return "redirect:/";
//		

	@GetMapping("/Mainadmin/userlist/{id}/edit")
	public String usersedit(@PathVariable Integer id, Model model) {
		Users usersPS = usersDao.findById(id);
		model.addAttribute("users", usersPS);
		return "mainadmin/userupdate";
	}

}
