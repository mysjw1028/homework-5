package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Product;
import site.metacoding.firstapp.domain.ProductDao;
import site.metacoding.firstapp.service.ProductService;
import site.metacoding.firstapp.util.Auth;
import site.metacoding.firstapp.util.MultiValueAnnotation;
import site.metacoding.firstapp.web.dto.CMRespDto;
import site.metacoding.firstapp.web.dto.request.product.ProductUpdateDto;

@RequiredArgsConstructor
@Controller
public class ProductController {
	private final ProductDao productDao;
	private final ProductService productService;

	@GetMapping({ "/", "/product" }) // 1번 findAll -> 전체보여주기
	public String findAll(Model model) {
		List<Product> productList = productDao.findAll();
		model.addAttribute("product", productList);
		return "product/product";
	}

	@GetMapping("/product/{productId}") // 2번 findById -> 상세보기
	public String findById(@PathVariable Integer productId, Model model) {
		model.addAttribute("product", productDao.findById(productId));
		return "product/detail";
	}

	@PostMapping("/s/product/insert") // 3번 insert -> 데이터에 값넣기-> post로 넣기
	public @ResponseBody CMRespDto<?> 추가하기(@RequestBody Product product) {
		productDao.insert(product);
		return new CMRespDto<>(1, "상품등록성공", null);
	}

	@GetMapping("/s/product/insertForm")
	public String insert() {
		return "product/insert";
	}

	// **********************POSTMAN으로 테스트****************//
	@PostMapping("/s/product/{productId}/edit") // 4번 update -> 수정하기 -> post로 값 수정
	public @ResponseBody CMRespDto<?> 수정하기(@PathVariable Integer productId, @RequestBody ProductUpdateDto productDto) {
		if (productDto.getProductName() == null || productDto.getProductName().isEmpty()) {

			return new CMRespDto<>(-1, "상품수정실패", null);

		} else if (productDto.getProductPrice() == null || productDto.getProductPrice().equals("")) {

			return new CMRespDto<>(-1, "상품수정실패", null);

		} else if (productDto.getProductQty() == null || productDto.getProductQty().equals("")) {

			return new CMRespDto<>(-1, "상품수정실패", null);
		}
		productService.상품수정(productId, productDto);

		return new CMRespDto<>(1, "상품수정성공", null);
	}

	@GetMapping("/s/product/{productId}/edit")
	public String edit(@PathVariable Integer productId, Model model) {
		Product productPS = productDao.findById(productId);
		model.addAttribute("product", productPS);
		// System.out.println(productId);//해당 아이디 숫자 출력됨
		return "product/update";
	}

	@PostMapping("/s/product/{productId}/delete") // 5번 deleteById -> 삭제하기 -> post로 값 삭제
	public String 삭제하기(@PathVariable Integer productId) {
		Product productPS = productDao.findById(productId);
		productDao.deleteById(productId);
		return "redirect:/";
	}

	@GetMapping("/product/productNameCheck")
	public @ResponseBody CMRespDto<Boolean> productNumberSameCheck(String productName) {
		boolean isSame = productService.상품명중복체크(productName);
		return new CMRespDto<>(1, "성공", isSame);
	}
}
