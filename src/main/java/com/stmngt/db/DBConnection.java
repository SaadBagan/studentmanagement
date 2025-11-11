package com.stmngt.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection con = null;
    private static final String URL = "jdbc:postgresql://localhost:5432/Studentdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    
    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {

                Class.forName("org.postgresql.Driver");

                con = DriverManager.getConnection(URL, USER, PASSWORD);

                System.out.println("Database connected successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB Connection failed!");
        }
        return con;
    }
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
    }

}
