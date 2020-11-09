package org.example.dao;
import org.example.model.Brand;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLBrandsDao implements Brands{
    private Connection connection = null;

    public MySQLBrandsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
//    @Override
    public List<Brand> all() {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM liquor_inventory");
            return createInventoryListFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving inventory.");
        }
    }
    @Override
    public Long insert(Brand brand) {
        try {
            String insertQuery = "INSERT INTO brandsInventory(brand, quantity, category) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, brand.getBrand());
            stmt.setInt(2, brand.getQuantity());
            stmt.setString(3, brand.getCategory());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private String createInsertQuery(Brand brand) {
        return "INSERT INTO ads(user_id, title, description) VALUES "
                + "(" + brand.getBrand() + ", "
                + "'" + brand.getQuantity() + "', "
                + "'" + brand.getCategory() + "')";
    }

    private Brand extractBrand(ResultSet rs) throws SQLException {
        return new Brand(
                rs.getLong("id"),
                rs.getString("brand"),
                rs.getInt("quantity"),
                rs.getString("category")
        );
    }
    private List<Brand> createInventoryListFromResults(ResultSet rs) throws SQLException {
        List<Brand> brands = new ArrayList<>();
        while (rs.next()) {
            brands.add(extractBrand(rs));
        }
        return brands;
    }
}
