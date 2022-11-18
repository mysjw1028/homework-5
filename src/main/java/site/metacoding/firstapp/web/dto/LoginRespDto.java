package site.metacoding.firstapp.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import site.metacoding.firstapp.domain.Admin;
import site.metacoding.firstapp.domain.MainAdmin;
import site.metacoding.firstapp.domain.Users;

@Getter
@NoArgsConstructor
public class LoginRespDto {
	private Integer id;
	private String adminName;
	private String userName;
	private String mainadminName;
	private String role;	
	
	public LoginRespDto(Users users) {//구매자
		this.id = users.getId();
		this.userName = users.getUserName();
		this.role=users.getRole();
	}

	public LoginRespDto(Admin admin) {//일반 관리자
		this.id = admin.getId();
		this.adminName = admin.getAdminName();
		this.role=admin.getRole();
	}

	public LoginRespDto(MainAdmin mainAdmin) {//중앙 관리자
		this.id = mainAdmin.getId();
		this.mainadminName = mainAdmin.getMainadminName();
		this.role=mainAdmin.getRole();
	}

}

//id 말고 디티오를 넣어서 깨긋하고 한번에 2가지()엔티티에서 디티오넘겨주는
//respDto가능함 reqestDto는 디티오에서 엔티티로 바꿔주는거 해야함
//팀 활동때문이라도 분리해야함
//-> 반대로  생정자 / 빌드를 리턴해주면 됨 => requestDto