package lesson15.appExample.core.services;

import lesson15.appExample.DTO.UserDtoRequest;
import lesson15.appExample.core.validation.IsAlreadyExistException;
import lesson15.appExample.core.validation.NotFoundException;
import lesson15.appExample.entity.User;
import lesson15.appExample.repository.UserRepository;
import lesson15.appExample.DTO.UserDtoResponse;
import lesson15.appExample.core.util.UserConverters;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServices {
    private final UserRepository userRepository;
    private final UserConverters converters;


    // Получить список всех пользователей

    public List<UserDtoResponse> findAllUsers() {
        return userRepository.findAll().stream()
                .map(converters::converterFromUserToResponse)
                .toList();
    }

    //Найти пользователя по email

    public UserDtoResponse findUserByEmail(String email){
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            return converters.converterFromUserToResponse(userOptional.get());
        } else {
            throw new NotFoundException("User not found with email: " + email);
        }
    }

    // Создать нового пользователя

    public UserDtoResponse createUser(UserDtoRequest request){
        if (userRepository.findByEmail(request.getEmail()).isEmpty()) {
            User newUser = converters.converterFromRequestToUser(request);

            User sevedUser = userRepository.save(newUser);
            return converters.converterFromUserToResponse(sevedUser);
        } else {
            throw new IsAlreadyExistException("User with email: " + request.getEmail() + " is already exist!");
        }
    }

}
