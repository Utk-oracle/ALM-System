package com.alm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DEFAULT_URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String DEFAULT_USER = "system";
    private static final String DEFAULT_PASSWORD = "root";
    private static volatile String configuredUrl;
    private static volatile String configuredUser;
    private static volatile String configuredPassword;

    private DBConnection() {
    }

    public static void configure(String url, String user, String password) {
        configuredUrl = url;
        configuredUser = user;
        configuredPassword = password;
    }

    public static Connection getConnection() throws SQLException {
        String url = configuredUrl != null ? configuredUrl
                : System.getProperty("alm.db.url", System.getenv().getOrDefault("ALM_DB_URL", DEFAULT_URL));
        String user = configuredUser != null ? configuredUser
                : System.getProperty("alm.db.user", System.getenv().getOrDefault("ALM_DB_USER", DEFAULT_USER));
        String password = configuredPassword != null ? configuredPassword
                : System.getProperty("alm.db.password", System.getenv().getOrDefault("ALM_DB_PASSWORD", DEFAULT_PASSWORD));
        return DriverManager.getConnection(url, user, password);
    }
}