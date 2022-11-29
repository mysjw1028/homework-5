package site.metacoding.firstapp.Service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Product;
import site.metacoding.firstapp.domain.ProductDao;
import site.metacoding.firstapp.web.dto.request.product.ProductUpdateDto;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductDao productDao;

	public boolean 상품명중복체크(String productName) {
		Product productPS = productDao.findByIdProductName(productName);
		if (productPS == null) { // 상품명 번호 가 중복 안됨
			return false;
		} else { // 상품명 번호가 중복됨
			return true;
		}
	}

	public void 상품수정(Integer id, ProductUpdateDto productUpdateDto) {
		// 1. 영속화
		Product productPS = productDao.findById(id);

		if (productPS == null) {
			throw new RuntimeException(id + "의 아이디를 찾을수없습니다.");
		}
		productPS.update(productUpdateDto);
		productDao.update(productPS);
	}
}
