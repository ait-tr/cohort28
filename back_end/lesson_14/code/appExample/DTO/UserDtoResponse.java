package lesson14.appExample.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserDtoResponse {
    private Integer id;
    private String username;
    private String email;
    private LocalDateTime creationDate;
    private LocalDateTime lastVisitDate;
}
