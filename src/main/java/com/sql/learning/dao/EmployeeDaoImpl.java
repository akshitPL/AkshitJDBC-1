package com.sql.learning.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sql.learning.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	static Connection connenction = null;
	static final String INSERT_QUERY = "INSERT INTO EMPLOYEE(ID, NAME , GENDER , SALARY) VALUES(%d,'%s','%s',%d)";
	static final String INSERT_QUERY_FOR_PS = "INSERT INTO EMPLOYEE(ID, NAME , GENDER , SALARY) VALUES(?,?,?,?)";
	static final String UPDATE_QUERY = "UPDATE EMPLOYEE SET NAME = '%s', GENDER = '%s' , SALARY = %d WHERE ID = %d";
	static final String DELETE_QUERY = "DELETE FROM EMPLOYEE WHERE ID = %d";
	static final String SELECT_QUERY = "SELECT * FROM EMPLOYEE";
	static final String SELECT_BY_ID_QUERY = "SELECT * FROM EMPLOYEE WHERE ID = %d";
	static final String SELECT_BY_NAME_QUERY = "SELECT * FROM EMPLOYEE WHERE NAME = '%s";
	static final String CREATE_TABLE_QUERY = "CREATE TABLE %s (ID INT NOT NULL,NAME VARCHAR(100),CITY VARCHAR(100))";

	static {
		try {
			connenction = DriverManager.getConnection("jdbc:mysql://localhost:3306/sameer", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveEmployee(Employee e) {
		try (Statement stmt = connenction.createStatement()) {
			stmt.executeUpdate(String.format(INSERT_QUERY, e.getId(), e.getName(), e.getGender(), e.getSalary()));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		System.out.println(String.format(INSERT_QUERY, e.getId(), e.getName(), e.getGender(), e.getSalary()));
	}

	@Override
	public void updateEmployee(Employee e) {

		try (Statement stmt = connenction.createStatement()) {
			stmt.executeUpdate(String.format(UPDATE_QUERY, e.getName(), e.getGender(), e.getSalary(), e.getId()));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		System.out.println(String.format(UPDATE_QUERY, e.getName(), e.getGender(), e.getSalary(), e.getId()));
	}

	@Override
	public void deleteEmployeeById(int id) {
		try (Statement stmt = connenction.createStatement()) {
			stmt.executeUpdate(String.format(DELETE_QUERY, id));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		System.out.println((String.format(DELETE_QUERY, id)));
	}

	@Override
	public void getAllEmployees() {

		try (Statement stmt = connenction.createStatement()) {
			ResultSet rs = stmt.executeQuery(SELECT_QUERY);
			while (rs.next()) {
				System.out.println("Id = " + rs.getInt(1) + "\t Name = " + rs.getString(2) + "\t Gender = "
						+ rs.getString(3) + "\t Salary = " + rs.getInt(4));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		System.out.println(SELECT_QUERY);
	}

	@Override
	public void getEmployeeById(int id) {
		System.out.println(String.format(SELECT_BY_ID_QUERY, id));
		try (Statement stmt = connenction.createStatement()) {
			ResultSet rs = stmt.executeQuery(SELECT_QUERY);
			while (rs.next()) {
				System.out.println("Id = " + rs.getInt(1) + "\t Name = " + rs.getString(2) + "\t Gender = "
						+ rs.getString(3) + "\t Salary = " + rs.getInt(4));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void createTable(String name) {
		System.out.println(String.format(CREATE_TABLE_QUERY, name));
		try (Statement stmt = connenction.createStatement()) {

			stmt.executeUpdate(String.format(CREATE_TABLE_QUERY, name));

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void getEmployeeByName(String name) {
		System.out.println(String.format(SELECT_BY_NAME_QUERY, name));

		try (Statement stmt = connenction.createStatement()) {
			ResultSet rs = stmt.executeQuery(String.format(SELECT_BY_NAME_QUERY, name));
			while (rs.next()) {
				System.out.println("Id = " + rs.getInt(1) + "\t Name = " + rs.getString(2) + "\t Gender = "
						+ rs.getString(3) + "\t Salary = " + rs.getInt(4));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void saveEmployeeByPS(Employee e) {
		System.out.println(INSERT_QUERY_FOR_PS);
		try (PreparedStatement ps = connenction.prepareStatement(INSERT_QUERY_FOR_PS)) {

			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getGender());
			ps.setInt(4, e.getSalary());
			ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
