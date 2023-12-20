package org.demointernetshop.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.demointernetshop.entity.User;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "User", description = "User data")
public class UserDto {
    @Schema(description = "User identifier", example = "1")
    private Integer id;

    @Schema(description = "Username of the user", example = "Igor123")
    private String username;

    @Schema(description = "Role of the user", example = "CLIENT")
    private String role;

    @Schema(description = "User's email", example = "user@mail.com")
    private String email;

    @Schema(description = "Phone number of the user", example = "+1234567890")
    private String phone;

    @Schema(description = "The date and time when the object was created", example = "2023-12-01T15:30:45")
    private LocalDateTime createData;

    @Schema(description = "The date and time of the user's last visit", example = "2023-12-02T20:15:30")
    private LocalDateTime lastVisitData;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole().getName().toString())
                .email(user.getEmail())
                .phone(user.getPhone())
                .createData(user.getCreateData())
                .lastVisitData(user.getLastVisitData())
                .build();
    }
}