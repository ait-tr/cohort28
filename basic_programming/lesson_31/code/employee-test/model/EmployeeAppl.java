package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EmployeeAppl {
    public static void main(String[] args) {
       Employee empl1 = new Employee(1000L, "John", 35, 5);
       Employee empl2 = new Employee(1000L, "Ann", 30, 5);
       Employee empl3 = new Employee(1000L, "Peter", 45, 5);
       Employee empl4 = new Employee(1000L, "Robin", 28, 5);
       Employee empl5 = new Employee(1000L, "Mike", 20, 5);

       Employee[] em = new Employee[10];
       em[0] = empl1;
       em[1] = empl2;
       em[2] = empl3;
       em[3] = empl4;
       em[4] = empl5;

        // Arrays.sort(em);

        System.out.println(em);

    }
}
