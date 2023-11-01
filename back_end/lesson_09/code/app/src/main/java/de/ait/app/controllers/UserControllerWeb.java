package de.ait.app.controllers;

import de.ait.app.services.UserService;
import de.ait.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserControllerWeb {
    @Autowired
    private UserService service;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/qwe")
    public String blablabla(){
        return "hello";
    }

    @PostMapping ("/users")
    public String createUser(@RequestParam("user_name") String name, @RequestParam String email){
        System.out.println("Start add user: " + name + " "+ email);
        service.createUser(name,email);

        return "redirect:/users";  // переход на /users
    }

    @GetMapping("/users")
    public String listUsers(Model model){
        List<User> allUsers = service.getAllUsers();
        model.addAttribute("users", allUsers);
        return "all_uses_view";
    }

    @GetMapping("/users/{id}")
    public String listUsers(@PathVariable Long id, Model model){
        List<User> allUsers = service.getAllUsers().stream()
                .filter(u->u.getId().equals(id))
                .toList();
        model.addAttribute("users", allUsers);
        model.addAttribute("id", id);
        return "id_uses_view";
    }

    @DeleteMapping("/users/{id}")
    public String listUsers(@PathVariable Long id){

        System.out.println("Delete " + service.getAllUsers().get(id.intValue()));

        return "redirect:/users";
    }

}
