package org.group28projectjpa.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Manager name must be not blank")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Manager name must contain latin letters and digit only")
    private String managerName;

    @NotBlank(message = "Password name must be not blank")
    @Pattern(regexp = "^[A-Za-z0-9!@#$%^&*()]+$", message = "Password must contain latin letters and digit and some special characters only")
    @Size(min = 5,max = 15, message = "Password length must be between 3 and 15")
    private String password;

    @NotBlank(message = "Email must be not blank")
    @Email(message = "Invalid email format")
    private String email;

    private LocalDateTime createManagerDate;
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;



}
