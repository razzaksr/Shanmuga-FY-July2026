package rest.jobs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class DbConfig {
    private static Dotenv dot = Dotenv.load();
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
            dot.get("db_url"), 
            dot.get("db_user"),
            dot.get("db_password")
        );
    }
}
