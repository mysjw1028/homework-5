package site.metacoding.firstapp.web.dto.request.mainadmin;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.domain.Users;

@Setter
@Getter
public class MainAdminLoginDto {
	private String mainadminName;
	private String password;
	private String passwordMainadmin;
}
