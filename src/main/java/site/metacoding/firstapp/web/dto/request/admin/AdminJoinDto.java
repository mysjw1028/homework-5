package site.metacoding.firstapp.web.dto.request.admin;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.domain.Admin;
import site.metacoding.firstapp.domain.Users;

@Setter
@Getter
public class AdminJoinDto {
	private Integer adminId;
	private String adminName;
	private String password;
	private String role;
	private String email;

	public Admin toEntity() {
		Admin admin = new Admin(this.adminName, this.password, this.email);
		return admin;
}
}
