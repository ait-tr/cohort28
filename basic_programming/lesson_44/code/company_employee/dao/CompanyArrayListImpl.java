package company_employee.dao;

import company_employee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class CompanyArrayListImpl implements Company{

    // было
//    Employee[] employees;
//    int size;

    // стало
    List<Employee> employees;
    int capacity;

    // конструктор
    // было
//    public CompanyImpl(int capacity) {
//        employees = new Employee[capacity];
//    }
//
    // стало

    public CompanyArrayListImpl(int capacity) {
        employees = new ArrayList<>(); // создаем новый список сотрудников, кот называется employees
        this.capacity = capacity;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        // было
//        if (employee == null || size == employees.length || findEmployee(employee.getId()) != null) {
        // передали пустой объект ИЛИ достигли конца массива ИЛИ если у нас такой сотрудник уже есть
//            return false;
//        }
//        employees[size++] = employee;
//        return true;

        // стало
        if (employee == null || employees.size() == capacity || findEmployee(employee.getId()) != null){
           return false;
        }
        employees.add(employee); // доавили сотрудника в список
        return true;
    }

    @Override
    public Employee removeEmployee(int id) {
// было
//        for (int i = 0; i < size; i++) {
//            if (employees[i].getId() == id) { // ищем элемент массива
//                Employee victim = employees[i]; // убираем в переменную, чтобы вернуть из метода
//                employees[i] = employees[--size]; // последнего из массива ставили на место удаленного
//                employees[size] = null; // обнуляем последнего
//                return victim;
//            }
//        }
//        return null;
//
        // стало
        Employee victim = findEmployee(id);
        if  (victim != null) {
            employees.remove(victim);  // удаляем сотрудника
            return victim;
        }
        return null;
    }

    @Override
    public Employee findEmployee(int id) {
        // было
//        for (int i = 0; i < size; i++) {
//            if (employees[i].getId() == id) {
//                return employees[i];
//            }
//        }
//        return null;

        // стало
        // цикл for each
        for (Employee employee: employees) { // взяли из класса Employee итератор employee и проходим по списку employees
            if(employee.getId() == id){
                return employee; // вернули сотрудника
            }
        }
        return null;
    }

    @Override
    public double totalSalary() {
        return 0;
    }

    @Override
    public double totalSales() {
        return 0;
    }

    @Override
    public int size() {
        // было
        // return size;

        // cтало
        return employees.size();
    }

    @Override
    public void printEmployees() {
        // было
//        for (int i = 0; i < size; i++) {
//            System.out.println(employees[i]);
//        }

        // стало
        for ( Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public Employee[] findEmployeesHoursGreateThan(int hours) {
        return new Employee[0];
    }

    @Override
    public Employee[] findEmployeesSalaryBetween(double min, double max) {
        return new Employee[0];
    }
}
