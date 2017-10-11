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
            executeSEARCH(Constants.SQL_SEARCH);
//            executeINSERT(Constants.SQL_INSERT, "8", "NEW SQUARE", "N");
//            executeUPDATE(Constants.SQL_UPDATE, "Square", "S", "8");
//            executeDELETE(Constants.SQL_DELETE, "8");

            //After operation finished close opened connections
            closeConnection();
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

    private static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println(prefix_info + "Database Connection closed!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Deletion will be processed based on operand_id
    private static void executeDELETE(String deleteSQL, String operand_id) {
        try {
            PreparedStatement statement = connection.prepareStatement(deleteSQL);
            statement.setString(1, operand_id);

            int resultCount = statement.executeUpdate();
            if (resultCount > 0) {
                System.out.println(prefix_info + resultCount + " row(s) deleted!");
            } else {
                System.out.println(prefix_info + "No rows deleted!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(prefix_error + "An error occurred while working on DELETE SQL!");
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
            System.out.println(prefix_error + "An error occurred while working on SEARCH SQL!");
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
            } else {
                System.out.println(prefix_info + "No rows inserted!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(prefix_error + "An error occurred while working on INSERT SQL!");
        }
    }

    //operand_name and operand_symbol will be updated for given operand_id.
    private static void executeUPDATE(String updateSQL, String operand_name, String operand_symbol, String operand_id) {
        try {
            PreparedStatement statement = connection.prepareStatement(updateSQL);
            statement.setString(1, operand_name);
            statement.setString(2, operand_symbol);
            statement.setString(3, operand_id);

            int resultCount = statement.executeUpdate();
            if (resultCount > 0) {
                System.out.println(prefix_info + resultCount + " row(s) updated!");
            } else {
                System.out.println(prefix_info + " No rows updated!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(prefix_error + "An error occurred while working on UPDATE SQL!");
        }
    }
}


