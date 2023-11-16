package lesson15.appExample.core.services;

import lesson15.appExample.DTO.ToDoDtoRequest;
import lesson15.appExample.DTO.ToDoDtoResponse;
import lesson15.appExample.core.util.TodoConverters;
import lesson15.appExample.core.validation.NotFoundException;
import lesson15.appExample.entity.ToDo;
import lesson15.appExample.repository.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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


    public List<ToDoDtoResponse> findAll(){
        return repository.findAll().stream()
                .map(converters::converterFromTodoToResponse)
                .toList();
    }

    //     findTodoById

    public ToDoDtoResponse findById(Integer id) {

        Optional<ToDo> toDoOptional = repository.findById(id);

        if (toDoOptional.isPresent()) {
            return converters.converterFromTodoToResponse(toDoOptional.get());
        } else {
            throw new NotFoundException("ToDo with id " + id + " not found");
        }

    }

    //findTodoByUserId

    public List<ToDoDtoResponse> findTodoByUserId(Integer userId){
        return repository.findByUserId(userId)
                .stream().map(converters::converterFromTodoToResponse)
                .toList();
    }

    //updateTodo
    public ToDoDtoResponse updateToDo(Integer id, ToDoDtoRequest toDoRequest) {
        Optional<ToDo> toDoOptional = repository.findById(id);
        if (toDoOptional.isPresent()) {
            ToDo todoForUpdate = toDoOptional.get();
            if (toDoRequest.getTitle() != null) {todoForUpdate.setTitle(toDoRequest.getTitle());}
            if (toDoRequest.getDescription() != null) {todoForUpdate.setDescription(toDoRequest.getDescription());}
            ToDo updateToDo = repository.save(todoForUpdate);
            return converters.converterFromTodoToResponse(updateToDo);
        } else {
            throw new NotFoundException("ToDo with id " + id + " not found");
        }
    }

    /*
    public ToDoDtoResponse updateToDo (ToDoDtoRequest request){
        ToDo toDo = converters.converterFromRequestToTodo(request);
        repository.update(toDo);
        return converters.converterFromTodoToResponse(repository.findById(toDo.getId()).get());
    }
     */

    //deleteTodo

    public boolean delete(Integer id) {
        Optional<ToDo> toDoOptional = repository.findById(id);
        if (toDoOptional.isEmpty()) {
            throw new NotFoundException("ToDo with id " + id + " not found");
        }
        repository.delete(id);
        return true;


    }


}
