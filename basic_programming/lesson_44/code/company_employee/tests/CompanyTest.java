package company_employee.tests;

import company_employee.dao.Company;
import company_employee.dao.CompanyArrayListImpl;
import company_employee.dao.CompanyImpl;
import company_employee.model.Employee;
import company_employee.model.Manager;
import company_employee.model.SalesManager;
import company_employee.model.WageEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
	Company company;
	Employee[] firm;

	@BeforeEach
	void setUp() throws Exception {
		company = new CompanyArrayListImpl(5);
		firm = new Employee[4];
		firm[0] = new Manager(1000, "John", "Smith", 182, 20_000, 20);
		firm[1] = new WageEmployee(2000, "Mary", "Smith", 182, 40);
		firm[2] = new SalesManager(3000, "Peter", "Jackson", 182, 40_000, 0.1);
		firm[3] = new SalesManager(4000, "Tigran", "Petrosian", 91, 80_000, 0.1);
		for (int i = 0; i < firm.length; i++) {
			company.addEmployee(firm[i]);
		}
	}

	@Test
	void testAddEmployee() {
		assertFalse(company.addEmployee(firm[3]));
		Employee employee = new SalesManager(5000, "Peter", "Jackson", 182, 40_000, 0.1);
		assertTrue(company.addEmployee(employee));
		assertEquals(5, company.size());
		employee = new SalesManager(6000, "Peter", "Jackson", 182, 40_000, 0.1);
		assertFalse(company.addEmployee(employee));
	}

	@Test
	void testRemoveEmployee() {
		Employee actual = company.removeEmployee(3000);
		assertEquals(firm[2], actual);
		assertEquals(firm[2].getLastName(), actual.getLastName());
		assertNull(company.findEmployee(3000));
		assertEquals(3, company.size());
		assertNull(company.removeEmployee(6000));
		assertEquals(3, company.size());
	}

	@Test
	void testFindEmployee() {
		assertEquals(firm[1], company.findEmployee(2000));
		assertNull(company.findEmployee(5000));
	}

	@Test
	void testTotalSalary() {
		assertEquals(44380.0, company.totalSalary(), 0.01);
	}

	@Test
	void testAverageSalary() {
		assertEquals(44380.0 / 4, company.averageSalary(), 0.01);
	}

	@Test
	void testTotalSales() {
		assertEquals(120000, company.totalSales(), 0.01);
	}

	@Test
	void testSize() {
		assertEquals(4, company.size());
	}

	@Test
	void testPrintEmployees() {
		company.printEmployees();
	}

	@Test
	void testFindEmployeesHoursGreateThan() {
		Employee[] actual = company.findEmployeesHoursGreateThan(100);
		Employee[] expected = { firm[0], firm[1], firm[2] };
		assertArrayEquals(expected, actual);
	}

	@Test
	void testFindEmployeesSalaryBetween() {
		Employee[] actual = company.findEmployeesSalaryBetween(5000, 8000);
		Employee[] expected = { firm[1], firm[2] };
		assertArrayEquals(expected, actual);
	}
}
