package site.metacoding.firstapp.web.dto.request.mainadmin;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsersListDto {
	private Integer id;
	private Integer usersId;
	private String userName;
	private String email;
	private Timestamp createdAt;

	// 엔티티가 아닌 필드
	private Integer no;
}
