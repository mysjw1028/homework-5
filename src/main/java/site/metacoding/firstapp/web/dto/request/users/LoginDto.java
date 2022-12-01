package site.metacoding.firstapp.web.dto.request.users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDto {
	private String userName;
	private String password;
	private boolean remember;

}
