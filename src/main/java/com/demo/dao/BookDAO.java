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

public class BookDAO {

	private String jdbcUrl;
	private String jdbcUsername;
	private String jdbcPassword;

	private Connection connection;

	public BookDAO(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
		this.jdbcUrl = jdbcUrl;

		loadDriver();
		initializeConnection();
	}

	public List<ProductModel> findAll() {
		List<ProductModel> books = new ArrayList<>();

		try {
			final Connection conn = getConnection();
			PreparedStatement selectAccountSql = conn.prepareStatement("SELECT * FROM booksdetails");
			final ResultSet result = selectAccountSql.executeQuery();
			while (result.next()) {
				ProductModel book = new ProductModel(result.getString(1), result.getString(2), result.getString(3), result.getInt(5), result.getString(4));
				books.add(book);
			}

			selectAccountSql.close();
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
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
