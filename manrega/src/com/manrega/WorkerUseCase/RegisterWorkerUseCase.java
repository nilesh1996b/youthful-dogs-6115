package com.manrega.WorkerUseCase;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.Scanner;

import com.manreg.bean.Workers;
import com.manrega.Workerdao.WorkersDao;
import com.manrega.Workerdao.WorkersImpl;

public class RegisterWorkerUseCase {

	public static void main(String[] args) {
		

		
			
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter EmpId");
			int empId = sc.nextInt();
			
			System.out.println("Enter Workers FirstName and LastName in first-last format");
			String name = sc.next();

			System.out.println("Enter Worker's Salary");
			int salary = sc.nextInt();

			System.out.println("Enter Worker's Email ID");
			String email = sc.next();

			System.out.println("Enter Date of Joining in YYYY-MM-DD format");
			String dateOfJoining = sc.next();
			
			
			WorkersDao ob1 = new WorkersImpl();
			String result = ob1.registerWorker(new Workers(empId,name,salary,email,dateOfJoining));
			System.out.println(result );
		}
		
	}
	
}
