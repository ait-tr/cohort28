package lesson14.appExample.core.util;

import lesson14.appExample.DTO.ToDoDtoRequest;
import lesson14.appExample.DTO.ToDoDtoResponse;
import lesson14.appExample.core.validation.NotFoundException;
import lesson14.appExample.entity.ToDo;
import lesson14.appExample.entity.User;
import lesson14.appExample.repository.ToDoRepository;
import lesson14.appExample.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TodoConverters {

    private final ToDoRepository repository;
    private final UserRepository userRepository;

    public ToDo converterFromRequestToTodo(ToDoDtoRequest request) {

        Optional<User> author = userRepository.findById(request.getUserId());

        if (author.isEmpty()) {
            throw new NotFoundException("Request user id not found");
        }

        ToDo entity = new ToDo();
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setCreationDate(LocalDateTime.now());
        entity.setAuthor(author.get());
        return entity;
    }

    public ToDoDtoResponse converterFromTodoToResponse(ToDo entity) {

        ToDoDtoResponse response = new ToDoDtoResponse();
        response.setId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setDescription(entity.getDescription());
        response.setCreationDate(entity.getCreationDate());
        response.setUserId(entity.getAuthor().getId());
        return response;
    }
}
