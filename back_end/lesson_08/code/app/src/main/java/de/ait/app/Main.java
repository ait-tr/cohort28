package de.ait.app;

import de.ait.app.App;
import de.ait.app.AppConfig;
import de.ait.app.controllers.UserController;
import de.ait.app.controllers.UserControllerConsoleImp;
import de.ait.app.repositories.UserRepository;
import de.ait.app.repositories.UserRepositoryFileImpl;
import de.ait.app.services.UserService;
import de.ait.app.services.UserServiceImpl;
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
