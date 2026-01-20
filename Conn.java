package bank.managment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    
    public Conn() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root","CIMDR");
            

            // Create Statement
            s = c.createStatement();

        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}
