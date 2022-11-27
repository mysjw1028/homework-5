package site.metacoding.firstapp.Service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.MainAdmin;
import site.metacoding.firstapp.domain.MainAdminDao;

@RequiredArgsConstructor
@Service
public class MainAdminService {
	private final MainAdminDao mainAdminDao;

	public boolean 중앙관리자중복체크(String MainAdminName) {
		MainAdmin MainAdminPS = mainAdminDao.findByIdMainAdminName(MainAdminName);
		if (MainAdminPS == null) { // 중앙관리자아이디가 중복 안됨
			return false;
		} else { // 중앙관리자가 중복됨
			return true;
		}
	}
}
