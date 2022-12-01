package site.metacoding.firstapp.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.firstapp.web.dto.request.admin.AdminLoginDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.AdminUpdateDto;
import site.metacoding.firstapp.web.dto.request.users.LoginDto;
import site.metacoding.firstapp.web.dto.request.users.UpdateDto;

@NoArgsConstructor
@Setter
@Getter
public class Admin {
	private Integer id;
	private String adminName;
	private String password;
	private String email;
	private String role;
	private Timestamp createdAt;

	//디비에 없는값
	private String userName;
	private String MainadminName;

	public Admin(AdminLoginDto adminloginDto) {
		this.adminName = adminloginDto.getAdminName();
		this.password = adminloginDto.getPassword();
	}

	public void update(AdminUpdateDto adminUpdateDto) {
		this.adminName = adminUpdateDto.getAdminName();
		this.email = adminUpdateDto.getEmail();
	}// 중앙관리자가 일반관리자 관리

	public Admin(String adminName, String password, String email) {
		this.adminName = adminName;
		this.password = password;
		this.email = email;
	}
}
