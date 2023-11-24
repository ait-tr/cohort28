package org.group28projectjpa.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Task name must be not blank")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Task name must contain latin letters and digit only")
    @Size(min = 3, max = 15, message = "Task name length must be between 3 and 15")
    private String taskName;

    @NotBlank(message = "Task name must be not blank")
    @Size(min = 1, max = 25, message = "Task description length must be between 1 and 25")
    private String description;

    private LocalDateTime createDate;

    private LocalDateTime lastUpdate;

    @NotNull(message = "Deadline name must be not blank/null")
    private LocalDateTime deadline;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    private TaskStatus status;


}
