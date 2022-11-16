package site.metacoding.firstapp.domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.metacoding.firstapp.web.dto.request.buy.BuyDto;

public interface ProductDao {
	public Product findById(Integer productId);

	public List<Product> findAll();

	public int update(Product product);

	public int updateQty(@Param("productQty") Integer qty, @Param("productId") Integer id);

	public int deleteById(Integer productId);

	public int insert(Product product);

	public Product findByIdProductName(String productName);

	public void buyProductQty(BuyDto buyDto);
//	구매자가 구매취소시 기존 재고에서 늘어나야함
}
