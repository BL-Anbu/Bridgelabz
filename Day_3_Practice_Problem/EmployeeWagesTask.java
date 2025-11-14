package Day_3_Practice_Problem;

import java.util.Scanner;

public class EmployeeWagesTask {

    //UC1 --- Check Employee is Present or Absent
    //UC2 --- Calculate Daily Employee Wage
    //       - Assume Wage per Hour is 20
    //       - Assume Full Day Hour is 8
    //UC3 --- Add Part time Employee & Wage
    //       - Assume Part time Hour is 8
    //UC4 --- Solving using Switch Case Statement
    //UC5 --- Calculating Wages for a Month
    //       - Assume 20 Working Day per Month
    //UC6 --- Calculate Wages till a condition of total
    //              working hours or days is reached for a month
    //       - Assume 100 hours and 20 days

    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        EmployeeWagesTask employeeWagesTask = new EmployeeWagesTask();
        employeeWagesTask.runApplication();
    }

    private void runApplication() {

        Employee emp = fileEmployeeInfo();
        System.out.println(emp.toString());

        useCaseImplementaion(emp);


    }

    private void useCaseImplementaion(Employee emp) {
        boolean run = Boolean.TRUE;
        while(run){
            int expression=printUseCase();
            switch (expression) {
                case 0:
                    run=Boolean.FALSE;
                    break;
                case 1:
                    if(emp.isPresent()){
                        System.out.println("Employee is Present");
                    }else{
                        System.out.println("Employee is Absent");
                    }
                    break;
                case 2:
                    System.out.println("Case 1");
                    System.out.println("Enter a UseCase to Check 0-6");
                    break;
                case 3:
                    System.out.println("Case 1");
                    break;
                case 4:
                    System.out.println("Case 1");
                    break;
                case 5:
                    System.out.println("Case 1");
                    break;
                case 6:
                    System.out.println("Case 1");
                    break;
            }
        }
    }

    private void getEmployeeAttendence(Employee emp) {
        fileEmployeeInfo();
    }

    private int printUseCase() {
        System.out.println("----------------------------********************************----------------------------");
        System.out.println("UC 1 : Check Employee is Present or Absent");
        System.out.println("UC 2 : Calculate Daily Employee Wage");
        System.out.println("UC 3 : Add Part time Employee & Wage");
        System.out.println("UC 4 : Solving using Switch Case Statement");
        System.out.println("UC 5 : Calculating Wages for a Month");
        System.out.println("UC 6 : Calculate Wages till a condition of total" +
                " working hours or days is reached for a month");
        System.out.println("----------------------------********************************----------------------------");
        System.out.print("Enter the UC : ");
        return sc.nextInt();
    }

    public static Employee fileEmployeeInfo() {
        boolean run = Boolean.TRUE;
        System.out.println("----------------------------********************************----------------------------");
        System.out.println("--------------Welcome to Employee Wage Computation--------------");
        Employee emp = new Employee();

        System.out.print("Enter the Employee Name : ");
        emp.setEmpName(sc.next());
        System.out.print("Enter the Employee Id : ");
        emp.setEmpId(sc.nextInt());
        System.out.print("Enter the Employee Attendence (Y or y / N or n) : ");
        while (run) {
            String ch = sc.next();
            if (ch.equalsIgnoreCase("Y")) {
                emp.setPresent(Boolean.TRUE);
                run = Boolean.FALSE;
            } else if (ch.equalsIgnoreCase("N")) {
                emp.setPresent(Boolean.FALSE);
                run = Boolean.FALSE;
            } else {
                System.out.print("Enter correct format Like (Y or y / N or n) : ");
            }
        }
        System.out.print("If your Overtime worker Y/N: ");
        String input = sc.next();
        boolean overTimeWorkers = input.equalsIgnoreCase("Y");
        if (overTimeWorkers) {
            System.out.print("Enter the One day total working hours : ");
            emp.setOneDayTotalHours(sc.nextInt());
            System.out.print("Enter the One Part time working hours : ");
            emp.setOneDayPartTimeHours(sc.nextInt());
        }
        return emp;
    }
}

class Employee {

    private int empId;
    private boolean present;
    private String empName;
    private final int wagesPerHour = 20;
    private int oneDayTotalHours = 8;
    private int oneDayPartTimeHours = 8;
    private final int workingDaysPerMonth = 20;

    public void setOneDayTotalHours(int oneDayTotalHours) {
        this.oneDayTotalHours = oneDayTotalHours;
    }

    public void setOneDayPartTimeHours(int oneDayPartTimeHours) {
        this.oneDayPartTimeHours = oneDayPartTimeHours;
    }

    public int getWagesPerHour() {
        return wagesPerHour;
    }

    public int getOneDayTotalHours() {
        return oneDayTotalHours;
    }

    public int getOneDayPartTimeHours() {
        return oneDayPartTimeHours;
    }

    public int getWorkingDaysPerMonth() {
        return workingDaysPerMonth;
    }

    public int getEmpId() {
        return empId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId = " + empId +
                ", present = " + present +
                ", empName = '" + empName + '\'' +
                ", wagesPerHour = " + wagesPerHour +
                ", oneDayTotalHours = " + oneDayTotalHours +
                ", oneDayPartTimeHours = " + oneDayPartTimeHours +
                ", workingDaysPerMonth = " + workingDaysPerMonth +
                '}';
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

}
