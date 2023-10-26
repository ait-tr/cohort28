package de.ait;

import de.ait.controllers.UserController;
import de.ait.controllers.UserControllerConsoleImp;
import de.ait.repositories.UserRepository;
import de.ait.repositories.UserRepositoryFileImpl;
import de.ait.services.UserService;
import de.ait.services.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        App app = context.getBean(App.class);
        app.start();

        //Scanner scanner = context.getBean(Scanner.class);
        //UserController controller = context.getBean(UserController.class);


        //UserRepository repository = new repositories.UserRepositoryListImpl();
        //UserRepository repository = new UserRepositoryFileImpl("users.txt");
        //UserService service = new UserServiceImpl(repository);
        //UserController controller = new UserControllerConsoleImp(service);



    }

}
