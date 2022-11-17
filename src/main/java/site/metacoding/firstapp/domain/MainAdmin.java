package site.metacoding.firstapp.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.firstapp.web.dto.request.admin.AdminLoginDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.MainAdminLoginDto;
import site.metacoding.firstapp.web.dto.request.users.LoginDto;
import site.metacoding.firstapp.web.dto.request.users.UpdateDto;

@NoArgsConstructor
@Setter
@Getter
public class MainAdmin {
	private Integer id;
	private String adminName;
	private String password;
	private String passwordMainadmin;
	private String email;
	private Timestamp createdAt;

	public MainAdmin(MainAdminLoginDto mainAdminLoginDto) {
		this.adminName = mainAdminLoginDto.getMainadminName();
		this.password = mainAdminLoginDto.getPassword();
		this.passwordMainadmin = mainAdminLoginDto.getPasswordMainadmin();
	}

}
