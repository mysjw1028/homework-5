package site.metacoding.firstapp.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.firstapp.web.dto.request.mainadmin.MainAdminLoginDto;

@NoArgsConstructor
@Setter
@Getter
public class MainAdmin {
	private Integer id;
	private String mainadminName;
	private String password;
	private String passwordMainadmin;
	private String email;
	private String role;
	private Timestamp createdAt;

	// 엔티티가 아닌 필드 번호로해서 보일려고
	private Integer no;

	public MainAdmin(MainAdminLoginDto mainAdminLoginDto) {
		this.mainadminName = mainAdminLoginDto.getMainadminName();
		this.password = mainAdminLoginDto.getPassword();
		this.passwordMainadmin = mainAdminLoginDto.getPasswordMainadmin();
	}

}
