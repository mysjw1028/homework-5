package site.metacoding.firstapp.web.dto.request.users;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.domain.Users;

@Setter
@Getter
public class JoinDto {
	private Integer usersId;
	private String userName;
	private String password;
	private String role;
	private String email;

	public Users toEntity() {
		Users users = new Users(this.userName, this.password, this.email);
		return users;
}
}
