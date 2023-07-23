package company_employee.model;

public class Manager extends Employee {

	// дополнительные поля
	private double baseSalary;
	private int grade;

	// конструктор
	public Manager(int id, String firstName, String lastName, double hours, double baseSalary, int grade) {
		super(id, firstName, lastName, hours); // это поля от родительского класса
		this.baseSalary = baseSalary;
		this.grade = grade;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public double calcSalary() {
		double salary = baseSalary + hours * grade; // почасовая ставка
		if (salary < hours * minWage) { // если получилось меньше минимальной зарплаты, то назначаем минималку
			salary = hours * minWage;
		}
		return salary;
	}

}
