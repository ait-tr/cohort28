package org.demointernetshop.services;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.model.dto.user.UserDto;
import org.demointernetshop.model.dto.user.UserRegistrationDto;
import org.demointernetshop.model.dto.user.UserUpdateDto;
import org.demointernetshop.model.entity.User;
import org.demointernetshop.repository.UserRepository;
import org.demointernetshop.services.exceptions.NotFoundException;
import org.demointernetshop.services.utils.DefaultValues;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final DefaultValues defaultValues;
    private final PasswordEncoder passwordEncoder;
    public UserDto createUser(UserRegistrationDto request) {
        User newUser = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(defaultValues.getDefaultRole())
                .createData(LocalDateTime.now())
                .lastVisitData(LocalDateTime.now())
                .build();

        User savedUser = userRepository.save(newUser);

        return buildUserDto(savedUser);

    }

    public UserDto updateUser(Integer userId, UserUpdateDto request) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User with id " + userId + " not found!"));

        existingUser.setUsername(request.getUsername());
        existingUser.setEmail(request.getEmail());
        existingUser.setPhone(request.getPhone());
        existingUser.setPassword(passwordEncoder.encode(request.getPassword()));
        existingUser.setLastVisitData(LocalDateTime.now());
        User sevedUser = userRepository.save(existingUser);

        return buildUserDto(sevedUser);
    }

    private UserDto buildUserDto(User sevedUser) {
        return UserDto.builder()
                .id(sevedUser.getId())
                .username(sevedUser.getUsername())
                .role(sevedUser.getRole().getName().toString())
                .email(sevedUser.getEmail())
                .phone(sevedUser.getPhone())
                .createData(sevedUser.getCreateData())
                .lastVisitData(sevedUser.getLastVisitData())
                .build();
    }


}
