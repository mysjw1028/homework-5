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
public class SessionUsers {
    private Integer id;
    private String username;
    private Integer role; // 0 = user, 1 = company

    public SessionUsers(UserFindByAllUsernameDto userFindByAllUsernameDto) {
        this.id = userFindByAllUsernameDto.getId();
        this.username = userFindByAllUsernameDto.getUsername();
        this.role = userFindByAllUsernameDto.getRole();
    }
}
