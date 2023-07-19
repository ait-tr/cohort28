package company_employee.dao;

import company_employee.model.Employee;
import company_employee.model.SalesManager;

import java.util.function.Predicate;

public class CompanyImpl implements Company {
	Employee[] employees;
	int size;

	public CompanyImpl(int capacity) {
		employees = new Employee[capacity];
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if (employee == null || size == employees.length || findEmployee(employee.getId()) != null) {
			return false;
		}
		employees[size++] = employee;
		return true;
	}

	@Override
	public Employee removeEmployee(int id) {
		for (int i = 0; i < size; i++) {
			if (employees[i].getId() == id) {
				Employee victim = employees[i];
				employees[i] = employees[--size];
				employees[size] = null;
				return victim;
			}
		}
		return null;
	}

	@Override
	public Employee findEmployee(int id) {
		for (int i = 0; i < size; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		return null;
	}

	@Override
	public double totalSalary() {
		double sum = 0;
		for (int i = 0; i < size; i++) {
			sum += employees[i].calcSalary();
		}
		return sum;
	}

	@Override
	public double totalSales() {
		double sum = 0;
		for (int i = 0; i < size; i++) {
			if (employees[i] instanceof SalesManager) {
				SalesManager sm = (SalesManager) employees[i];
				sum += sm.getSalesValue();
			}
		}
		return sum;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void printEmployees() {
		for (int i = 0; i < size; i++) {
			System.out.println(employees[i]);
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
		for (int i = 0; i < size; i++) {
			if (batska.test(employees[i])) {
				count++; // количество найденных по условию предиката
			}
		}
		Employee[] res = new Employee[count];
		for (int i = 0, j = 0; j < res.length; i++) {
			if (batska.test(employees[i])) {
				res[j++] = employees[i];
			}
		}
		return res;
	}

}
