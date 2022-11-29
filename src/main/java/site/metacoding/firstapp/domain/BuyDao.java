package site.metacoding.firstapp.domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.metacoding.firstapp.web.dto.request.buy.BuyDto;
import site.metacoding.firstapp.web.dto.request.buy.BuyListDto;
import site.metacoding.firstapp.web.dto.request.buy.BuyListUpdateDto;

public interface BuyDao {
	public void insert(BuyDto buyDto);

	public void update(Buy buy);

	public Buy findById(Integer productId);

	public void deleteById(Integer productId);

	public List<Buy> findAll();

	public List<BuyListDto> buyList(Integer id);// 구매목록보기 리스트 디티오 추가적으로 넣음

	public BuyListUpdateDto buylistcheck(@Param("id") Integer id, @Param("usersId") Integer usersId);// 구매목록보기 리스트 디티오  추가적으로 넣음



}
