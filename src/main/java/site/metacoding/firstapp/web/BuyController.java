package site.metacoding.firstapp.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.Buy;
import site.metacoding.firstapp.domain.BuyDao;
import site.metacoding.firstapp.domain.Product;
import site.metacoding.firstapp.domain.ProductDao;

import site.metacoding.firstapp.web.dto.LoginRespDto;
import site.metacoding.firstapp.web.dto.request.buy.BuyDto;
import site.metacoding.firstapp.web.dto.request.buy.BuyListDto;
import site.metacoding.firstapp.web.dto.request.buy.BuyListUpdateDto;

@RequiredArgsConstructor
@Controller
public class BuyController {
	private final HttpSession session;
	private final ProductDao productDao;
	private final BuyDao buyDao;

	@GetMapping("/buy/{productId}")
	public String buyTable(@PathVariable Integer productId, Model model) {
		model.addAttribute("product", productDao.findById(productId));
		return "users/buy";
	}

	@PostMapping("/buy/{productId}")
	public String buy(BuyDto buyDto) {// 테이블 수정후 jsp name 확인하기
		LoginRespDto loginRespDto = (LoginRespDto) session.getAttribute("principal");
		if (loginRespDto == null) {
			return "redirect:/";
		} // setAttribute를 쓰는게 아니라 getAttribute를 써야한다
			// - LoginRespDto에 있는 값을 들고와서 쓰는거기때문에 getAttribute
			// - 다운캐스팅해서 넣어줘야함 이유 -> 담을수 있는 값 크기가 안 맞아서 다운캐스팅을 해야 실행이 된다.

		// 1. findById로 p1에 사려던 품목을 담김
		Product p1 = productDao.findById(buyDto.getProductId());
		// 2. buyCount에 기존 DB의 상품갯수 - 구매하려고 한 상품 갯수 정보 담기
		Integer buyCount = p1.getProductQty() - buyDto.getBuyQty();
		if (p1.getProductQty() - buyDto.getBuyQty() < 0) {
			return "redirect:/";
		} // 0이하는 못들어가게 -> 남은갯수보다 살려는 갯수가 많으면 메인으로 튕겨짐
			// 3. buyDto에 담은 정보로 insert함
		buyDao.insert(buyDto);

		// 4. buyCount와 buyDto에 담긴 productId로 qty 업데이트
		productDao.updateQty(buyCount, buyDto.getProductId());
		return "redirect:/";

	}

	@GetMapping("/buy/buylist/{id}")
	// 유저에 대한 구매목록 나오게 하는 주소
	public String buylist(@PathVariable Integer id, Model model) {
		// 2. 아이디를 받아
		List<BuyListDto> buyList = buyDao.buyList(id);
		for (BuyListDto e : buyList = buyDao.buyList(id)) {
		}
		// 3. 유저 아이디에대한 구매목록을 띄움
		model.addAttribute("buy", buyList);
		return "users/buylist";
	}

	@PostMapping("/buy/buylist/{id}/delete")
	public String 삭제하기(@PathVariable Integer id, BuyDto buyDto) {
		buyDao.deleteById(id);
		productDao.buyProductQty(buyDto);
		return "redirect:/";
	}

//	@GetMapping("/buy/buylist/{productId}/buylistcheck") // 구매갯수 조절 페이지 -> 구현 못함
//	public String buylistcheck(@PathVariable Integer productId, Model model) {
//		LoginRespDto loginRespDto = (LoginRespDto) session.getAttribute("principal");
//		BuyListUpdateDto buyListUpdateDtoPS = buyDao.buylistcheck(productId, loginRespDto.getId());
//		System.out.println(buyListUpdateDtoPS.getUsersId()); // 여기서 오류터짐
//		model.addAttribute("buy", buyListUpdateDtoPS);
//		return "users/buylistcheck";
//	}// 값을 뭘로 받아야할지 생각하기
//
//	@PostMapping("/buy/buylist/{productId}/buylistcheck")
//	public String 주문내역수정(@PathVariable Integer productId, BuyDto buyDto) {
//		System.out.println("=======================================");
//		System.out.println("id: " + productId);
//		System.out.println("id: " + buyDto.getProductId());
//		System.out.println("=======================================");
//
//		Product productPS = productDao.findById(productId);// 여기서 부터 출력이 안됨
//		System.out.println("=======================================");
//		System.out.println("productPS: " + productPS.getProductPrice());
//		System.out.println("=======================================");
//		Buy buyPS = buyDao.findById(productId);
//
//		Integer buyCount = productPS.getProductQty() + buyDto.getBuyQty();
//		Buy buyPS = buyDao.findById(id);
//		Integer buyCount = productPS.getProductQty() + buyDto.getBuyQty();
//
//		
//		productDao.buyResetQty(buyDto);
//		buyPS = buyDao.findById(productId);
//		int productCount = productPS.getProductQty() - buyDto.getBuyQty();
//		productPS.setProductQty(productCount);
//		productDao.updateQty(productCount, productId);
//		return "redirect:/"; // 다음주에 할것
//	}

}

// buyDao.deleteById(id); -> id -> productId 를 주문 취소를 해준후
// productDao.buyProductQty(buyDto);에서 재고를 추가해주는 쿼리를 넣음
// productDao.buyProductQty 추가적으로 생성(product.xml에 쿼리 넣음)
// 삭제 / 업데이트 위치는 크게 상관이 없다 (위치변경 테스트 진행해봄 -> 어차피 값이 삭제된후 창고에 저장이 되었다가
// productDao가 실행되면서 창고에서 다시 꺼내와 productQty에 추가가 된다. -> 이때 주문 취소된 물건 id 기준으로 진행이
// 됨)