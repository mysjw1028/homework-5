package site.metacoding.firstapp.web.dto.request.users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateDto {
	private String password;
	private String email;
}
