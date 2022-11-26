package site.metacoding.firstapp.Service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Admin;
import site.metacoding.firstapp.domain.AdminDao;


@RequiredArgsConstructor
@Service
public class AdminService {
	private final AdminDao adminDao;

	public boolean 관리자중복체크(String adminName) {
		Admin adminPS = adminDao.findByIdAdminName(adminName);
		if (adminPS == null) { // 관리자아이디가 중복 안됨
			return false;
		} else { //  관리자가 중복됨
			return true;
		}
	}
}
