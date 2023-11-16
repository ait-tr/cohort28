package lesson15.appExample.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoResponse {
    private Integer id;
    private String username;
    private String email;
    private LocalDateTime creationDate;
    private LocalDateTime lastVisitDate;
}
