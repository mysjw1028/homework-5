package site.metacoding.firstapp.web.dto.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // 서현 추가함
@Getter
@Setter
public class AuthRespDto {
	private Integer id;
	private Integer userId;
	private String userPassword; // 비밀번호 숨기기
	private String role;
	private String email;
	private Integer mainadminId;
	private Integer adminId;

	// 서현 추가함
	public AuthRespDto(Integer id, Integer userId, Integer mainadminId, Integer adminId) {
		this.id = id;
		this.userId = userId;
		this.mainadminId = mainadminId;
		this.adminId = adminId;
	}
}
