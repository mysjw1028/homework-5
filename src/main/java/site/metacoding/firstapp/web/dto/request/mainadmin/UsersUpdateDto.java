package site.metacoding.firstapp.web.dto.request.mainadmin;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsersUpdateDto {
	private Integer id;
	private String userName;
	private String email;
	private Timestamp createdAt;
	// 엔티티가아닌 필드 -> 번호로 보이기 위해서
	private Integer no;
}

 