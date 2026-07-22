package com.alm.database;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection connection = DBConnection.getConnection()) {
            System.out.println("Connected to Oracle successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}