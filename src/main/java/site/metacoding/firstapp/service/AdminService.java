package site.metacoding.firstapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Admin;
import site.metacoding.firstapp.domain.AdminDao;
import site.metacoding.firstapp.web.dto.request.admin.AdminJoinDto;
import site.metacoding.firstapp.web.dto.request.admin.AdminLoginDto;

@RequiredArgsConstructor
@Service
public class AdminService {
	private final AdminDao adminDao;
	@Transactional(rollbackFor = RuntimeException.class)
	public void 관리자회원가입(AdminJoinDto adminJoinDto) {
		Admin admins = adminJoinDto.toEntity();
		adminDao.insert(admins);
	}// 컨트롤러가 일 안함

	public boolean 관리자중복체크(String adminName) {
		Admin adminPS = adminDao.findByIdAdminName(adminName);
		if (adminPS == null) { // 관리자아이디가 중복 안됨
			return false;
		} else { // 관리자가 중복됨
			return true;
		}
	}

	public Admin 로그인(AdminLoginDto adminLoginDto) {
		Admin adminPS = adminDao.login(adminLoginDto.getPassword(), adminLoginDto.getAdminName());
		if (adminPS == null && adminPS.equals(" ")) {
			return null;
		}

		if (adminPS.getPassword().equals(adminLoginDto.getPassword())) {
			return adminPS;
		} else {
			return null;
		}
	}
}
