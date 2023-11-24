package org.group28projectjpa.domain.dto.manager;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.group28projectjpa.domain.entity.Role;

@Data
@AllArgsConstructor
public class ManagerResponseDTO {

    private Integer id;
    private String managerName;
    private String email;
    private Role roleName;

}
