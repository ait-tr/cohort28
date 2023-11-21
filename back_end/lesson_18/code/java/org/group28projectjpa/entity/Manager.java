package org.group28projectjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String managerName;
    private String password;
    private String email;
    private LocalDateTime createManagerDate;
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Task> tasks;



}
