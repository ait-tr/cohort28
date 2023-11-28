package org.group28projectjpa.core.utils;


import org.group28projectjpa.domain.dto.manager.ManagerCreateResponseDTO;
import org.group28projectjpa.domain.dto.task.TaskCreateOrUpdateResponseDTO;
import org.group28projectjpa.domain.dto.task.TaskCreateRequestDTO;
import org.group28projectjpa.domain.dto.task.TaskResponseDTO;
import org.group28projectjpa.domain.dto.task.TaskUpdateRequestDTO;
import org.group28projectjpa.domain.entity.Role;
import org.group28projectjpa.domain.entity.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskConverter {

    public TaskCreateOrUpdateResponseDTO toCreateDto(Task task) {
        TaskCreateOrUpdateResponseDTO dto = new TaskCreateOrUpdateResponseDTO();
        dto.setId(task.getId());
        dto.setTaskName(task.getTaskName());
        dto.setDescription(task.getDescription());
        dto.setCreateDate(task.getCreateDate());
        dto.setLastUpdate(task.getLastUpdate());
        dto.setDeadline(task.getDeadline());
        dto.setStatus(task.getStatus());

        Role managerRole = task.getManager().getRole();

        dto.setManagerCreateResponseDTO(new ManagerCreateResponseDTO(
                task.getManager().getId(),
                task.getManager().getManagerName(),
                managerRole.getName()));

        return dto;
    }

    public TaskResponseDTO toDto(Task task) {
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setTaskName(task.getTaskName());
        dto.setDescription(task.getDescription());
        dto.setCreateDate(task.getCreateDate());
        dto.setLastUpdate(task.getLastUpdate());
        dto.setDeadline(task.getDeadline());
        dto.setStatus(task.getStatus());

        return dto;
    }

    public Task fromCreateRequest(TaskCreateRequestDTO dto) {
        Task task = new Task();
        if (dto.getTaskName() != null) {
            task.setTaskName(dto.getTaskName());
        }
        if (dto.getDescription() != null) {
            task.setDescription(dto.getDescription());
        }
        if (dto.getDeadline() != null) {
            task.setDeadline(dto.getDeadline());
        }

        return task;
    }

    public Task fromUpdateRequest(TaskUpdateRequestDTO dto) {
        Task task = new Task();
        if (dto.getId() != null) {
            task.setId(dto.getId());
        }

        if (dto.getTaskName() != null) {
            task.setTaskName(dto.getTaskName());
        }
        if (dto.getDescription() != null) {
            task.setDescription(dto.getDescription());
        }
        if (dto.getDeadline() != null) {
            task.setDeadline(dto.getDeadline());
        }
        if (dto.getStatus() != null) {
            task.setStatus(dto.getStatus());
        }
        return task;
    }

}
