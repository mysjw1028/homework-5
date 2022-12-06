package site.metacoding.firstapp.web.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SessionAdmin {
	private Integer id;
	private Integer adminId;
	private Integer mainadminId;
	private String username;
	private int role;

	public SessionAdmin(AdminFindByAllAdminnameDto AdminFindByAllAdminnameDto) {
		this.adminId = AdminFindByAllAdminnameDto.getAdminId();
		this.username = AdminFindByAllAdminnameDto.getAdminname();
		this.role = AdminFindByAllAdminnameDto.getRole();
	}
}
