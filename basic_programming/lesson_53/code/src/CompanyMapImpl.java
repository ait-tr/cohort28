package ait.employee.dao;

import ait.employee.model.Employee;
import ait.employee.model.SalesManager;

import java.util.*;
import java.util.function.Predicate;

public class CompanyMapImpl implements Company {
    private Map<Integer, Employee> employees;
    private int capacity;

    public CompanyMapImpl(int capacity) {
        this.capacity = capacity;
        employees = new HashMap<>();
    }

    //O(1)
    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null || employees.size() == capacity || employees.containsKey(employee.getId())) {
            return false;
        }
        employees.put(employee.getId(), employee);
        return true;
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
        Collection<Employee> values = employees.values();
        double sum = 0;
        for (Employee employee : values) {
            sum += employee.calcSalary();
        }
        return sum;
    }

    // O(n)
    @Override
    public double totalSales() {
        Collection<Employee> values = employees.values();
        double sum = 0;
        for (Employee employee : values) {
            if (employee instanceof SalesManager) {
                SalesManager sm = (SalesManager) employee;
                sum += sm.getSalesValue();
            }
        }
        return sum;
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
        Collection<Employee> values = employees.values();
        List<Employee> res = new ArrayList<>();
        for (Employee employee: values) {
            if(batska.test(employee)){
                res.add(employee);
            }
        }
        return res.toArray(new Employee[0]);
    }
}
