package com.xupt.gj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xupt.gj.bean.Products;
import com.xupt.gj.util.DataSourceUtil;

public class ProductDAO {

	public int save(Products products) {
		String sql = "INSERT INTO products (name, price, stock, description) VALUES(?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement statement = null;
		int result = 0;
		conn = DataSourceUtil.getConnection();
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, products.getName());
			statement.setDouble(2, products.getPrice());
			statement.setInt(3, products.getStock());
			statement.setString(4, products.getDescription());
			result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.release(conn);
		}
		return result;
	}
	
	public int delete(Integer id) {
		String sql = "DELETE FROM products WHERE id = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		int result = 0;
		conn = DataSourceUtil.getConnection();
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.release(conn);
		}
		return result;
	}
	
	public Products get(Integer id) {
		String sql = "SELECT id, name, price, stock, description FROM products WHERE id = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		Products products = null;
		conn = DataSourceUtil.getConnection();
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			set = statement.executeQuery();
			while (set.next()) {
				products = new Products();
				products.setId(set.getInt(1));
				products.setName(set.getString(2));
				products.setPrice(set.getDouble(3));
				products.setStock(set.getInt(4));
				products.setDescription(set.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.release(conn);
		}
		return products;
	}
	
	public int getStock(Integer id) {
		String sql = "SELECT stock FROM products WHERE id = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		conn = DataSourceUtil.getConnection();
		int result = 0;
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			set = statement.executeQuery();
			while (set.next()) {
				result = set.getInt(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.release(conn);
		}
		return result;
	}
	
	public List<Products> list() {
		String sql = "SELECT id, name, price, stock, description FROM products";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		List<Products> list = new ArrayList<>();
		conn = DataSourceUtil.getConnection();
		try {
			statement = conn.prepareStatement(sql);
			set = statement.executeQuery();
			while (set.next()) {
				Products products = new Products();
				products.setId(set.getInt(1));
				products.setName(set.getString(2));
				products.setPrice(set.getDouble(3));
				products.setStock(set.getInt(4));
				products.setDescription(set.getString(5));
				list.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.release(conn);
		}
		return list;
	}
}
