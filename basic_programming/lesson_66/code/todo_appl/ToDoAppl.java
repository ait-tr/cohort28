package todo_appl;

import todo_appl.dao.ToDoListImpl;
import todo_appl.model.Menu;
import todo_appl.model.Task;

import java.io.IOException;
import java.util.Scanner;

public class ToDoAppl {
    public static void main(String[] args) throws IOException {
    // greeting
        System.out.println("Welcome to ToDoList Application!");
        ToDoListImpl toDoList = new ToDoListImpl(20);
    // read file
        toDoList.readTasks();
    //начало цикла общения с user
        while(true) {
         // печатаем меню
            Menu.printMenu();
        // считать выбор с клавиатуры
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input your choice: ");
            int choice = scanner.nextInt();
        // вызываем нужные методы
            switch (choice) {
                case 1 : {
                    System.out.println("Tasks:");
                    toDoList.printTasks();
                    break;
                }
                case 2: {
                    scanner.nextLine();
                    System.out.println("Input task: ");
                    String task = scanner.nextLine();
                    Task newTask = new Task(task); // создаем новую задачу
                    toDoList.addTask(newTask); // добавляем задачу
                    // save tasks
                    toDoList.saveTasks();
                    break;
                }
                case 3: {
                    System.out.println("Input task ID: ");
                    int id = scanner.nextInt();
                    Task findedTask = toDoList.findTask(id - 1); // уменьшаем номер задачи на 1, чтобы получить ее индекс
                    System.out.println(findedTask);
                    break;
                }
                case 4: {
                    System.out.println("Input task ID: ");
                    int id = scanner.nextInt();
                    Task removedTask = toDoList.removeTask(id - 1); // уменьшаем номер задачи на 1, чтобы получить ее индекс
                    System.out.println(removedTask + " is removed.");
                    // save file
                    toDoList.saveTasks();
                    break;
                }
                case 5: return;
                default: {
                    System.out.println("Wrong input.");
                }
            }
        }
    }
}
