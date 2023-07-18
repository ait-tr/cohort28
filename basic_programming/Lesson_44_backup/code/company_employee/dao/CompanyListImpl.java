package company_employee.dao;

import company_employee.model.Employee;
import company_employee.model.SalesManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CompanyListImpl implements Company {
	List<Employee> employees; // поле, новый список
	int capacity; // поле, размер списка

	public CompanyListImpl(int capacity) { // метод - конструктор
		employees = new ArrayList<>(); // создаем новый список типа ArrayList
		this.capacity = capacity; // задаем ему capacity
	}

	@Override
	public boolean addEmployee(Employee employee) {

		// было
//		if (employee == null || size == employees.length || findEmployee(employee.getId()) != null) {
//			return false;
//		}
//		employees[size++] = employee;
//		return true;

		// стало
		if (employee == null || employees.size() == capacity || findEmployee(employee.getId()) != null) {
			// если работник null, или нет места, или такой сотрудник уже есть
			return false;  // вернуть негатив и выйти из метода
		} // иначе
		employees.add(employee); // добавляем в список сотрудника
		return true;
	}

	@Override // удаление по id
	public Employee removeEmployee(int id) {
		// было
//		for (int i = 0; i < size; i++) {
//			if (employees[i].getId() == id) {
//				Employee victim = employees[i]; // нашли жертву
//				employees[i] = employees[--size]; // последний элмент ставим на место жертвы
//				employees[size] = null; // последний элемент затираем
//				return victim; // возвращаем жертву
//			}
//		}
//		return null;

		Employee victim = findEmployee(id); // найти сотрудника в списке
		if (victim != null) { // если он не null, то
			employees.remove(victim); // удалить сотрудника
		}
		return victim; // вернуть удаленный элемент списка
	}

	@Override
	public Employee findEmployee(int id) {
		// было
//		for (int i = 0; i < size; i++) {
//			if (employees[i].getId() == id) {
//				return employees[i];
//			}
//		}
//		return null;

		// стало
		for (Employee employee : employees) { // цикл for each, обегаем список сотрудников
			if(employee.getId() == id) {  // если нашелся сотрудник с таким id, то
				return employee; // вернули сотрудника
			}
		}
		return null; // иначе вернули null
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
		// было
//		for (int i = 0; i < size; i++) {
//			System.out.println(employees[i]);
//		}
		// стало
		for (Employee employee : employees) { // цикл for each
			System.out.println(employee);
		}
	}

	@Override
	public Employee[] findEmployeesHoursGreateThan(int hours) {
		// было
		// return findEmployeesByPredicate(e -> e.getHours() >= hours);
		// стало
		return findEmployeesByPredicate(e -> e.getHours() >= hours);
	}

	@Override
	public Employee[] findEmployeesSalaryBetween(double min, double max) {
		// было
//		Predicate<Employee> predicate = new Predicate<>() {
//			@Override
//			public boolean test(Employee t) {
//				return t.calcSalary() >= min && t.calcSalary() < max;
//			}
//		};
//		return findEmployeesByPredicate(predicate);
		// стало
		Predicate<Employee> predicate = new Predicate<>() {

			@Override
			public boolean test(Employee t) {
				return t.calcSalary() >= min && t.calcSalary() < max;
			}
		};
		return findEmployeesByPredicate(predicate);
	}
	
	private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
		// было
//		int count = 0;
//		for (int i = 0; i < size; i++) {
//			if (batska.test(employees[i])) {
//				count++;
//			}
//		}
//		Employee[] res = new Employee[count];
//		for (int i = 0, j = 0; j < res.length; i++) {
//			if (batska.test(employees[i])) {
//				res[j++] = employees[i];
//			}
//		}
//		return res;
		// стало
		ArrayList<Employee> res = new ArrayList<>();
		for (Employee employee : employees) {
			if(predicate.test(employee)) {
				res.add(employee);
			}
		}
		return res.toArray(new Employee[res.size()]);
	}

}
