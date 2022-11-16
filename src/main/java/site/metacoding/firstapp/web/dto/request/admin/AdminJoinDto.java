package site.metacoding.firstapp.web.dto.request.admin;
import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.domain.Users;

@Setter
@Getter
public class AdminJoinDto {
	private Integer adminId;
	private String adminName;
	private String password;
	private String email;
	

}
