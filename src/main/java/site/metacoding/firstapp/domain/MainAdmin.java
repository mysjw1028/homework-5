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
	private Timestamp createdAt;

	public MainAdmin(MainAdminLoginDto mainAdminLoginDto) {
		this.mainadminName = mainAdminLoginDto.getMainadminName();
		this.password = mainAdminLoginDto.getPassword();
		this.passwordMainadmin = mainAdminLoginDto.getPasswordMainadmin();
	}

}
