package com.sql.learning;

import com.sql.learning.dao.EmployeeDao;
import com.sql.learning.dao.EmployeeDaoImpl;
import com.sql.learning.entity.Employee;

public class Client {
	

	public static void main(String[] args)  {
		EmployeeDao edao = new EmployeeDaoImpl();
		Employee Shanti = new Employee(13,"Shanti","female",45789);
		
		
//		edao.deleteEmployeeById(13);
//		edao.getAllEmployees();
//		edao.getEmployeeById(2);
//		edao.createTable("Student");
//		edao.getEmployeeByName("ZOZO' or 1=1");
		edao.saveEmployeeByPS(Shanti);
		
		System.out.println("Transaction successfully submitted..............");
		
		
	}

}
