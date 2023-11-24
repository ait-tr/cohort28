package org.group28projectjpa.controllers;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.group28projectjpa.core.services.ManagerService;
import org.group28projectjpa.core.services.TaskService;
import org.group28projectjpa.domain.dto.manager.ManagerCreateRequestDTO;
import org.group28projectjpa.domain.dto.manager.ManagerCreateResponseDTO;
import org.group28projectjpa.domain.dto.manager.ManagerResponseDTO;
import org.group28projectjpa.domain.dto.task.TaskResponseDTO;
import org.group28projectjpa.domain.entity.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final ManagerService managerService;
    private final TaskService taskService;

    @PostMapping("/managers")
    public ResponseEntity<ManagerCreateResponseDTO> createNewManager(@Valid @RequestBody ManagerCreateRequestDTO request) {
        return new ResponseEntity<>(managerService.createManager(request), HttpStatus.CREATED);
    }

    @GetMapping("/managers")
    public ResponseEntity<List<ManagerResponseDTO>> findAllManager() {
        return new ResponseEntity<>(managerService.findAllManagers(), HttpStatus.OK);
    }

    @GetMapping("/managers/{email}")
    public ResponseEntity<ManagerResponseDTO> findManagerByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(managerService.findByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/managers/{managerName}")
    public ResponseEntity<ManagerResponseDTO> findManagerByManagerName(@PathVariable("managerName") String managerName) {
        return new ResponseEntity<>(managerService.findByManagerName(managerName), HttpStatus.OK);
    }

    @DeleteMapping("/{managers_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteManagerById(@PathVariable("manager_id") Integer managerId){
        managerService.deleteManager(managerId);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> findAllTasks() {
        return new ResponseEntity<>(taskService.findAllForAdmin(), HttpStatus.OK);
    }
}
/*

5. Method: UPDATE
URL:/api/admin/managers/{id}


 */
