package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connector {
    private static Connection conn;

    private connector() {
    }

    public static Connection getConn() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection("jdbc:mysql://db.diplomportal.dk/s184727?" +
                        "user=s184727&password=YFSAiO2H36af4AuFbw3A3");
                System.out.println("Connection established!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}


