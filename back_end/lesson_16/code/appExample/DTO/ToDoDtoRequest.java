package lesson15.appExample.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToDoDtoRequest {
    private String title;
    private String description;
    private Integer userId;

}
