package lesson14.appExample.core.services;

import lesson14.appExample.DTO.ToDoDtoRequest;
import lesson14.appExample.DTO.ToDoDtoResponse;
import lesson14.appExample.core.util.TodoConverters;
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
public class TodoServices {
    /*
    addTodo
    findAllTodo
    findTodoById
    findTodoByUserId
    updateTodo
    deleteTodo
     */

    private final ToDoRepository repository;
    private final TodoConverters converters;

    public ToDoDtoResponse addTodo(ToDoDtoRequest request){

        ToDo newToDo = converters.converterFromRequestToTodo(request);
        newToDo = repository.save(newToDo);
        return converters.converterFromTodoToResponse(newToDo);

    }



}
