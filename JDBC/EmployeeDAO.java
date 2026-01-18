package JDBC;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    void updateEmployeeSalary(int id, double salary);

    void deleteEmployee(int id);
}

