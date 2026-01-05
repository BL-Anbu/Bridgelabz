package Day27_28_Practice_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    private List<EmployeePayrollData> employeePayrollList;
    private EmployeePayrollFileIOService fileIOService;

    // Default Constructor
    public EmployeePayrollService() {
        this.employeePayrollList = new ArrayList<>();
        this.fileIOService = new EmployeePayrollFileIOService();
    }

    // Parameterized Constructor
    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
        this.fileIOService = new EmployeePayrollFileIOService();
    }

    // UC1 – Read Employee Payroll from Console
    public void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.print("Enter Employee ID: ");
        int id = consoleInputReader.nextInt();

        System.out.print("Enter Employee Name: ");
        String name = consoleInputReader.next();

        System.out.print("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();

        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    // UC1 – Write Employee Payroll to Console
    public void writeEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO)) {
            System.out.println("\nWriting Employee Payroll Roster to Console");
            System.out.println(employeePayrollList);
        } else if (ioService.equals(IOService.FILE_IO)) {
            fileIOService.writeData(employeePayrollList);
        }
    }

    // UC5 – Print Payroll File
    public void printData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO)) {
            fileIOService.printData();
        }
    }

    // UC5 – Count Entries
    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO)) {
            return fileIOService.countEntries();
        }
        return 0;
    }

    // UC6 – Read Data
    public long readEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO)) {
            return fileIOService.readData();
        }
        return 0;
    }

    // MAIN METHOD
    public static void main(String[] args) {
        EmployeePayrollService service = new EmployeePayrollService();
        Scanner scanner = new Scanner(System.in);

        service.readEmployeePayrollData(scanner);
        service.writeEmployeePayrollData(IOService.CONSOLE_IO);
        service.writeEmployeePayrollData(IOService.FILE_IO);

        System.out.println("Entries in File: " +
                service.countEntries(IOService.FILE_IO));
    }
}
