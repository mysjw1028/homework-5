package site.metacoding.firstapp.web.dto.Response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // 서현 추가함
@Getter
@Setter
public class SessionUsers {
	public final String getRole = null;
	private Integer id;
	private Integer userId;
	private String role; // '일반' = users (디폴트값), '일반 관리자 ' = admin, (디폴트값) '중앙 관리자' = Mainadmin(디폴트값)
	private String email;
	private Integer mainadminId;
	private Integer adminId;

	public SessionUsers(AuthRespDto authRespDto) {
		this.id = authRespDto.getId();
		this.userId = authRespDto.getUserId();
		this.role = authRespDto.getRole();
	}

	@Builder
	public SessionUsers(Integer id, Integer userId, String role, Integer mainadminId, Integer adminId) {
		this.id = id;
		this.id = id;
		this.userId = userId;
		this.role = role;
		this.mainadminId = mainadminId;
		this.adminId = adminId;
	}
}
