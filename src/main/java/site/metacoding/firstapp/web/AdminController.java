package site.metacoding.firstapp.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.Service.AdminService;
import site.metacoding.firstapp.domain.Admin;

import site.metacoding.firstapp.web.dto.CMRespDto;
import site.metacoding.firstapp.web.dto.request.admin.AdminJoinDto;
import site.metacoding.firstapp.web.dto.request.admin.AdminLoginDto;

@RequiredArgsConstructor
@Controller
public class AdminController {
	private final AdminService adminService;
	private final HttpSession session;

	@GetMapping("/admin/join") // 화면 출력되는지 확인 완료
	public String adminjoin() {
		return "admin/adminjoin";
	}

	@PostMapping("/admin/join")
	public @ResponseBody CMRespDto<?> 관리자회원가입(@RequestBody AdminJoinDto adminJoinDto) {
		// 테스트할때 디비 / Dao /Dto 확인 후 값이 안들어가면 view name이 엔티티랑 같은지 확인하기!
		adminService.관리자회원가입(adminJoinDto);
		System.out.println("관리자회원가입 : " + adminJoinDto.getAdminName());
		System.out.println("관리자회원가입 : " + adminJoinDto.getPassword());
		System.out.println("관리자회원가입 : " + adminJoinDto.getRole());
		return new CMRespDto<>(1, "일반 회원가입 성공", null);
	}// 디비에 값 들어가는거 확인 완료

	@GetMapping("/admin/login") // 화면 출력되는지 확인 완료
	public String acminlogin(Model model, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("adminName")) {
				model.addAttribute(cookie.getName(), cookie.getValue());
			}
		}
		return "admin/adminlogin";

	}

	@PostMapping("/admin/login")
	public @ResponseBody CMRespDto<?> 관리자로그인(@RequestBody AdminLoginDto adminLoginDto, HttpServletResponse response) {// 로그인
		System.out.println("===========");
		System.out.println("컨트롤러 : 실행됨!!!!");
		System.out.println("컨트롤러 : " + adminLoginDto.getAdminName());
		System.out.println("컨트롤러 " + adminLoginDto.getPassword());
		System.out.println("컨트롤러 : " + adminLoginDto.isRemember());
		System.out.println("컨트롤러 : 실행됨!!!!");
		System.out.println("===========");
		System.out.println("컨트롤러 : 실행됨!!!!");
		if (adminLoginDto.isRemember()) {
			System.out.println("===========");
			System.out.println("컨트롤러 : 실행됨!!!!");
			Cookie cookie = new Cookie("adminName", adminLoginDto.getAdminName()); // 실행안됨
			cookie.setMaxAge(60 * 60 * 24);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("adminName", null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		Admin principal = adminService.로그인(adminLoginDto);
		if (principal == null) {
			return new CMRespDto<>(-1, "로그인실패", null);
		}
		session.setAttribute("principal", principal);
		return new CMRespDto<>(1, "로그인성공", null);
	}

}
