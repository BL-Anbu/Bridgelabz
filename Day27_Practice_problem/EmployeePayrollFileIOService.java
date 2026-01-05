package Day27_Practice_problem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOService {

    public static final String PAYROLL_FILE_NAME = "Day27_Practice_problem/payroll-file.txt";

    // UC4 – Write Employee Payroll to File
    public void writeData(List<EmployeePayrollData> employeePayrollList) {
        StringBuffer buffer = new StringBuffer();
        employeePayrollList.forEach(emp -> {
            buffer.append(emp.toString()).append("\n");
        });

        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME), buffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // UC5 – Print Employee Payroll File
    public void printData() {
        try {
            Files.lines(Paths.get(PAYROLL_FILE_NAME))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // UC5 (Extended) – Count Entries
    public long countEntries() {
        try {
            return Files.lines(Paths.get(PAYROLL_FILE_NAME)).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // UC6 – Read Payroll File
    public long readData() {
        return countEntries();
    }
}

