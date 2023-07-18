package company_employee.dao;

import company_employee.model.Employee;

public interface Company {
	
	boolean addEmployee(Employee employee);

	Employee removeEmployee(int id);

	Employee findEmployee(int id);
	
	double totalSalary();
	
	default double averageSalary() {
		return totalSalary() / size();
	}
	
	double totalSales();
	
	int size();
	
	void printEmployees();
	
	Employee[] findEmployeesHoursGreateThan(int hours);
	
	Employee[] findEmployeesSalaryBetween(double min, double max);
}
