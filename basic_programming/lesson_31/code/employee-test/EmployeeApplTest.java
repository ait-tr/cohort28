import model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;

public class EmployeeApplTest {
    Company company;
    Employee[] empl;

    int[] empAge = {35, 30, 45, 28, 20};


    @BeforeEach
    void setUp() {
        company = new CompanyImpl(10);
        empl = new Employee[10];
        empl[0] = new Employee(1000L, "John", 35, 5);
        empl[1] = new Employee(1000L, "Ann", 30, 5);
        empl[2] = new Employee(1000L, "Peter", 45, 5);
        empl[3] = new Employee(1000L, "Robin", 28, 5);
        empl[4] = new Employee(1000L, "Mike", 20, 5);
//        empl[0] = new Manager(1000L, "John", 35, 5, 25000, 3,40);
//        empl[1] = new Manager(2000L, "Ann", 30, 3, 36000, 4, 40 );
//        empl[2] = new Manager(3000L, "Peter", 45, 10, 25000, 3, 40);
//        empl[3] = new Manager(4000L, "Rabindranat", 28, 4, 20000, 5, 40);
        for (int i = 0; i < empl.length; i++) {
            company.addEmployee(empl[i]);
        }
    }

    @Test
    void addEmployee() {

    }

    @Test
    void removeEmployee() {

    }

    @Test
    void findEmployee() {

    }

    @Test
    void printEmployees() {

    }

    @Test
    void findEmployeesSalaryRange(){

    }

    @Test
    void testSortEmplByAge() {
        System.out.println("===== test SortEmplByAge =====");
        //ArrayTools.bubbleSort(soldiers, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        Arrays.sort(empAge);
        for (int i = 0; i < empAge.length; i++) {
            System.out.println(empAge[i]);
        }
    }
}
