import controllers.UserController;
import controllers.UserControllerConsoleImp;
import repositories.UserRepository;
import repositories.UserRepositoryFileImpl;
import services.UserService;
import services.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //UserRepository repository = new repositories.UserRepositoryListImpl();
        UserRepository repository = new UserRepositoryFileImpl("users.txt");
        UserService service = new UserServiceImpl(repository);
        UserController controller = new UserControllerConsoleImp(service);

        Scanner scanner = new Scanner(System.in);
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
