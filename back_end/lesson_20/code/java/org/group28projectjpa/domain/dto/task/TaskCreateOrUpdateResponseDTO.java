package org.group28projectjpa.domain.dto.task;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group28projectjpa.domain.dto.manager.ManagerCreateResponseDTO;
import org.group28projectjpa.domain.entity.TaskStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateOrUpdateResponseDTO {

    private Integer id;
    private String taskName;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private LocalDateTime deadline;
    private TaskStatus status;
    private ManagerCreateResponseDTO managerCreateResponseDTO;

}
