package lesson14.appExample.DTO;

import lesson14.appExample.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ToDoDtoRequest {
    private String title;
    private String description;
    private Integer userId;

}
