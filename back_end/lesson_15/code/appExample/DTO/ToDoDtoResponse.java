package lesson15.appExample.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoDtoResponse {
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private Integer userId;

}
