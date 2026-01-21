package Day_35_Practice_Problem.employee_payroll_jdbc.test;

import Day_35_Practice_Problem.employee_payroll_jdbc.java.EmployeePayrollDBService;
import Day_35_Practice_Problem.employee_payroll_jdbc.java.EmployeePayrollData;

import java.time.LocalDate;
import java.util.List;

public class EmployeePayrollJDBCTest {

    public static void main(String[] args) {

        try {
            EmployeePayrollDBService service =
                    EmployeePayrollDBService.getInstance();

            System.out.println("========== UC 1: DB CONNECTION TEST ==========");
            System.out.println("Connection Established Successfully\n");

            System.out.println("========== UC 2: READ EMPLOYEE PAYROLL ==========");
            List<EmployeePayrollData> employees = service.readData();
            employees.forEach(e ->
                    System.out.println(e.id + " | " + e.name + " | " + e.salary)
            );
            System.out.println("Employee Count: " + employees.size() + "\n");

            // -------------------------------------------------

            System.out.println("========== UC 3: UPDATE SALARY (STATEMENT) ==========");
            service.updateSalary("Terissa", 3000000.00);
            EmployeePayrollData emp1 = service.getEmployeeByName("Terissa");
            System.out.println("Updated Salary: " + emp1.salary + "\n");

            // -------------------------------------------------

            System.out.println("========== UC 4: UPDATE SALARY (PREPARED STATEMENT) ==========");
            service.updateSalaryPrepared("Terissa", 3500000.00);
            EmployeePayrollData emp2 = service.getEmployeeByName("Terissa");
            System.out.println("Updated Salary (PS): " + emp2.salary + "\n");

            // -------------------------------------------------

            System.out.println("========== UC 5: EMPLOYEES BY DATE RANGE ==========");
            List<EmployeePayrollData> dateRangeEmployees =
                    service.getEmployeesByDate(
                            LocalDate.of(2018, 1, 1),
                            LocalDate.now()
                    );

            dateRangeEmployees.forEach(e ->
                    System.out.println(e.name + " | " + e.start)
            );
            System.out.println("Count: " + dateRangeEmployees.size() + "\n");

            // -------------------------------------------------

            System.out.println("========== UC 6: AVERAGE SALARY BY GENDER ==========");
            double avgSalary =
                    service.getAverageSalaryByGender("F");
            System.out.println("Average Salary (F): " + avgSalary + "\n");

            // -------------------------------------------------

            System.out.println("========== UC 7 & UC 8: ADD EMPLOYEE (TRANSACTION) ==========");
            service.addEmployeeWithPayroll(
                    "Anbu",
                    "M",
                    LocalDate.now(),
                    1200000.00
            );
            EmployeePayrollData newEmp =
                    service.getEmployeeByName("Anbu");
            System.out.println(
                    "Added Employee: " + newEmp.name +
                            " | Salary: " + newEmp.salary + "\n"
            );

            // -------------------------------------------------

            System.out.println("========== UC 12: SOFT DELETE EMPLOYEE ==========");
            service.removeEmployee("Anbu");
            EmployeePayrollData deletedEmp =
                    service.getEmployeeByName("Anbu");

            if (deletedEmp == null) {
                System.out.println("Employee successfully deactivated\n");
            } else {
                System.out.println("Soft delete failed\n");
            }

            System.out.println("========== ALL USE CASES EXECUTED SUCCESSFULLY ==========");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
