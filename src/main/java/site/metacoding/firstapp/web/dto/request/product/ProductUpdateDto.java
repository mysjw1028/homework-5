package site.metacoding.firstapp.web.dto.request.product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductUpdateDto {
	private String productName;
	private Integer productPrice;
	private Integer productQty;
}
