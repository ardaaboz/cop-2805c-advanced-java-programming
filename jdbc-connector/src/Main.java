import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection;
        try {
            ResultSet results = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12345");


            Statement statement = connection.createStatement();
            results = statement.executeQuery("SELECT * from Employees;");

            System.out.println("ID\t\tFirst Name\t\tLast Name");
            while (results.next()) {
                int employeeId = results.getInt("employeeId");
                String firstName = results.getString("firstName");
                String lastName = results.getString("lastName");

                System.out.println(employeeId + "\t\t" + firstName + "\t\t" + lastName);
            }


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}