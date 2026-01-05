package Day27_Practice_problem;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class EmployeePayrollServiceTest {

    @Test
    public void given3Employees_WhenWrittenToFile_ShouldMatchEntries() {

        EmployeePayrollData[] empArray = {
                new EmployeePayrollData(1, "Jeff", 100000),
                new EmployeePayrollData(2, "Bill", 200000),
                new EmployeePayrollData(3, "Mark", 300000)
        };

        EmployeePayrollService service =
                new EmployeePayrollService(Arrays.asList(empArray));

        service.writeEmployeePayrollData(IOService.FILE_IO);

        long entries = service.countEntries(IOService.FILE_IO);
        Assert.assertEquals(3, entries);
    }

    @Test
    public void givenFile_WhenRead_ShouldReturnCorrectCount() {
        EmployeePayrollService service = new EmployeePayrollService();
        long count = service.readEmployeePayrollData(IOService.FILE_IO);
        Assert.assertEquals(3, count);
    }
}
