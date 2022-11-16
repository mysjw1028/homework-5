package site.metacoding.firstapp.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
	private Timestamp createdAt;
	
	
	public Users(LoginDto loginDto) {
		this.userName = loginDto.getUserName();
		this.password = loginDto.getPassword();
	}
	
	
}
