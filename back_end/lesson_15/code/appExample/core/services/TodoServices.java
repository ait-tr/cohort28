package lesson15.appExample.core.services;

import lesson15.appExample.DTO.ToDoDtoRequest;
import lesson15.appExample.DTO.ToDoDtoResponse;
import lesson15.appExample.core.util.TodoConverters;
import lesson15.appExample.entity.ToDo;
import lesson15.appExample.repository.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public List<ToDoDtoResponse> findAll(){
        return repository.findAll().stream()
                .map(converters::converterFromTodoToResponse)
                .toList();
    }

}
