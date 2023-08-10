package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmployeesDataAppl {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("employee.csv"))) {
            String str = br.readLine();
//            System.out.println(str);
            String[] cells = str.split(",");
            printCells(cells);
            str = br.readLine();
            int count = 0;
            double salary = 0;
            long age = 0;
            while (str != null) {
                count++;
                cells = str.split(",");
                salary += Double.parseDouble(cells[2]);
                LocalDate birthDate = LocalDate.parse(cells[3]);
                age += ChronoUnit.YEARS.between(birthDate, LocalDate.now());
                printCells(cells);
                str = br.readLine();
            }
            System.out.println("Total salary: " + salary);
            System.out.println("Total employees: " + count);
            System.out.println("Average salary: " + salary / count);
            System.out.println("Average age: " + 1. * age / count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printCells(String[] cells) {
        for (String string : cells) {
            System.out.print(string + "\t");
        }
        System.out.println();
    }
}
