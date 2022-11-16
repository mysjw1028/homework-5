package site.metacoding.firstapp.web.dto.request.buy;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.domain.Users;

@Setter
@Getter
public class BuyDto {
	private Integer id;
	private Integer usersId;//세션으로 받아올 유저값
	private Integer productId;//디비에서 들고온값
	private Integer buyQty;//사용자가 입력
	private Integer buyPrice;//product의 가격을 buy테이블에 넣기위한 값
	private String buyName;//product의 이름을 buy테이블에 넣기위한 값
	private Timestamp createdAt;
	// 엔티티가 아닌 필드
		private Integer no;
}
