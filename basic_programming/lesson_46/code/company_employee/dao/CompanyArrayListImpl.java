package company_employee.dao;

import company_employee.model.Employee;
import company_employee.model.SalesManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
        // было
//        double sum = 0; // переменная - накопитель
//        for (int i = 0; i < size; i++) { // цикл по списку
//            sum += employees[i].calcSalary(); // копим с вызовом метода для каждого элемента списка
//        }
//        return sum;
        double sum = 0;
        for (Employee employee : employees) {
            sum = sum + employee.calcSalary();
        }
        return sum;
    }

    @Override
    public double totalSales() {
        // было
//        double sum = 0;
//        for (int i = 0; i < size; i++) { // обегаем список сотрудников
//            if (employees[i] instanceof SalesManager) {// ищем тех, кто принадлежит нужному классу
//                SalesManager sm = (SalesManager) employees[i]; // создаем временный объект класса SalesManager
//                sum += sm.getSalesValue(); // накапливаем объем продаж
//            }
//        }
//        return sum;
        double sum = 0;
        for (Employee employee : employees) {
            if (employee instanceof SalesManager) {
                SalesManager sm = (SalesManager) employee;
                sum += sm.getSalesValue();
            }
        }
        return sum;
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
        return findEmployeesByPredicate(e -> e.getHours() >= hours);
    }

    @Override
    public Employee[] findEmployeesSalaryBetween(double min, double max) {
        Predicate<Employee> predicate = new Predicate<>() {
            @Override
            public boolean test(Employee t) {
                return t.calcSalary() >= min && t.calcSalary() < max;
            }
        };
        return findEmployeesByPredicate(predicate);
    }

    private Employee[] findEmployeesByPredicate(Predicate<Employee> batska) {
        int count = 0;

//        for (int i = 0; i < employees.size(); i++) {
//            if (batska.test(employees)) {
//                count++; // количество найденных по условию предиката
//            }
//        }
        for (Employee employee : employees ) {
            if (batska.test(employee)) {
                count++;
            }
        }

        Employee[] res = new Employee[count]; // создаем массив
//        for (int i = 0, j = 0; j < res.length; i++) {
//            if (batska.test(employees[i])) {
//                res[j++] = employees[i];
//            }
//        }
        int j = 0;
        for (Employee employee : employees) {
            if (batska.test(employee)) {
                res[j] = employee;
                j++;
            }
        }
        return res; // это ссылка на полученный массив
    }

}
