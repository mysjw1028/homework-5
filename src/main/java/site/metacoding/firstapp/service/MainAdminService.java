package site.metacoding.firstapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Admin;
import site.metacoding.firstapp.domain.AdminDao;
import site.metacoding.firstapp.domain.MainAdmin;
import site.metacoding.firstapp.domain.MainAdminDao;
import site.metacoding.firstapp.domain.Users;
import site.metacoding.firstapp.domain.UsersDao;
import site.metacoding.firstapp.web.dto.request.mainadmin.AdminUpdateDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.MainAdminJoinDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.MainAdminLoginDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.UsersUpdateDto;

@RequiredArgsConstructor
@Service
public class MainAdminService {
	private final MainAdminDao mainAdminDao;
	private final AdminDao adminDao;
	private final UsersDao usersDao;

	@Transactional(rollbackFor = RuntimeException.class)
	public void 중앙관리자회원가입(MainAdminJoinDto mainAdminJoinDto) {
		MainAdmin mainadmins = mainAdminJoinDto.toEntity();
		mainAdminDao.insert(mainadmins);
	}//

	public boolean 중앙관리자중복체크(String MainAdminName) {
		MainAdmin mainAdminPS = mainAdminDao.findByIdMainAdminName(MainAdminName);
		if (mainAdminPS == null) { // 중앙관리자아이디가 중복 안됨
			return false;
		} else { // 중앙관리자가 중복됨
			return true;
		}
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public void 관리자정보수정(Integer id, AdminUpdateDto adminUpdateDto) {
		// 1. 영속화
		Admin adminPS = adminDao.findById(id);

		if (adminPS == null && adminPS.equals(" ")) {
			throw new RuntimeException(id + "의 아이디를 찾을수없습니다.");
		}
		adminPS.update(adminUpdateDto);
		adminDao.update(adminPS);
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public void 구매자정보수정(Integer id, UsersUpdateDto usersUpdateDto) {
		// 1. 영속화
		Users usersPS = usersDao.findById(id);

		if (usersPS == null && usersPS.equals(" ")) {
			throw new RuntimeException(id + "의 아이디를 찾을수없습니다.");
		}
		usersPS.update(usersUpdateDto);
		usersDao.update(usersPS);
	}

	public MainAdmin 중앙관관리자로그인(MainAdminLoginDto mainAdminLoginDto) {
		MainAdmin mainAdminPS = mainAdminDao.login(mainAdminLoginDto.getPasswordMainadmin(),
				mainAdminLoginDto.getPassword(), mainAdminLoginDto.getMainadminName());
		if (mainAdminPS == null && mainAdminPS.equals(" ")) {
			return null;
		}

		if (mainAdminPS.getPassword().equals(mainAdminPS.getPassword())) {
			return mainAdminPS;
		} else {
			return null;
		}
	}

}
