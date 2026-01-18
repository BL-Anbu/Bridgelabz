package JDBC;

import java.util.List;

import static JDBC.EmployeeDAOImpl.createEmployeeTable;

public class JdbcMain {

    public static void main(String[] args) {

        createEmployeeTable();
        EmployeeDAO dao = new EmployeeDAOImpl();

        dao.addEmployee(new Employee("Anbu", 50000));

        Employee emp = dao.getEmployeeById(1);
        if (emp != null) {
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary());
        }

        List<Employee> employees = dao.getAllEmployees();
        employees.forEach(e ->
                System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary())
        );

        dao.updateEmployeeSalary(1, 65000);

        dao.deleteEmployee(2);
    }
}
