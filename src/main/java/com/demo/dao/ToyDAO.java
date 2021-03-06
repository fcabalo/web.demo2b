package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.AccountHolder;
import com.demo.model.ProductModel;

public class ToyDAO {

	private String jdbcUrl;
	private String jdbcUsername;
	private String jdbcPassword;

	private Connection connection;

	public ToyDAO(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
		this.jdbcUrl = jdbcUrl;

		loadDriver();
		initializeConnection();
	}

	public List<ProductModel> findAll() {
		List<ProductModel> products = new ArrayList<>();

		try {
			final Connection conn = getConnection();
			PreparedStatement selectAccountSql = conn.prepareStatement("SELECT * FROM toysdetails");
			final ResultSet result = selectAccountSql.executeQuery();
			while (result.next()) {
				ProductModel product = new ProductModel(result.getString(1), result.getString(2), result.getString(3), result.getInt(4));
				products.add(product);
			}

			selectAccountSql.close();
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
	
	public boolean addToy(ProductModel product) {
		String id = product.getId(); 
		String name = product.getName(); 
		String desc = product.getDesc();
		int price = product.getPrice();
		boolean success = false;
		try {
			final Connection conn = getConnection();
			String statement = "INSERT INTO toysdetails VALUES(?,?,?,?)";
			PreparedStatement insertToySql = conn.prepareStatement(statement);
			insertToySql.setString(1, id);
			insertToySql.setString(2, name);
			insertToySql.setString(3, desc);
			insertToySql.setInt(4, price);
			success =  insertToySql.execute(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	private void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load MySQL JDBC driver.");
		}
	}

	private void initializeConnection() {
		try {
			if (connection == null) {
				this.connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
			}
		} catch (SQLException e) {
			System.out.println("Failed to create sql connection.");
		}
	}

	public Connection getConnection() {
		return connection;
	}
}
