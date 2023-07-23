package company_employee.tests;
         
import company_employee.dao.Company;
import company_employee.dao.CompanyImpl;
import company_employee.model.Employee;
import company_employee.model.Manager;
import company_employee.model.SalesManager;
import company_employee.model.WageEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.*;
 
class CompanyTestUpdated {
    Company company;
    Employee[] firm;
 
    @BeforeEach
    void setUp() throws Exception{
        company = new CompanyImpl(5);
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
    void testAddExistEmployee() {
        assertFalse(company.addEmployee(firm[3]));
    }
 
    @Test
    void testAddNewEmployee() {
        int size = company.size();
        Employee expected = new SalesManager(5000, "Peter", "Jackson", 182, 40_000, 0.1);
        assertTrue(company.addEmployee(expected));
        assertEquals(size + 1, company.size());
    }
 
    @Test
    void testAddNullEmployee() {
        int size = company.size();
        assertFalse(company.addEmployee(null));
        assertEquals(size, company.size());
    }
 
    @Test
    void testAddEmployeeThenSizeIsFull() {
        Employee employee = new SalesManager(5000, "Peter", "Jackson", 182, 40_000, 0.1);
        company.addEmployee(employee);
        employee = new SalesManager(6000, "Peter", "Jackson", 182, 40_000, 0.1);
        assertFalse(company.addEmployee(employee));
    }
 
    @Test
    void testRemoveExistEmployee() {
        int size = company.size();
        Employee actual = company.removeEmployee(firm[2].getId());
        assertEquals(firm[2], actual);
        assertNull(company.findEmployee(firm[2].getId()));
        assertEquals(size - 1, company.size());
    }
 
    @Test
    void testRemoveNotExistEmployee() {
        int size = company.size();
        Employee employee = new SalesManager(6000, "Peter", "Jackson", 182, 40_000, 0.1);
        Employee expected = company.removeEmployee(employee.getId());
        assertNull(expected);
        assertEquals(size, company.size());
    }
 
    @Test
    void testFindExistEmployee() {
        assertEquals(firm[1], company.findEmployee(firm[1].getId()));
    }
 
    @Test
    void testFindNotExistEmployee() {
        Employee employee = new SalesManager(6000, "Peter", "Jackson", 182, 40_000, 0.1);
        assertNull(company.findEmployee(employee.getId()));
    }
 
    @Test
    void testUpdateLastNameEmployee() {
        String actual = "New last name";
        company.findEmployee(firm[1].getId()).setLastName(actual);
        assertEquals(actual, (company.findEmployee(firm[1].getId()).getLastName()));
    }
    @Test
    void testUpdateFirstNameEmployee() {
        String actual = "New first name";
        company.findEmployee(firm[1].getId()).setFirstName(actual);
        assertEquals(actual, (company.findEmployee(firm[1].getId()).getFirstName()));
    }
    @Test
    void testUpdateHoursEmployee() {
        int actual = 300;
        company.findEmployee(firm[1].getId()).setHours(actual);
        assertEquals(actual, (company.findEmployee(firm[1].getId()).getHours()));
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
        Employee[] expected = {firm[0], firm[1], firm[2]};
        assertArrayEquals(expected, actual);
    }
 
    @Test
    void testFindEmployeesSalaryBetween() {
        Employee[] actual = company.findEmployeesSalaryBetween(5000, 8000);
        Employee[] expected = {firm[1], firm[2]};
        assertArrayEquals(expected, actual);
    }
}
