package ait.employee.dao;

import ait.employee.model.Employee;
import ait.employee.model.SalesManager;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Predicate;

public class CompanyStreamImpl implements Company {
    ReadWriteLock rwLock = new ReentrantReadWriteLock();
    Lock rLock = rwLock.readLock();
    Lock wLock = rwLock.writeLock();
    private Map<Integer, Employee> employees;
    private int capacity;

    public CompanyStreamImpl(int capacity) {
        this.capacity = capacity;
        employees = new HashMap<>();
    }

    //O(1)
    @Override
    public boolean addEmployee(Employee employee) {
        wLock.lock();
        try {
            if (employee == null || quantity() == capacity) {
                return false;
            }
            return employees.putIfAbsent(employee.getId(), employee) == null;
        } finally {
            wLock.unlock();
        }
    }

    //O(1)
    @Override
    public Employee removeEmployee(int id) {
        wLock.lock();
        try {
            return employees.remove(id);
        } finally {
            wLock.unlock();
        }
    }

    //O(1)
    @Override
    public Employee findEmployee(int id) {
        rLock.lock();
        try {
            return employees.get(id);
        } finally {
            rLock.unlock();
        }
    }

    //O(1)
    @Override
    public int quantity() {
        rLock.lock();
        try {
            return employees.size();
        } finally {
            rLock.unlock();
        }
    }

    // O(n)
    @Override
    public double totalSalary() {
        rLock.lock();
        try {
            return employees.values().stream()
                    .mapToDouble(Employee::calcSalary)
                    .sum();
        } finally {
            rLock.unlock();
        }
    }

    // O(n)
    @Override
    public double totalSales() {
        rLock.lock();
        try {
            return employees.values().stream()
                    .filter(e -> e instanceof SalesManager)
                    .map(e -> (SalesManager) e)
                    .mapToDouble(SalesManager::getSalesValue)
                    .sum();
        } finally {
            rLock.unlock();
        }
    }

    // O(n)
    @Override
    public void printEmployees() {
        rLock.lock();
        try {
            employees.values().forEach(e -> System.out.println(e));
        } finally {
            rLock.unlock();
        }
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
        rLock.lock();
        try {
            return employees.values().stream()
                    .filter(batska)
                    .toArray(Employee[]::new);
        } finally {
            rLock.unlock();
        }
    }
}
