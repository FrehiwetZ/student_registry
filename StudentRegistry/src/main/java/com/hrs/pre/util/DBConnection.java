package com.hrs.pre.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Note: Use your actual database name, username, and password [cite: 9]
    private static final String URL = "jdbc:mysql://localhost:3306/pre"; 
    private static final String USER = "root";
    private static final String PASSWORD = "Joelget@4";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}