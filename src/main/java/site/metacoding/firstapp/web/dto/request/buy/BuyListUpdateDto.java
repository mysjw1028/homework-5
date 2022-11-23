package site.metacoding.firstapp.web.dto.request.buy;


import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.web.dto.LoginRespDto;

@Setter
@Getter
public class BuyListUpdateDto {
	private Integer id;
	private Integer usersId;
	private String buyName;
	private Integer buyQty;



}
