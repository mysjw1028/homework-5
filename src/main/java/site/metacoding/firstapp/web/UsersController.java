package site.metacoding.firstapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.Service.UsersService;
import site.metacoding.firstapp.domain.ProductDao;
import site.metacoding.firstapp.domain.Users;
import site.metacoding.firstapp.domain.UsersDao;
import site.metacoding.firstapp.web.dto.CMRespDto;
import site.metacoding.firstapp.web.dto.LoginRespDto;
import site.metacoding.firstapp.web.dto.request.users.LoginDto;

@RequiredArgsConstructor
@Controller
public class UsersController {
	private final HttpSession session;
	private final UsersDao usersDao;

	@GetMapping("/join") // 화면 출력되는지 확인 완료
	public String join() {
		return "users/join";
	}

	@PostMapping("/join/insert")
	public String 회원가입(Users users) {
		// 테스트할때 디비 / Dao /Dto 확인 후 값이 안들어가면 view name이 엔티티랑 같은지 확인하기!
		System.out.println(users.getUserName());
		usersDao.insert(users);
		System.out.println(users.getUserName());
		return "redirect:/";
	}// 디비에 값 들어가는거 확인 완료

	@GetMapping("/login") // 화면 출력되는지 확인 완료
	public String login() {
		return "users/login";
	}

	@PostMapping("/login")
	public String 로그인(LoginDto loginDto) {// 로그인 / xml에 쿼리 있는지 확인 / login jsp name 확인하기
		LoginRespDto loginRespDto = new LoginRespDto(usersDao.login(loginDto));
		System.out.println("==============================");
		System.out.println(loginRespDto.getId());
		System.out.println("==============================");
		session.setAttribute("principal", loginRespDto);
	
		if (loginRespDto != null) {
			return "redirect:/";// model를 사용 했을때 "redirect:/" 이거를 사용해야 화면이 보여진다.
		} else {// 인증실패하면
			return "users/login";
		}
	}

	@GetMapping("/logout") // 화면 출력되는지 확인 완료
	public String loginout() {
		session.invalidate();// 로그아웃 -> 화면은 따로 필요없다
		return "redirect:/";
	}
	
	

//	@GetMapping("/join/userNameCheck")
//	public @ResponseBody CMRespDto<?> userNameCheck(String username) {
//		System.out.println("유저 이름 : " + username);
//		boolean isSame = usersService.아이디중복체크(username);
//		return new CMRespDto<>(1, "성공", isSame);
//	}
}
