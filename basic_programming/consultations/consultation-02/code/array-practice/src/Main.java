public class Main {
    public static void main(String[] args) {
        System.out.println("Print array reverse (backward)");
        int[] myarray = new int[10]; // объявили массив целых чисел

        String[] name = new String[2]; // объявили массив типа String для примера
        name[0] = "Елена";
        name[1] = "Станислав";

        // печатаем массив name для примера
        printArrayString(name);

        // заполнение массива
        fillArray(myarray, -50, 50);

        // печатаем массив
        printArray(myarray);

        // печатаем массив в обратном порядке
        printArrayReverce(myarray);

    }
    // ___________Methods__________
    // метод печатает массив данных типа String
    public static void printArrayString(String [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t" + "\t" + "\t");
        }
        System.out.println();
    }


    // метод печатает массив
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    // Метод печатает массив наоборот
    public static void printArrayReverce(int[] arr) { // Backward
        for (int i = arr.length - 1; i >= 0; i--) { // пробегаем от последнего индекса до 0-го
            System.out.print(arr[i] + "\t"); // "\t" - это символ табуляции, между элементами массива на печати будет расстояние
        }
        System.out.println(); // переход на новую строку
    }

    // Метод заполняет массив случайными числами от min, max
    public static void fillArray(int[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) { // пробегаем массив от 0-го индекса до последнего
            arr[i] = (int) (min + Math.random() * (max + 1 - min));
        }
    }

    // _______end of Methods____________
}