package site.metacoding.firstapp.Service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Product;
import site.metacoding.firstapp.domain.ProductDao;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductDao productDao;

	public boolean 상품명중복체크(String productName) {
		Product productPS = productDao.findByIdProductName(productName);
		if (productPS == null) { // 사업자 번호 가 중복 안됨
			return false;
		} else { // 사업자번호가 중복됨
			return true;
		}
	}
}
