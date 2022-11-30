package site.metacoding.firstapp.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.firstapp.web.dto.request.admin.AdminLoginDto;
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

	public Admin(AdminLoginDto adminloginDto) {
		this.adminName = adminloginDto.getUserName();
		this.password = adminloginDto.getPassword();
	}

	public void update(Admin admin) {
		this.adminName = admin.getAdminName();
		this.email = admin.getEmail();
	}
	public Admin(String adminName, String password, String email) {
		this.adminName = adminName;
		this.password = password;
		this.email = email;
	}
}
