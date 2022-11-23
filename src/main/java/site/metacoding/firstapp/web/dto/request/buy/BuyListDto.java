package site.metacoding.firstapp.web.dto.request.buy;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BuyListDto {
	private Integer id;
	private Integer productId;
	private String buyName;
	private Integer buyQty;
	private Integer buyPrice;
	private Timestamp createdAt;

	// 엔티티가 아닌 필드
	private Integer no;
}
