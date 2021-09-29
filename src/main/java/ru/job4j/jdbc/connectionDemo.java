package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDemo {

    public static void main(String[] args) throws SQLException {
        Config config = new Config("./src/main/app.properties");
        config.load();
        try (Connection connection = DriverManager.getConnection(
                config.value("url"),
                config.value("login"),
                config.value("password"))) {
            DatabaseMetaData base = connection.getMetaData();
            System.out.println(base.getUserName());
            System.out.println(base.getURL());
        }

    }
}
