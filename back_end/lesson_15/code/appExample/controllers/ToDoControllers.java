package lesson15.appExample.controllers;


import lesson15.appExample.DTO.ToDoDtoRequest;
import lesson15.appExample.DTO.ToDoDtoResponse;
import lesson15.appExample.core.services.TodoServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ToDoControllers {

    private final TodoServices todoServices;

    @PostMapping("/todo")
    public ToDoDtoResponse addTodo(@RequestBody ToDoDtoRequest request){
        return todoServices.addTodo(request);
    }

    @GetMapping("/todo/{id}")
    public ToDoDtoResponse findTodoById(@PathVariable("id") Integer id){
        return todoServices.findById(id);
    }

    @GetMapping("/todo")
    public List<ToDoDtoResponse> findAllTodos(){
        return todoServices.findAll();
    }

    @GetMapping("/todo/user")
    public List<ToDoDtoResponse> findTodoByUserId(@RequestParam Integer userId){
        return todoServices.findTodoByUserId(userId);
    }

    @PutMapping("/todo/{id}")
    public ToDoDtoResponse updateTodo(@PathVariable ("id") Integer id,  @RequestBody ToDoDtoRequest updateRequest){
        return todoServices.updateToDo(id, updateRequest);
    }

      @DeleteMapping("/todo")
    public boolean deleteTodoById(@RequestParam Integer id){
        return todoServices.delete(id);
    }


}
