package todo_appl.dao;

import todo_appl.model.Task;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ToDoList {
    // add Task
    boolean addTask(Task task);

    // find Task
    Task findTask(int id);

    // remove Task
    Task removeTask(int id);

    // print Task
    void printTasks();

    // quantity of task
    int quantity();

    // read Tasks
    void readTasks() throws IOException;

    // save Tasks
    void saveTasks() throws IOException;
}
