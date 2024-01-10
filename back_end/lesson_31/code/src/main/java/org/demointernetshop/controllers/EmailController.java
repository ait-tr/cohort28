package org.demointernetshop.controllers;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.model.entity.email.EmailRequest;

import org.demointernetshop.services.mail.DemoInternetMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final DemoInternetMailSender mailSender;


    @PostMapping("/send-mail")
    public String sendEmail(@RequestBody EmailRequest request){
        mailSender.send(request.getTo(), request.getSubject(), request.getText());
        return  "Email sent successfully!";
    }
}
