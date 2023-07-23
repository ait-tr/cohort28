package company_employee.dao;

import company_employee.model.Employee;

public interface Company {

	// перечень действий - методов
	
	boolean addEmployee(Employee employee); // берем на работу, добавляем в ...

	Employee removeEmployee(int id); // увольняем, удаляем из ...

	Employee findEmployee(int id); // ищем по ID
	
	double totalSalary(); // месячный ФОТ
	
	default double averageSalary() {
		return totalSalary() / size();
	} // средняя разплата по компании
	
	double totalSales(); // объем продаж за месяц
	
	int size(); // сколько работников в компании
	
	void printEmployees(); // печать списка работников
	
	Employee[] findEmployeesHoursGreateThan(int hours); // ищем "Стахановцев"
	
	Employee[] findEmployeesSalaryBetween(double min, double max); // ищем сотрудников с з/п от ... и до ...
}
