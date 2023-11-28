package org.group28projectjpa.databaseMigration.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.group28projectjpa.domain.entity.Role;
import org.group28projectjpa.repository.RoleRepository;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class DatabaseConfig {
    private final RoleRepository roleRepository;

    public void fillRoleTable(){
        Role admin = new Role();
        admin.setName("Admin");
        roleRepository.save(admin);

        Role user = new Role();
        user.setName("User");
        roleRepository.save(user);


    }
}
