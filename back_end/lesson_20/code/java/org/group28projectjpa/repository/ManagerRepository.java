package org.group28projectjpa.repository;

import org.group28projectjpa.domain.entity.Manager;
import org.group28projectjpa.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Optional<Manager> findByEmail (String email);

    Optional<Manager> findByManagerName(String managerName);

}
