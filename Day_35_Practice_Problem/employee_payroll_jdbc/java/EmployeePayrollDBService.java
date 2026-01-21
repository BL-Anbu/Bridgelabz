package Day_35_Practice_Problem.employee_payroll_jdbc.java;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {

    private static EmployeePayrollDBService service;
    private PreparedStatement getByNameStmt;

    private EmployeePayrollDBService() {
    }

    public static EmployeePayrollDBService getInstance() {
        if (service == null)
            service = new EmployeePayrollDBService();
        return service;
    }

    public List<EmployeePayrollData> readData() throws SQLException {
        String sql = """
                    SELECT e.employee_id, e.name, e.gender, e.start, p.basic_pay
                    FROM employee e
                    JOIN payroll p ON e.employee_id = p.employee_id
                    WHERE e.is_active = true
                """;
        List<EmployeePayrollData> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            list.add(new EmployeePayrollData(
                    rs.getInt("employee_id"),
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getDouble("basic_pay"),
                    rs.getDate("start").toLocalDate()
            ));
        }
        return list;
    }

    public int updateSalary(String name, double salary)
            throws SQLException {

        String sql = """
                    UPDATE payroll
                    SET basic_pay = %f
                    WHERE employee_id =
                    (SELECT employee_id FROM employee WHERE name = '%s')
                """.formatted(salary, name);

        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        return stmt.executeUpdate(sql);
    }

    public int updateSalaryPrepared(String name, double salary)
            throws SQLException {

        String sql = """
                    UPDATE payroll
                    SET basic_pay = ?
                    WHERE employee_id =
                    (SELECT employee_id FROM employee WHERE name = ?)
                """;

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, salary);
        ps.setString(2, name);

        return ps.executeUpdate();
    }

    public EmployeePayrollData getEmployeeByName(String name)
            throws SQLException {

        if (getByNameStmt == null) {
            String sql = """
                        SELECT e.employee_id, e.name, e.gender,
                               p.basic_pay, e.start
                        FROM employee e
                        JOIN payroll p ON e.employee_id = p.employee_id
                        WHERE e.name = ? AND e.is_active = true
                    """;
            getByNameStmt = DBConnection
                    .getConnection()
                    .prepareStatement(sql);
        }

        getByNameStmt.setString(1, name);
        ResultSet rs = getByNameStmt.executeQuery();

        if (rs.next()) {
            return new EmployeePayrollData(
                    rs.getInt("employee_id"),
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getDouble("basic_pay"),
                    rs.getDate("start").toLocalDate()
            );
        }
        return null;
    }

    public List<EmployeePayrollData> getEmployeesByDate(
            LocalDate start, LocalDate end) throws SQLException {

        String sql = """
                    SELECT e.employee_id, e.name, e.gender,
                           p.basic_pay, e.start
                    FROM employee e
                    JOIN payroll p ON e.employee_id = p.employee_id
                    WHERE e.start BETWEEN ? AND ?
                    AND e.is_active = true
                """;

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, Date.valueOf(start));
        ps.setDate(2, Date.valueOf(end));

        ResultSet rs = ps.executeQuery();
        List<EmployeePayrollData> list = new ArrayList<>();

        while (rs.next()) {
            list.add(new EmployeePayrollData(
                    rs.getInt("employee_id"),
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getDouble("basic_pay"),
                    rs.getDate("start").toLocalDate()
            ));
        }
        return list;
    }

    public double getAverageSalaryByGender(String gender)
            throws SQLException {

        String sql = """
                    SELECT AVG(p.basic_pay) avg
                    FROM employee e
                    JOIN payroll p ON e.employee_id = p.employee_id
                    WHERE e.gender = ?
                    GROUP BY e.gender
                """;

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, gender);

        ResultSet rs = ps.executeQuery();
        return rs.next() ? rs.getDouble("avg") : 0.0;
    }

    public void addEmployeeWithPayroll(
            String name, String gender,
            LocalDate start, double salary)
            throws SQLException {

        Connection con = DBConnection.getConnection();
        try {
            con.setAutoCommit(false);

            String empSql = """
                        INSERT INTO employee(name, gender, start, is_active)
                        VALUES (?, ?, ?, true)
                    """;

            PreparedStatement empPS =
                    con.prepareStatement(empSql,
                            Statement.RETURN_GENERATED_KEYS);

            empPS.setString(1, name);
            empPS.setString(2, gender);
            empPS.setDate(3, Date.valueOf(start));
            empPS.executeUpdate();

            ResultSet keys = empPS.getGeneratedKeys();
            keys.next();
            int empId = keys.getInt(1);

            double deductions = salary * 0.2;
            double taxable = salary - deductions;
            double tax = taxable * 0.1;
            double netPay = salary - tax;

            String paySql = """
                        INSERT INTO payroll
                        (employee_id, basic_pay, deductions,
                         taxable_pay, tax, net_pay)
                        VALUES (?, ?, ?, ?, ?, ?)
                    """;

            PreparedStatement payPS =
                    con.prepareStatement(paySql);

            payPS.setInt(1, empId);
            payPS.setDouble(2, salary);
            payPS.setDouble(3, deductions);
            payPS.setDouble(4, taxable);
            payPS.setDouble(5, tax);
            payPS.setDouble(6, netPay);
            payPS.executeUpdate();

            con.commit();
        } catch (Exception e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }

    public int removeEmployee(String name)
            throws SQLException {

        String sql = """
                    UPDATE employee
                    SET is_active = false
                    WHERE name = ?
                """;
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);

        return ps.executeUpdate();
    }
}



