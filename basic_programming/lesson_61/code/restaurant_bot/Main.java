package restaurant_bot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в наш ресторан!");
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Boolean> tables = new HashMap<Integer, Boolean>();
        // Подготовка к сохранению статуса столов в файле
        String path = "lesson_61/code/restaurant_bot/";
        String fileName = "tables_status.txt";
        // задаем статус столиков: все столики свободны
        tables.put(1, false);
        tables.put(2, false);
        tables.put(3, false);
        tables.put(4, false);
        tables.put(5, false);
        boolean is_full = false; // инициализация переменой - в ресторане есть свободные столики

        while (!is_full) { // начало цикла
            // Проверка на наличие свободных столиков
            is_full = is_full(tables, 5); // значение переменной is_full определяется в методе

            if (!is_full) {
                System.out.println("У нас есть свободные столики!");
            } else {
                System.out.println("Извините, у нас все столики заняты.");
                break;
            }

            print_table_status(tables); // метод печатает статус столов
            System.out.println("Выберите номер столика: " ); // запрос к пользователю
            int table_num = sc.nextInt();
            reserv_table(tables, table_num); // метод, который резервирует стол
            // ________________________
            create_file (path, fileName); // создаем файл
            // ________________________
            save_table_status(tables, path, fileName); // сохраняем статус столов в файле
            // ________________________
            print_table_status(tables);
        }  // конец цикла
        System.out.println("Мест нет, приходите позже.");
    }

    // ======================Methods=========================

    public static void reserv_table(HashMap<Integer, Boolean> map, int num) {
        if (map.get(num).equals(false)) {
            map.put(num,true);
            System.out.println("Столик " + num + " зарезервирован." );
            return;
        } else {
            System.out.println("Столик " + num + " уже зарезервирован." );
            return;
        }
    }

    public static void print_table_status(HashMap<Integer, Boolean> map){
        for (Object i : map.keySet()) {
            String status = "";
            if (map.get(i).equals(true)) {
                status = " зарезервирован ";
            } else {status = " свободен ";
            }
            System.out.println("Столик: " + i + " статус: " + status);
        }
    }

    public static boolean is_full(HashMap<Integer, Boolean> map, int num) {
        boolean is_full = true;
        for ( int i = 1; i < 6; i++) {
            if (map.get(i) == false) {
                is_full = false;
            }
        }
        return is_full;
    }
    public static void save_table_status(HashMap<Integer, Boolean> map, String path, String file_name) {
        try {
            FileWriter myWriter = new FileWriter(path + file_name);
            // записываем статус столиков в файл
            for (Object i : map.keySet()) {
                String status = "";
                if (map.get(i).equals(true)) {
                    status = " зарезервирован ";
                } else {status = " свободен ";
                }
                myWriter.write("Столик: " + i + " статус: " + status + '\n'); // запись в файл и переход на сл. строку
                // System.out.println();
            }
            myWriter.close();
            System.out.println("Успешная запись в файл.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка.");
            e.printStackTrace();
        }
    }

    public static void create_file (String p, String file_name) {
        try {
            File myFile = new File(p + file_name);
            if (myFile.createNewFile()) {
                System.out.println("Файл создан: " + myFile.getName());
            } else {
                System.out.println("Файл уже существует.");
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка.");
            e.printStackTrace();
        }
    }

    //======================================================
}

