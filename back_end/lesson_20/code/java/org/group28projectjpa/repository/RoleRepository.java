package org.group28projectjpa.repository;

import org.group28projectjpa.domain.entity.Manager;
import org.group28projectjpa.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String roleName);


}
