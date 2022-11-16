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
import site.metacoding.firstapp.domain.Users;
import site.metacoding.firstapp.domain.UsersDao;
import site.metacoding.firstapp.web.dto.LoginRespDto;
import site.metacoding.firstapp.web.dto.request.buy.BuyDto;
import site.metacoding.firstapp.web.dto.request.buy.BuyListDto;
import site.metacoding.firstapp.web.dto.request.users.LoginDto;

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
			// - 다운캐스팅해서 넣어줘야함 이유 -> 값 크기 ? 가 안 맞아서 넣어줘야 실행이 된다.

		// 1. findById로 p1에 사려던 품목을 담김
		Product p1 = productDao.findById(buyDto.getProductId());
		System.out.println(buyDto.getProductId());
		// 2. buyCount에 기존 DB의 상품갯수 - 구매하려고 한 상품 갯수 정보 담기

		Integer buyCount = p1.getProductQty() - buyDto.getBuyQty();
		if (p1.getProductQty() - buyDto.getBuyQty() < 0) {
			return "redirect:/";
		} // 0이하는 못들어가게 -> 남은갯수보다 살려는 갯수가 많으면 메인으로 튕겨짐

		System.out.println("사려던 갯수 : " + buyDto.getBuyQty());
		System.out.println("남은 개수 : " + buyCount);

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
			System.out.println(e.getId());
		}
		// 3. 유저 아이디에대한 구매목록을 띄움
		model.addAttribute("buy", buyList);
		return "users/buylist";
	}

	@PostMapping("/buy/buylist/{id}/delete") // 5번 deleteById -> 삭제하기 -> post로 값 삭제
	public String 삭제하기(@PathVariable Integer id, BuyDto buyDto) {
		System.out.println("디버그: "+ buyDto.getBuyQty());
		System.out.println("디버그: "+ buyDto.getProductId());
		buyDao.deleteById(id);
		productDao.buyProductQty(buyDto);

		return "redirect:/";
	}
}
