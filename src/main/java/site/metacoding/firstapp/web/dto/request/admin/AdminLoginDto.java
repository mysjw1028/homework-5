package site.metacoding.firstapp.web.dto.request.admin;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.domain.Users;

@Setter
@Getter
public class AdminLoginDto {
	private String userName;
	private String password;
	
}
