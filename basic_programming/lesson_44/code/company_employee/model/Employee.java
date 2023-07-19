package company_employee.model;

public abstract class Employee {

	// поля класса
	protected static double minWage = 30; // ставка в евро
	protected final int id; // это хорошо
	protected String firstName;
	protected String lastName;
	protected double hours;

	// методы
	// метод - конструктор
	public Employee(int id, String firstName, String lastName, double hours) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hours = hours;
	}

	public static double getMinWage() {
		return minWage;
	}

	public static void setMinWage(double minWage) {
		Employee.minWage = minWage;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public int getId() {
		return id;
	}
	
	public abstract double calcSalary(); // этот метод будет требоваться реализовать в дочерних классах

	@Override
	public String toString() {
		return "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + calcSalary();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	// метод обеспечивает сравнение объектов класса Employee
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (id != other.id) { // сравнение по ID работника
			return false;
		}
		return true;
	}
}
