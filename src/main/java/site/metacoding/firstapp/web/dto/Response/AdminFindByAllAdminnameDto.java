package site.metacoding.firstapp.web.dto.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminFindByAllAdminnameDto {
	private Integer adminId;
	private String adminname;
	private String password;
	private int role;
}