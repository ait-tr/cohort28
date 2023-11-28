package org.group28projectjpa.domain.dto.manager;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ManagerCreateResponseDTO {

    private Integer id;
    private String managerName;
    private String email;

}
