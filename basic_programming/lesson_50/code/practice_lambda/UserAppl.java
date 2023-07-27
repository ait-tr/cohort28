package practice_lambda;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class UserAppl {
    public static void main(String[] args) {
        List<User> userList = Arrays.asList( // список User, создаваемый как объект из класса Arrays
                new User("Alice", 25),
                new User("Aob", 15),
                new User("Alex", 22),
                new User("Eve", 19),
                new User("Anna", 16),
                new User("John", 28)
        );
//  Ваша задача - создать список пользователей - ОК,
//  выполнить фильтрацию с помощью лямбда-выражений и вывести результат на экран.
//  Найти всех пользователей старше 18 лет.
//  Найти всех пользователей младше 30 лет с именем, начинающимся на букву "A".
        // печать с помощью цикла for each
        for (User name : userList ) {
            System.out.println(name);
        }

        System.out.println();

        // чтобы получить результат, надо сформировать новый список
        List<User> userList1 = findUsersByPredicate(userList, user -> user.getAge() > 18); // это лямбда - выражение

        for (User user : userList1 ) {
            System.out.println(user);
        }

        System.out.println();
        List<User> userList2 = findUsersByPredicate(userList, user -> user.getAge() < 30 && user.getName().charAt(0) == 'A'); // это лямбда - выражение
        for (User user : userList2 ) {
            System.out.println(user);
        }
    }

    private static List<User> findUsersByPredicate(List<User> userList, Predicate<User> predicate) {
        List<User> res = new ArrayList<>();// создаем новый список типа ArrayList
        for (User user : userList) { // запускаем цикл
            if(predicate.test(user)) { // проверяем услоие предиката
                res.add(user);  // добавляем, найденного по условию предиката
            }
        }
        return res; // возвращаем ArrayList
    }

}
