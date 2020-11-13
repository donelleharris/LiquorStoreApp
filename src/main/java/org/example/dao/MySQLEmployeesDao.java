package org.example.dao;

import org.example.model.employee;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLEmployeesDao implements employees {
    private Connection connection;
    public MySQLEmployeesDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e){
            throw new RuntimeException("Error connecting to the database");
        }
    }

    @Override
    public employee findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);

            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }    }

    @Override
    public Long insert(employee employee) {
        String query = "INSERT INTO users(username, password) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, employee.getUsername());
            stmt.setString(2, employee.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private employee extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new employee(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password")
        );
    }
}