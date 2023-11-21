package org.group28projectjpa.dto.manager;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ManagerCreateRequestDTO {

    private String managerName;
    private String password;
    private String email;

}
