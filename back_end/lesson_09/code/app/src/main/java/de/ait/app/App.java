package de.ait.app;

import de.ait.app.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class App {
private Scanner scanner;
private UserController controller;



    public App(Scanner scanner, UserController controller) {
        this.scanner = scanner;
        this.controller = controller;
    }

    public void start(){
        boolean exit=false;
        while (!exit) {
            System.out.println("Input: 1 - create new user, 2 - print all users, exit - finish program");
            String command = scanner.nextLine();
            switch (command){
                case "exit": exit=true;break;
                case "1": controller.create();break;
                case "2": controller.printAll();break;
            }
        }
    }


}
