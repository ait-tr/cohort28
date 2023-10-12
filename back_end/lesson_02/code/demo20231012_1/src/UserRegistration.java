import model.User;
import repositories.CrudRepository;
import repositories.UserRepositoryFileImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        //repositories.CrudRepository repository = new repositories.UserRepositoryListImpl();
        CrudRepository repository = new UserRepositoryFileImpl("users.txt");


        while (true) {
            System.out.print("Enter name (or 'exit' to quit): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            // Email validation
            String email = null;
            while (true) {
                System.out.print("Enter email: ");
                email = scanner.nextLine();

                if (isValidEmail(email)) {
                    break;
                } else {
                    System.out.println("Email must contain the '@' symbol. Please enter a valid email.");
                }
            }

            User user = new User(name, email);
            repository.save(user);
        }
        //saveUsersToFile(users, "src/users.txt");

        System.out.println(repository.findAll());
    }

    private static void saveUsersToFile(List<User> users, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : users) {
                writer.write(user.getName() + " " + user.getEmail());
                writer.newLine(); // Move to a new line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static boolean isValidEmail(String email) {

        return email != null && email.contains("@");
    }
}
