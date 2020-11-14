package org.example.dao;

import org.example.model.Employee;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLEmployeesDao implements Employees {
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
    public Employee findByUsername(String username) {
        String query = "SELECT * FROM employees WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);

            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(Employee employee) {
        String query = "INSERT INTO employees(username, password) VALUES (?, ?)";
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

    private Employee extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new Employee(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password")
        );
    }
}
