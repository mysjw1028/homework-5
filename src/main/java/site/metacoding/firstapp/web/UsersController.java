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
import site.metacoding.firstapp.domain.Users;
import site.metacoding.firstapp.service.UsersService;
import site.metacoding.firstapp.web.dto.CMRespDto;
import site.metacoding.firstapp.web.dto.request.users.JoinDto;
import site.metacoding.firstapp.web.dto.request.users.LoginDto;

@RequiredArgsConstructor
@Controller
public class UsersController {
	private final UsersService usersService;
	private final HttpSession session;

	@GetMapping("/joinForm") // 화면 출력되는지 확인 완료
	public String join() {
		return "users/join";
	}

	@PostMapping("/join/insert")
	public @ResponseBody CMRespDto<?> 회원가입(@RequestBody JoinDto joinDto) {
		// 테스트할때 디비 / Dao /Dto 확인 후 값이 안들어가면 view name이 엔티티랑 같은지 확인하기!

		if (joinDto.getUserName() == null || joinDto.getUserName().isEmpty()) {
			System.out.println("유저이름 " + joinDto.getUserName());
			System.out.println("막음!");
			return new CMRespDto<>(-1, "회원가입 실패", null);
		}
		if (joinDto.getPassword() == null || joinDto.getPassword().isEmpty()) {
			System.out.println("비밀번호  " + joinDto.getPassword());
			System.out.println("막음!");
			return new CMRespDto<>(-1, "회원가입 실패", null);
		}
		if (joinDto.getEmail() == null || joinDto.getEmail().isEmpty()) {
			System.out.println("이메일 " + joinDto.getEmail());
			System.out.println("막음!");
			return new CMRespDto<>(-1, "회원가입 실패", null);
		}
		if (joinDto != null) {
			System.out.println("==============성공시======================");
			System.out.println(joinDto.getUserName());
			System.out.println(joinDto.getPassword());
			System.out.println(joinDto.getEmail());
			System.out.println("==============성공시======================");
			usersService.일반회원가입(joinDto);
		}
		return new CMRespDto<>(1, "일반 회원가입 성공", null);

	}// role은 DB에 디폴트로 일반 회원으로 들어가서 null이 나온다.

	@GetMapping("/loginForm") // 화면 출력되는지 확인 완료
	public String login(Model model, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("userName")) {
				model.addAttribute(cookie.getName(), cookie.getValue());
			}
		}
		return "users/login";
	}

	@PostMapping("/login")
	public @ResponseBody CMRespDto<?> 로그인(@RequestBody LoginDto loginDto, HttpServletResponse response) {// 로그인 / xml에
		if (loginDto.isRemember()) {
			Cookie cookie = new Cookie("userName", loginDto.getUserName());
			cookie.setMaxAge(60 * 60 * 24);// 쿠키 시간 설정
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("userName", null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		Users principal = usersService.로그인(loginDto);
		if (principal == null) {
			return new CMRespDto<>(-1, "로그인실패", null);
		}
		session.setAttribute("principal", principal);
		return new CMRespDto<>(1, "로그인성공", null);
	}

	@GetMapping("/logout") // 화면 출력되는지 확인 완료
	public String loginout() {
		session.invalidate();// 로그아웃 -> 화면은 따로 필요없다
		return "redirect:/";
	}

	@GetMapping("/join/userNameCheck")
	public @ResponseBody CMRespDto<Boolean> usersNameSameCheck(String userName) {
		boolean isSame = usersService.아이디중복체크(userName);
		return new CMRespDto<>(1, "성공", isSame);
	}

}