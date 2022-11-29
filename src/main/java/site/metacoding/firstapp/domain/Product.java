package site.metacoding.firstapp.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.web.dto.request.product.ProductUpdateDto;

@Setter
@Getter
public class Product {
	private Integer productId;
	private String productName;
	private Integer productPrice;
	private Integer productQty;
	private Timestamp createdAt;

	// 엔티티가 아닌 필드 번호로해서 보일려고
	private Integer no;

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	private Product() {
	} // MyBatis에게 필요한 것

	public Product(String productName, Integer productPrice, Integer productQty) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQty = productQty;
	}

	public void update(ProductUpdateDto productDto) {
		this.productName = productDto.getProductName();
		this.productPrice = productDto.getProductPrice();
		this.productQty = productDto.getProductQty();
	}

}
