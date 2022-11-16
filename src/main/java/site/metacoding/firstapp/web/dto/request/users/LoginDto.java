package site.metacoding.firstapp.web.dto.request.users;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.domain.Users;

@Setter
@Getter
public class LoginDto {
	private String userName;
	private String password;
	
}
