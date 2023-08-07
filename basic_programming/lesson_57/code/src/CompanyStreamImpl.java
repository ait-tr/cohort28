package ait.employee.dao;

import ait.employee.model.Employee;
import ait.employee.model.SalesManager;

import java.util.*;
import java.util.function.Predicate;

public class CompanyStreamImpl implements Company{
    private Map<Integer, Employee> employees;
    private int capacity;

    public CompanyStreamImpl(int capacity) {
        this.capacity = capacity;
        employees = new HashMap<>();
    }

    //O(1)
    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null || employees.size() == capacity) {
            return false;
        }
        return employees.putIfAbsent(employee.getId(), employee) == null;
    }

    //O(1)
    @Override
    public Employee removeEmployee(int id) {
        return employees.remove(id);
    }

    //O(1)
    @Override
    public Employee findEmployee(int id) {
        return employees.get(id);
    }

    //O(1)
    @Override
    public int quantity() {
        return employees.size();
    }

    // O(n)
    @Override
    public double totalSalary() {
        return employees.values().stream()
//                .map(e -> e.calcSalary())
                .mapToDouble(Employee::calcSalary)
                .sum();
    }

    // O(n)
    @Override
    public double totalSales() {
        return employees.values().stream()
                .filter(e -> e instanceof SalesManager)
                .map(e -> (SalesManager) e)
                .mapToDouble(SalesManager::getSalesValue)
                .sum();
    }

    // O(n)
    @Override
    public void printEmployees() {
        employees.values().forEach(e -> System.out.println(e));
    }

    //O(n)
    @Override
    public Employee[] findEmployeesHoursGreaterThan(int hours) {
        return findEmployeesByPredicate(e -> e.getHours() >= hours);
    }

    //O(n)
    @Override
    public Employee[] findEmployeesSalaryRange(int min, int max) {
        return findEmployeesByPredicate(e -> e.calcSalary() >= min && e.calcSalary() < max);
    }

    private Employee[] findEmployeesByPredicate(Predicate<Employee> batska) {
        return employees.values().stream()
                .filter(batska)
                .toArray(Employee[]:: new);
    }
}
