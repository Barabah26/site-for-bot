package org.crm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection mkConn() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/crmDB",
                "root",
                "root");
    }
}
