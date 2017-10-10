package ercanduman.oracle_db_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        if (establishConnection()) {
//            executeSEARCH(Constants.SQL_SEARCH);
            executeINSERT(Constants.SQL_INSERT, "8", "NEW SQUARE", "N");
        }
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

    private static void executeSEARCH(String searchSQL) {
        try {
            PreparedStatement statement = connection.prepareStatement(searchSQL);
            resultSet = statement.executeQuery();

            int i = 0;
            System.out.println(prefix_info + "DB VALUES:");
            while (resultSet.next()) {
                i++;
                String output = "%d.  %s %s\t  %s";
                System.out.println(String.format(output, i, resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(prefix_error + "Error occurred while working on SEARCH SQL!");
        }
    }

    //operand_id, operand_name, operand_symbol are will b inserted
    private static void executeINSERT(String insertSQL, String operand_id, String operand_name, String operand_symbol) {
        try {
            PreparedStatement statement = connection.prepareStatement(insertSQL);
            statement.setString(1, operand_id);
            statement.setString(2, operand_name);
            statement.setString(3, operand_symbol);

            int resultCount = statement.executeUpdate();
            if (resultCount > 0) {
                System.out.println(prefix_info + resultCount + " row(s) inserted!");
            } else
                System.out.println(prefix_info + "No row(s) inserted!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(prefix_error + "Error occurred while working on INSERT SQL!");
        }
    }

}


