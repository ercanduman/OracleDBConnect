package ercanduman.oracle_db_connect;

/**
 * Created on 10.10.2017.
 */

class Constants {
    // Database connection variables
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    static final String DB_DRIVER = "oracle.jdbc.OracleDriver";
    static final String DB_USERNAME = "EDUMAN";
    static final String DB_PASSWORD = "Erc787dmm";

    // SQL queries
    static final String SQL_SEARCH = "SELECT * FROM eduman.operand_config_test";
    static final String SQL_INSERT = "INSERT INTO eduman.operand_config_test (operand_id, operand_name, operand_symbol) VALUES (?, ?, ?)";
    static final String SQL_UPDATE = "UPDATE eduman.operand_config_test SET operand_name   = ?, operand_symbol = ? WHERE operand_id = ?";
    static final String SQL_DELETE = "DELETE FROM eduman.operand_config_test WHERE operand_id = ?";

}
