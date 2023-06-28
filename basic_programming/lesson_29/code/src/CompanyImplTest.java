package ait.employee.test;

import ait.employee.dao.Company;
import ait.employee.dao.CompanyImpl;
import ait.employee.model.Employee;
import ait.employee.model.Manager;
import ait.employee.model.SalesManager;
import ait.employee.model.WageEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyImplTest {
    Company company;
    Employee[] firm;

    @BeforeEach
    void setUp() {
        company = new CompanyImpl(5);
        firm = new Employee[4];
        firm[0] = new Manager(1000, "John", "Smith", 160, 5000, 5);
        firm[1] = new WageEmployee(2000, "Ann", "Smith", 160, 15);
        firm[2] = new SalesManager(3000, "Peter", "Jackson", 160, 25000, 0.1);
        firm[3] = new SalesManager(4000, "Rabindranat", "Anand", 80, 20000, 0.1);
        for (int i = 0; i < firm.length; i++) {
            company.addEmployee(firm[i]);
        }
    }

    @Test
    void addEmployee() {
        assertFalse(company.addEmployee(null));
        assertFalse(company.addEmployee(firm[1]));
        Employee employee = new SalesManager(5000, "Rabindranat", "Anand", 80, 20000, 0.1);
        assertTrue(company.addEmployee(employee));
        assertEquals(5, company.quantity());
        employee = new SalesManager(6000, "Rabindranat", "Anand", 80, 20000, 0.1);
        assertFalse(company.addEmployee(employee));
    }

    @Test
    void removeEmployee() {
        assertEquals(firm[2], company.removeEmployee(3000));
        assertEquals(3, company.quantity());
        assertNull(company.removeEmployee(3000));
        assertNull(company.findEmployee(3000));
    }

    @Test
    void findEmployee() {
        assertEquals(firm[1], company.findEmployee(2000));
        assertNull(company.findEmployee(5000));
    }

    @Test
    void quantity() {
        assertEquals(4, company.quantity());
    }

    @Test
    void totalSalary() {
        assertEquals(12700, company.totalSalary(), 0.01);
    }

    @Test
    void avgSalary() {
        assertEquals(12700. / 4, company.avgSalary(), 0.01);
    }

    @Test
    void totalSales() {
        assertEquals(45000, company.totalSales());
    }

    @Test
    void printEmployees() {
        System.out.println(Company.NAME);
        company.printEmployees();
    }

    @Test
    void findEmployeesHoursGreaterThan() {
        Employee[] actual = company.findEmployeesHoursGreaterThan(100);
        Employee[] expected = {firm[0], firm[1], firm[2]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findEmployeesSalaryRange(){
        Employee[] actual = company.findEmployeesSalaryRange(2000, 2500);
        Employee[] expected = {firm[1], firm[3]};
        assertArrayEquals(expected, actual);
    }
}
