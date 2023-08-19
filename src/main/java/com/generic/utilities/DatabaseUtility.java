package com.generic.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/studentdb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public Connection connect() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
	}

	public void createTable() {
		String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" + "id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "name VARCHAR(100)," + "age INT," + "grade VARCHAR(10))";

		try (Connection conn = connect(); Statement stmt = conn.createStatement()) {

			stmt.execute(createTableSQL);
			System.out.println("Table students created successfully!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void createDirectorTable() {
		String createTableSQL = "CREATE TABLE IF NOT EXISTS directors (" + "id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "name VARCHAR(100) NOT NULL," + "date_of_birth DATE," + "qualification VARCHAR(150),"
				+ "joining_date DATE," + "contact_number VARCHAR(15))";

		try (Connection conn = connect(); Statement stmt = conn.createStatement()) {

			stmt.execute(createTableSQL);
			System.out.println("Table directors created successfully!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void insertData(String name, int age, String grade) {
		String insertSQL = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, grade);

			pstmt.executeUpdate();

			System.out.println("Data inserted successfully!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void getData() {
		String selectSQL = "SELECT * FROM students";

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSQL)) {

			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: "
						+ rs.getInt("age") + ", Grade: " + rs.getString("grade"));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void updateData(int id, String grade) {
		String updateSQL = "UPDATE students SET grade = ? WHERE id = ?";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

			pstmt.setString(1, grade);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();

			System.out.println("Data updated successfully!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void updateData(int id, String name, int age, String grade) {
		String updateSQL = "UPDATE students SET name = ?, age = ?, grade = ? WHERE id = ?";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, grade);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();

			System.out.println("Data updated successfully!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void deleteData(int id) {
		String deleteSQL = "DELETE FROM students WHERE id = ?";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {

			pstmt.setInt(1, id);
			pstmt.executeUpdate();

			System.out.println("Data deleted successfully!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DatabaseUtility dbUtility = new DatabaseUtility();
//        dbUtility.createTable();
//        dbUtility.insertData("John Don", 22, "A+");
//        dbUtility.getData();
//		  dbUtility.updateData(2, "Mona Singh", 20, "A");
//        dbUtility.deleteData(2);

		dbUtility.createDirectorTable();
	}
}
