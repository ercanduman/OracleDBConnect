package ercanduman.oracle_db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;


public class MainActivity {
    private static String prefix_error = "\nERROR> ";
    private static String prefix_info = "\nINFO> ";

    private static Connection connection;
    private static ResultSet resultSet;

    // For testing only change executionType value as S: Search, U:Update, D:Delete, I:Insert
    private static char executionType = 'S';

    public static void main(String[] strings) {
        establishConnection();
    }

    private static boolean establishConnection() {
        try {
            Class.forName(ercanduman.oracle_db_connect.Constants.DB_DRIVER);
            DriverManager.registerDriver(new OracleDriver());
            connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PASSWORD);
            System.out.println(prefix_info + "Database Connection is successful!");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(prefix_error + "Database Connection is failed!");
            return false;
        }
    }
}


