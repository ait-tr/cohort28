package de.ait.app.controllers;

import de.ait.app.services.UserService;
import de.ait.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
