package site.metacoding.firstapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.Service.UsersService;
import site.metacoding.firstapp.domain.Users;
import site.metacoding.firstapp.domain.UsersDao;
import site.metacoding.firstapp.web.dto.CMRespDto;
import site.metacoding.firstapp.web.dto.LoginRespDto;
import site.metacoding.firstapp.web.dto.request.users.JoinDto;
import site.metacoding.firstapp.web.dto.request.users.LoginDto;

@RequiredArgsConstructor
@Controller
public class UsersController {
	private final UsersService usersService;
	private final HttpSession session;
	private final UsersDao usersDao;

	@GetMapping("/join") // 화면 출력되는지 확인 완료
	public String join() {
		return "users/join";
	}

	@PostMapping("/join/insert")
	public @ResponseBody CMRespDto<?> 회원가입(@RequestBody JoinDto joinDto) {
		// 테스트할때 디비 / Dao /Dto 확인 후 값이 안들어가면 view name이 엔티티랑 같은지 확인하기!
		usersService.일반회원가입(joinDto);
		System.out.println(joinDto.getUserName());
		System.out.println(joinDto.getPassword());
		System.out.println(joinDto.getRole());
		return new CMRespDto<>(1, "일반 회원가입 성공", null);
	}// 디비에 값 들어가는거 확인 완료

	@GetMapping("/login") // 화면 출력되는지 확인 완료
	public String login() {
		return "users/login";
	}

	@PostMapping("/login")
	public String 로그인(LoginDto loginDto) {// 로그인 / xml에 쿼리 있는지 확인 / login jsp name 확인하기
		Users users = usersDao.login(loginDto);
		if (users == null) {
			return "users/login";
		}
		LoginRespDto loginRespDto = new LoginRespDto(users);
		session.setAttribute("principal", loginRespDto);
		return "redirect:/";// "redirect:/" 이거를 사용해야 화면이 보여진다.
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
