package JDBC;

import java.sql.*;

public class JdbcExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String user = "root";
        String password = "root";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. Get Connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Database");

            // 2. Create Statement
            statement = connection.createStatement();

            // 3. Execute Query
            String sql = "SELECT * FROM employee";
            resultSet = statement.executeQuery(sql);

            // 4. Process ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");

                System.out.println(id + " | " + name + " | " + salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

