package lesson15.appExample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private User author;

}
