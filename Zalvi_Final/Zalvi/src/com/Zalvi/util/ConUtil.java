package com.Zalvi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;


public class ConUtil {

    private static final String URL
            = "jdbc:mysql://localhost:3306/db_Zalvi?zeroDateTimeBehavior=convertToNull";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection createConnection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME,
                    PASSWORD);
            conn.setAutoCommit(false);
            return conn;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConUtil.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
