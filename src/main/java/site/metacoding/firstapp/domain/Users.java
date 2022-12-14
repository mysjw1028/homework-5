package site.metacoding.firstapp.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.firstapp.web.dto.request.mainadmin.UsersUpdateDto;
import site.metacoding.firstapp.web.dto.request.users.LoginDto;
import site.metacoding.firstapp.web.dto.request.users.UpdateDto;

@NoArgsConstructor
@Setter
@Getter
public class Users {
	private Integer id;
	private String userName;
	private String password;
	private String email;
	private String role;
	private Timestamp createdAt;

	//디비에 없는값
	private String adminName;
	private String MainadminName;
	public Users(LoginDto loginDto) {
		this.userName = loginDto.getUserName();
		this.password = loginDto.getPassword();
	}

	public void update(UsersUpdateDto usersUpdateDto) {
		this.userName = usersUpdateDto.getUserName();
		this.email = usersUpdateDto.getEmail();
	}

	public Users(String userName, String password, String email) {
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

}
