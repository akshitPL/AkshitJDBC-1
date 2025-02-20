package com.sql.learning.dao;

import com.sql.learning.entity.Employee;

public interface EmployeeDao {

	public void saveEmployee(Employee e);

	public void saveEmployeeByPS(Employee e);

	public void updateEmployee(Employee e);

	public void deleteEmployeeById(int id);

	public void getAllEmployees();

	public void getEmployeeById(int id);

	public void getEmployeeByName(String name);

	public void createTable(String name);
}
