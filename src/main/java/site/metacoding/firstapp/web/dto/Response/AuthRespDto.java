package site.metacoding.firstapp.web.dto.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AuthRespDto {
	private Integer id;
	private Integer userId;
	private String userPassword; // 비밀번호 숨기기
	private Integer role;
	private String email;
	private Integer mainadminId;
	private Integer adminId;

	public AuthRespDto(Integer id, Integer userId, Integer mainadminId, Integer adminId) {
		this.id = id;
		this.userId = userId;
		this.mainadminId = mainadminId;
		this.adminId = adminId;
	}
}
