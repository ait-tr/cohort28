package lesson15.appExample.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDtoRequest {
    private String username;
    private String password;
    private String email;

}
