package com.alm.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class DatabaseConfiguration {
    @Value("${alm.database.url}")
    private String url;

    @Value("${alm.database.user}")
    private String user;

    @Value("${alm.database.password}")
    private String password;

    @PostConstruct
    void configureConnection() {
        DBConnection.configure(url, user, password);
    }
}