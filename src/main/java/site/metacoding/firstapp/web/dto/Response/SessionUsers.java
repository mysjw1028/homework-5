package site.metacoding.firstapp.web.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SessionUsers {
	private Integer id;
	private Integer adminId;
	private Integer mainadminId;
	private String username;
	private String role;
	private String sessionUser;
	

	public SessionUsers(UserFindByAllUsernameDto userFindByAllUsernameDto) {
		this.id = userFindByAllUsernameDto.getId();
		this.username = userFindByAllUsernameDto.getUsername();
		this.role = userFindByAllUsernameDto.getRole();
	}





}
