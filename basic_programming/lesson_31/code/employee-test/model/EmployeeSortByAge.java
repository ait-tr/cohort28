package model;

import java.util.Comparator;

public class EmployeeSortByAge implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.age == o2.age) {
            return 0;
        } else if (o1.age < o2.age) {
            return -1;
        } else {
            return 1;
        }
    }
}
