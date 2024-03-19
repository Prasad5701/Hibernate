package jspservlet;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.List;

public class StudentCrud {
	public Connection getConnection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/jspservlet?user=root&password=root");
		return connection;

	}

	public int signUp(Student student) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getName());
		preparedStatement.setString(3, student.getBranch());
		preparedStatement.setLong(4, student.getPhone());
		preparedStatement.setString(5, student.getEmail());
		preparedStatement.setString(6, student.getPassword());
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}

	public String login(String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT PASSWORD FROM STUDENT WHERE EMAIL=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		if (resultSet.next()) {
			password = resultSet.getString("password");
		}
		connection.close();
		return password;

	}

	public List getAllData() throws Exception {

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT");
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Student> list = new ArrayList<>();

		
		while (resultSet.next()) {
			Student student = new Student();

			student.setId(resultSet.getInt("id"));
			student.setName(resultSet.getString("name"));
			student.setBranch(resultSet.getString("branch"));
			student.setPhone(resultSet.getLong("phone"));
			student.setEmail(resultSet.getString("email"));

			list.add(student);
		}
		connection.close();
		return list;
	}

	public Student getStudent(int id) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT WHERE ID=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		Student student = new Student();
		while (resultSet.next()) {
			student.setId(resultSet.getInt("id"));
			student.setName(resultSet.getString("name"));
			student.setBranch(resultSet.getString("branch"));
			student.setPhone(resultSet.getLong("phone"));
			student.setEmail(resultSet.getString("email"));
		}
		connection.close();
		return student;
	}

	public int updateStudent(Student student) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE STUDENT SET NAME=?, BRANCH=?, PHONE=?, EMAIL=?,PASSWORD=? WHERE ID=?");
		
		preparedStatement.setString(1, student.getName());
		preparedStatement.setString(2, student.getBranch());
		preparedStatement.setLong(3, student.getPhone());
		preparedStatement.setString(4, student.getEmail());
		preparedStatement.setString(5, student.getPassword());
		preparedStatement.setInt(6, student.getId());
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	
	public int delete(int id) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM STUDENT WHERE ID=?");
		preparedStatement.setInt(1, id);
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
}
