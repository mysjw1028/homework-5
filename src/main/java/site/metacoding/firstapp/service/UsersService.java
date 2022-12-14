package site.metacoding.firstapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Users;
import site.metacoding.firstapp.domain.UsersDao;
import site.metacoding.firstapp.web.dto.request.users.JoinDto;
import site.metacoding.firstapp.web.dto.request.users.LoginDto;

@RequiredArgsConstructor
@Service
public class UsersService {
	private final UsersDao usersDao;

	@Transactional(rollbackFor = RuntimeException.class)
	public void 일반회원가입(JoinDto joinDto) {
		Users users = joinDto.toEntity();
		usersDao.insert(users);
	}// 컨트롤러가 일 안함

	public boolean 아이디중복체크(String userName) {
		Users usersPS = usersDao.findByIdUserName(userName);
		if (usersPS == null) { // 상품명 번호 가 중복 안됨
			return false;
		} else { // 상품명 번호가 중복됨
			return true;
		}
	}

	public Users 로그인(LoginDto loginDto) {
		Users usersPS = usersDao.login(loginDto.getPassword(), loginDto.getUserName());
		if (usersPS == null && usersPS.equals(" ")) {
			return null;
		}

		if (usersPS.getPassword().equals(loginDto.getPassword())) {
			return usersPS;
		} else {
			return null;
		}
	}

}
