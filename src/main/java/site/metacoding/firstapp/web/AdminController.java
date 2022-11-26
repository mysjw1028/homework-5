package site.metacoding.firstapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.Service.AdminService;
import site.metacoding.firstapp.domain.Admin;
import site.metacoding.firstapp.domain.AdminDao;
import site.metacoding.firstapp.web.dto.CMRespDto;
import site.metacoding.firstapp.web.dto.LoginRespDto;
import site.metacoding.firstapp.web.dto.request.admin.AdminLoginDto;

@RequiredArgsConstructor
@Controller
public class AdminController {
	private final AdminService adminService;
	private final HttpSession session;
	private final AdminDao adminDao;

	@GetMapping("/admin/join") // 화면 출력되는지 확인 완료
	public String adminjoin() {
		return "admin/adminjoin";
	}

	@PostMapping("/admin/join")
	public String 관리자회원가입(Admin admin) {
		// 테스트할때 디비 / Dao /Dto 확인 후 값이 안들어가면 view name이 엔티티랑 같은지 확인하기!
		adminDao.insert(admin);
		return "redirect:/";
	}// 완료

	@GetMapping("/admin/login") // 화면 출력되는지 확인 완료
	public String adminlogin() {// 주소창 입력시 화면에 출력
		return "users/login";
	}

	@PostMapping("/admin/login")
	public String 관리자로그인(AdminLoginDto adminLoginDto) {// 로그인 / xml에 쿼리 있는지 확인 / login jsp name 확인하기
		Admin admins = adminDao.login(adminLoginDto);
		if (admins == null) {
			return "users/login";
		}
		LoginRespDto loginRespDto = new LoginRespDto(admins);
		session.setAttribute("principal", loginRespDto);
		return "redirect:/";
	}

	@GetMapping("/admin/join/adminNameCheck")
	public @ResponseBody CMRespDto<Boolean> adminameSameCheck(String adminName) {
		System.out.println("아이디 : " + adminName);
		boolean isSame = adminService.관리자중복체크(adminName);
		return new CMRespDto<>(1, "성공", isSame);
	}

}