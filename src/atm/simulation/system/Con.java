package atm.simulation.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Con {

    public Connection connection;
    public Statement statement;

    public Con() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankSystem?useSSL=false&serverTimezone=UTC",
                    "purvesh",
                    "purvesh"
            );

            statement = connection.createStatement();
            System.out.println("Database connected successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
