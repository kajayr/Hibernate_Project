package test_connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/employee?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "Kaj_razmik8";
        try{
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection successful!!!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
