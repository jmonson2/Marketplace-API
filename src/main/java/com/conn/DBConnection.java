package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */

    private String url;
    private String user;
    private String password;

    public DBConnection () {
        url = "jdbc:postgresql://localhost:5432/postgres";
        user = "postgres";
        password = "postgres";
    }
    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


        return conn;
    }
}
