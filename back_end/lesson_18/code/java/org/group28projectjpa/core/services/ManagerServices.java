package org.group28projectjpa.core.services;

import lombok.AllArgsConstructor;
import org.group28projectjpa.core.utils.ManagerConverter;
import org.group28projectjpa.core.validation.IsAlreadyExistException;
import org.group28projectjpa.core.validation.NotFoundException;
import org.group28projectjpa.dto.manager.ManagerCreateRequestDTO;
import org.group28projectjpa.dto.manager.ManagerCreateResponseDTO;
import org.group28projectjpa.dto.manager.ManagerResponseDTO;
import org.group28projectjpa.entity.Manager;
import org.group28projectjpa.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ManagerServices {

    private final ManagerRepository repository;
    private final ManagerConverter converter;

    // получить список всех пользователей

    public List<ManagerResponseDTO> findAllManagers() {
        return repository.findAll().stream()
                .map(converter::toDto)
                .toList();
    }

    //найти пользователя по email
    public ManagerResponseDTO findByManagerEmail(String email){
        Manager manager  =repository.findByEmail(email).orElseThrow(() -> new NotFoundException("Manager not found with email: " + email));
        return converter.toDto(manager);
    }

    // Создать нового пользователя

    public ManagerCreateResponseDTO createManager(ManagerCreateRequestDTO requestDTO) {
        if (repository.findByEmail(requestDTO.getEmail()).isEmpty()) {
            Manager newManager = converter.fromDto(requestDTO);
            newManager = repository.save(newManager);
            return converter.toCreateDto(newManager);
        } else {
            throw new IsAlreadyExistException("Manager with email " + requestDTO.getEmail() + " is already exist!");
        }
    }

    public void deleteManager(Integer id) {
        Manager manager = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Manager with ID: " + id + " is not found!"));
        repository.delete(manager);
    }

}
