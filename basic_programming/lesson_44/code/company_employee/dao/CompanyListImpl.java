package company_employee.dao;

import company_employee.model.Employee;
import company_employee.model.SalesManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CompanyListImpl implements Company {
	List<Employee> employees;
	int capacity;

	public CompanyListImpl(int capacity) {
		employees = new ArrayList<>();
		this.capacity = capacity;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if (employee == null || employees.size() == capacity || findEmployee(employee.getId()) != null) {
			return false;
		}
		employees.add(employee);
		return true;
	}

	@Override
	public Employee removeEmployee(int id) {
		Employee victim = findEmployee(id);
		if (victim != null) {
			employees.remove(victim);
		}
		return victim;
	}

	@Override
	public Employee findEmployee(int id) {
		for (Employee employee : employees) {
			if(employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public double totalSalary() {
		double sum = 0;
		for (Employee employee : employees) {
			sum += employee.calcSalary();
		}
		return sum;
	}

	@Override
	public double totalSales() {
		double sum = 0;
		for (Employee employee : employees) {
			if(employee instanceof SalesManager) {
				SalesManager sm = (SalesManager) employee;
				sum += sm.getSalesValue();
			}			
		}
		return sum;
	}

	@Override
	public int size() {
		return employees.size();
	}

	@Override
	public void printEmployees() {
		for (Employee employee : employees) {
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
	
	private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
		ArrayList<Employee> res = new ArrayList<>();
		for (Employee employee : employees) {
			if(predicate.test(employee)) {
				res.add(employee);
			}
		}
		return res.toArray(new Employee[res.size()]);
	}

}
