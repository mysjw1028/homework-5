package site.metacoding.firstapp.web.dto.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MainAdminFindByAllMainAdminnameDto {
	private Integer MainAdminId;
	private String mainadminname;
	private String password;
	private int role;
}