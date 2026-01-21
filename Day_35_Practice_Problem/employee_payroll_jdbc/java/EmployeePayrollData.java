package Day_35_Practice_Problem.employee_payroll_jdbc.java;

import java.time.LocalDate;

public class EmployeePayrollData {

    public int id;
    public String name;
    public String gender;
    public double salary;
    public String phoneNumber;
    public String address;
    public boolean isActive;
    public LocalDate start;

    public EmployeePayrollData(int id, String name,
                               String gender, double salary,
                               LocalDate start) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.start = start;
    }
}
