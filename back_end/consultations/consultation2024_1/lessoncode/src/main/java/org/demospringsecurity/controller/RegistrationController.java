package org.demospringsecurity.controller;

import org.demospringsecurity.dto.UserRegistrationDto;
import org.demospringsecurity.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto){
        try {
            userService.save(userRegistrationDto);
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/registration?email_invalid";
        }
        return "redirect:/registration?success";
    }
}
