package site.metacoding.firstapp.web.dto.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserFindByAllUsernameDto {
    private Integer id;
    private String username;
    private String password;
    private int role;
}