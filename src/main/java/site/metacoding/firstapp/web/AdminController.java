package site.metacoding.firstapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Admin;
import site.metacoding.firstapp.domain.AdminDao;
import site.metacoding.firstapp.web.dto.LoginRespDto;
import site.metacoding.firstapp.web.dto.request.admin.AdminLoginDto;

@RequiredArgsConstructor
@Controller
public class AdminController {
	private final HttpSession session;
	private final AdminDao adminDao;

	@GetMapping("/admin/join") // 화면 출력되는지 확인 완료
	public String adminjoin() {
		return "admin/adminjoin";
	}

	@PostMapping("/admin/join/insert")
	public String 관리자회원가입(Admin admin) {
		// 테스트할때 디비 / Dao /Dto 확인 후 값이 안들어가면 view name이 엔티티랑 같은지 확인하기!
		System.out.println(admin.getAdminName());
		adminDao.insert(admin);
		System.out.println(admin.getAdminName());
		return "redirect:/";
	}// 완료

	@GetMapping("/admin/login") // 화면 출력되는지 확인 완료
	public String adminlogin() {// 주소창 입력시 화면에 출력
		return "users/login";
	}

	@PostMapping("/admin/login")
	public String 관리자로그인(AdminLoginDto adminLoginDto) {// 로그인 / xml에 쿼리 있는지 확인 / login jsp name 확인하기
		LoginRespDto loginRespDto = new LoginRespDto(adminDao.login(adminLoginDto));
		System.out.println("==============================");
		System.out.println(loginRespDto.getAdminName());
		System.out.println("==============================");
		session.setAttribute("principal", loginRespDto);
		if (loginRespDto != null) {
			return "redirect:/";// model를 사용 했을때 "redirect:/" 이거를 사용해야 화면이 보여진다.
		} else {// 인증실패하면
			return "admin/login";
		}
	}

}
