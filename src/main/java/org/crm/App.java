package org.crm;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {

        Connection conn = null;

        try {
            conn = Database.mkConn();
        } catch (SQLException e) {
            System.out.println("Error connection to DB");
        }

    }
}
