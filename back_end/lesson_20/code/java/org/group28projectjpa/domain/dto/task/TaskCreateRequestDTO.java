package org.group28projectjpa.domain.dto.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateRequestDTO {

    @NotBlank(message = "Task name must be not blank")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Task name must contain latin letters and digit only")
    @Size(min = 3, max = 15, message = "Task name length must be between 3 and 15")
    private String taskName;

    @NotBlank(message = "Task name must be not blank")
    @Size(min = 1, max = 25, message = "Task description length must be between 1 and 25")
    private String description;

    private LocalDateTime deadline;

    private String managerName;
}
