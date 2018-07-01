package com.xupt.gj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xupt.gj.bean.Users;
import com.xupt.gj.util.DataSourceUtil;

public class UserDAO {

	public int save(Users users) {
		String sql = "INSERT INTO users (`name`, `password`, `age`) values (?, ?, ?)";
		Connection conn = null;
		PreparedStatement statement = null;
		int result = 0;
		try {
			conn = DataSourceUtil.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, users.getName());
			statement.setString(2, users.getPassword());
			statement.setInt(3, users.getAge());
			result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.release(conn);
		}
		return result;
	}
	
	public int delete(Integer id) {
		String sql = "DELETE FROM users WHERE id = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		int result = 0;
		try {
			conn = DataSourceUtil.getConnection();
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
	
	public Users get(Integer id) {
		String sql = "SELECT id, name, password, age FROM users WHERE id = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		Users users = new Users();
		try {
			conn = DataSourceUtil.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			set = statement.executeQuery();
			while (set.next()) {
				users.setId(set.getInt(1));
				users.setName(set.getString(2));
				users.setPassword(set.getString(3));
				users.setAge(set.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.release(conn);
		}
		return users;
	}
	
	public Users get(String name) {
		String sql = "SELECT id, name, password, age FROM users WHERE name = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		Users users = new Users();
		try {
			conn = DataSourceUtil.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			set = statement.executeQuery();
			while (set.next()) {
				users.setId(set.getInt(1));
				users.setName(set.getString(2));
				users.setPassword(set.getString(3));
				users.setAge(set.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.release(conn);
		}
		return users;
	}
	
	public List<Users> list() {
		String sql = "SELECT id, name, password, age FROM users";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		List<Users> list = new ArrayList<>();
		try {
			conn = DataSourceUtil.getConnection();
			statement = conn.prepareStatement(sql);
			set = statement.executeQuery();
			while (set.next()) {
				Users users = new Users();
				users.setId(set.getInt(1));
				users.setName(set.getString(2));
				users.setPassword(set.getString(3));
				users.setAge(set.getInt(4));
				list.add(users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.release(conn);
		}
		return list;
	}
}
