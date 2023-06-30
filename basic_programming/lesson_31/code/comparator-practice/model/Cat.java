package model;

public class Cat implements Comparable<Cat>{
    // Cоздать класс Cat, 4 поля +
    // стандартные конструктор, геттеры и сеттеры +
    // toString - переопределить +
    // Создать исполняемый класс для тестирования +
    // создать массив с представителями класса +
    // добавить comparable в класс Cat, переопределить метод
    // compareTo и в итоге отсортировать массив кошек

    String name; // кличка
    int weight; // вес
    String color; // цвет
    int age; // возраст

    public Cat(String name, int weight, String color, int age) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat " + "name= " + name + ", weight=" + weight + ", color= " + color  + ", age=" + age;
    }

    @Override
    public int compareTo(Cat o) { // возвращает int : положительное число, 0, отрицательное число
        int res = this.age - o.age; // сравниваем числовое поле с помощью вычитания
        return res;

//        if (res > 0) {
//            return 1;
//        } else if (res == 0) {
//            return 0;
//        } else {
//            return -1;
//        }

    }
}
