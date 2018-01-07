package com.calculator;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public Connection con;
    private static DbConnection ourInstance = new DbConnection();

    public static DbConnection getInstance() {
        return ourInstance;
    }

    private DbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/calculator", "root", "root");
            if (con != null)
                System.out.println("connected");

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}
