package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.DbUtil;

public class UserDao {
	private Connection connection;
	public UserDao() {
		connection = DbUtil.getConnection();
	}
	
	public void addUser (User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into users(name, description) values (?,?)");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getDescription());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser (int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update users set name=?, description=? where id=?");
			preparedStatement.setString(1,  user.getName());
			preparedStatement.setString(2, user.getDescription());
			preparedStatement.setInt(3, user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setDescription(rs.getString("description"));
				users.add(user);
			} 
		}catch (SQLException e) {
				e.printStackTrace();
			}
		 return users;
	}
	
	public User getUserById(int id) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
