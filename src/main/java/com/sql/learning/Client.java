package com.sql.learning;

import java.sql.SQLException;

import com.sql.learning.dao.EmployeeDao;
import com.sql.learning.dao.EmployeeDaoImpl;
import com.sql.learning.entity.Employee;

public class Client {
	

	public static void main(String[] args) throws SQLException {
		EmployeeDao edao = new EmployeeDaoImpl();
		Employee vipin = new Employee(12,"Sukoon kumar","male",45789);
		
		
//		edao.deleteEmployeeById(13);
		
//		edao.getAllEmployees();
		edao.getEmployeeById(2);
		
		System.out.println("Transaction successfully submitted..............");
		
		
	}

}
