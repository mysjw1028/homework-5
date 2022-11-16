package site.metacoding.firstapp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CMRespDto<T> { // 공통 응답 DTO
	private Integer code; // 1정상, -1실패
	private String msg; // 실패의 이유, 성공한 이유
	private T data; // 응답할 데이터
}