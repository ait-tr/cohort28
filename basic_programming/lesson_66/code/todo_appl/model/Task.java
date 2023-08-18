package todo_appl.model;

import java.util.Objects;

public class Task implements Comparable<Task>{

    // поля
    private int id;
    private String task;
    private static int nextId;

    // data, importance, status - это на развитие (версия 2.0)

    // конструктор
    public Task(String task) {
        this.id = nextId++; // автонумерация задач
        this.task = task;
    }

    // геттеры и сеттеры
    public int getId() {
        return id;
    }

    // нужен для перенумерации
    public void setId(int id) {
        this.id = id;
    }
    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return (id + 1) + " : " + task; // это отображение, которое нам нужно
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Task o) {
        return this.id - o.id; // по id, от меньшего к большему
    }

}
