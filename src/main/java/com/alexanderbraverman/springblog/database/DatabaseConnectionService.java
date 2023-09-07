package com.alexanderbraverman.springblog.database;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConnectionService {

    @Autowired
    private DataSource dataSource;

    public boolean isDatabaseConnectionValid() {
        try (Connection connection = dataSource.getConnection()) {
            // You can execute a simple query to verify the connection.
            String sql = "SELECT 1";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.executeQuery();
                return true; // Connection is valid.
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Connection is not valid.
        }
    }
}
