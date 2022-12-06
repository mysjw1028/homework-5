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
public class SessionMainAdmin {
	private Integer id;
	private Integer adminId;
	private Integer mainadminId;
	private String mainadminname;
	private int role;

	public SessionMainAdmin(MainAdminFindByAllMainAdminnameDto mainAdminFindByAllMainAdminnameDto) {
		this.mainadminId = mainAdminFindByAllMainAdminnameDto.getMainAdminId();
		this.mainadminname = mainAdminFindByAllMainAdminnameDto.getMainadminname();
		this.role = mainAdminFindByAllMainAdminnameDto.getRole();
	}
}
