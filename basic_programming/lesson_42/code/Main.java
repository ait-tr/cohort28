import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(15);
        // добавление элемента в конец
        words.add("Marsel");
        words.add("Hello");
        words.add("Bye");
        words.add("Marsel");
        System.out.println(words);

        System.out.println("вывести размер списка");
        System.out.println(words.size());

        System.out.println("проверим, содержится ли какой-либо элемент в списке");
        System.out.println(words.contains("Hello"));
        System.out.println(words.contains("Java"));

        System.out.println("удаление конкретного элемента");
        words.remove("Hello");
        System.out.println(words);

        System.out.println("добавление по индексу");
        words.add(1, "Java");
        System.out.println(words);

        System.out.println(words.get(1));

        System.out.println("узнать индекс элемента");
        System.out.println(words.indexOf("Marsel"));
        System.out.println(words.lastIndexOf("Marsel"));
        System.out.println(words.indexOf("JavaScript"));

        System.out.println("удаление элемента по индексу");
        words.remove(2);
        System.out.println(words);

        System.out.println("замена элемента по индексу");
        words.set(1, "Marsel");
        System.out.println(words);

        System.out.println("проверим, пустой ли список");
        System.out.println(words.isEmpty());
        System.out.println("очистка списка");
        words.clear();
        System.out.println(words.size());
        System.out.println(words.isEmpty());
        System.out.println(words);
    }
}