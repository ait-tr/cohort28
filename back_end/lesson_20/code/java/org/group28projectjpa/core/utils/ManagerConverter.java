package org.group28projectjpa.core.utils;


import org.group28projectjpa.domain.dto.manager.ManagerCreateRequestDTO;
import org.group28projectjpa.domain.dto.manager.ManagerCreateResponseDTO;
import org.group28projectjpa.domain.dto.manager.ManagerResponseDTO;
import org.group28projectjpa.domain.entity.Manager;
import org.group28projectjpa.domain.entity.Role;
import org.springframework.stereotype.Service;


@Service
public class ManagerConverter {

    public ManagerCreateResponseDTO toCreateDto(Manager manager) {
        String role = manager.getRole().getName();
        return new ManagerCreateResponseDTO(manager.getId(), manager.getManagerName(), role);
    }

    public ManagerResponseDTO toDto(Manager manager) {
        Role role = manager.getRole();
        return new ManagerResponseDTO(manager.getId(), manager.getManagerName(), manager.getEmail(), role);
    }

    public Manager  fromDto(ManagerCreateRequestDTO dto) {
        Manager newManager = new Manager();
        if (dto.getManagerName() != null) {
            newManager.setManagerName(dto.getManagerName());
        }
        if (dto.getPassword() != null) {
            newManager.setPassword(dto.getPassword());
        }
        if (dto.getEmail() != null) {
            newManager.setEmail(dto.getEmail());
        }

        return newManager;
    }
}
