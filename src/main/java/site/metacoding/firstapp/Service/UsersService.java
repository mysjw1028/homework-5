package site.metacoding.firstapp.Service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Users;
import site.metacoding.firstapp.domain.UsersDao;

@RequiredArgsConstructor
@Service
public class UsersService {
	private final UsersDao usersDao;

	public boolean 아이디중복체크(String userName) {
		Users usersPS = usersDao.findByIdUserName(userName);
		if (usersPS == null) { // 상품명 번호 가 중복 안됨
			return false;
		} else { // 상품명 번호가 중복됨
			return true;
		}
	}
}
