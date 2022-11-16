package site.metacoding.firstapp.Service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Product;
import site.metacoding.firstapp.domain.ProductDao;
import site.metacoding.firstapp.domain.Users;
import site.metacoding.firstapp.domain.UsersDao;

@RequiredArgsConstructor
@Service
public class UsersService {

	private final  UsersDao usersDao;

	public boolean 아이디중복체크(String username) {
		Users  UsersPS = usersDao.findByIduserName(username);
		if (UsersPS != null) { // 유저 정보가 없음
			return true;
		} else { // 유저 정보가 있음
			return false;
		}
	}
}
