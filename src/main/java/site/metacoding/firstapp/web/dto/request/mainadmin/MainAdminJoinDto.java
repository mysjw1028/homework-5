package site.metacoding.firstapp.web.dto.request.mainadmin;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.domain.MainAdmin;
import site.metacoding.firstapp.domain.Users;

@Setter
@Getter
public class MainAdminJoinDto {
	private Integer mainadminId;
	private String mainadminName;
	private String password;
	private String passwordMainadmin;
	private String email;

	public MainAdmin toEntity() {
		MainAdmin mainAdmins = new MainAdmin(this.mainadminName, this.password, this.passwordMainadmin, this.email);
		return mainAdmins;
	}
}
