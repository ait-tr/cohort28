package org.demointernetshop.controllers.user;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.model.dto.user.UserDto;
import org.demointernetshop.model.dto.user.UserRegistrationDto;
import org.demointernetshop.model.dto.user.UserUpdateDto;
import org.demointernetshop.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public UserDto register(UserRegistrationDto request) {
        return userService.createUser(request);
    }

    @PutMapping("/{userId}")
    public UserDto updateUser(UserUpdateDto request, Integer userId) {
        return userService.updateUser(userId, request);
    }


}
