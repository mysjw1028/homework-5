package site.metacoding.firstapp.Service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Admin;
import site.metacoding.firstapp.domain.AdminDao;
import site.metacoding.firstapp.domain.MainAdmin;
import site.metacoding.firstapp.domain.MainAdminDao;
import site.metacoding.firstapp.domain.Product;
import site.metacoding.firstapp.domain.Users;
import site.metacoding.firstapp.domain.UsersDao;
import site.metacoding.firstapp.web.dto.request.mainadmin.AdminUpdateDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.MainAdminJoinDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.MainAdminLoginDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.UsersUpdateDto;
import site.metacoding.firstapp.web.dto.request.product.ProductUpdateDto;

@RequiredArgsConstructor
@Service
public class MainAdminService {
	private final MainAdminDao mainAdminDao;
	private final AdminDao adminDao;
	private final UsersDao usersDao;

	public void 중앙관리자회원가입(MainAdminJoinDto mainAdminJoinDto) {
		MainAdmin mainadmins = mainAdminJoinDto.toEntity();
		mainAdminDao.insert(mainadmins);
	}//

	public boolean 중앙관리자중복체크(String MainAdminName) {
		MainAdmin MainAdminPS = mainAdminDao.findByIdMainAdminName(MainAdminName);
		if (MainAdminPS == null) { // 중앙관리자아이디가 중복 안됨
			return false;
		} else { // 중앙관리자가 중복됨
			return true;
		}
	}

	public void 관리자정보수정(Integer id, AdminUpdateDto adminUpdateDto) {
		// 1. 영속화
		Admin adminPS = adminDao.findById(id);

		if (adminPS == null) {
			throw new RuntimeException(id + "의 아이디를 찾을수없습니다.");
		}
		adminPS.update(adminUpdateDto);
		adminDao.update(adminPS);
	}

	public void 구매자정보수정(Integer id, UsersUpdateDto usersUpdateDto) {
		// 1. 영속화
		Users usersPS = usersDao.findById(id);

		if (usersPS == null) {
			throw new RuntimeException(id + "의 아이디를 찾을수없습니다.");
		}
		usersPS.update(usersUpdateDto);
		usersDao.update(usersPS);
	}

	public MainAdmin 중앙관관리자로그인(MainAdminLoginDto mainAdminLoginDto) {
		MainAdmin mainAdminsPS = mainAdminDao.findByIdMainAdminName(mainAdminLoginDto.getMainadminName());

		if (mainAdminsPS == null) {
			return null;
		}
		if (mainAdminsPS.getPassword().equals(mainAdminLoginDto.getPassword())) {
			return mainAdminsPS;
		} else {
			return null;
		}
	}

}
