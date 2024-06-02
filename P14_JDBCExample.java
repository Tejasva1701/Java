import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
    // Database URL
    static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    // Database credentials
    static final String USER = "testuser";
    static final String PASS = "testpassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Execute a query to create a table
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Employees " +
                         "(id INTEGER not NULL AUTO_INCREMENT, " +
                         " name VARCHAR(255), " +
                         " age INTEGER, " +
                         " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

            // Step 4: Insert data into the table
            System.out.println("Inserting records into the table...");
            sql = "INSERT INTO Employees (name, age) VALUES ('Bhavin', 30)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Employees (name, age) VALUES ('Harshit', 25)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

            // Step 5: Query data from the table
            System.out.println("Creating statement...");
            sql = "SELECT id, name, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 6: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + name);
                System.out.println(", Age: " + age);
            }
            // Step 7: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
    }
}
