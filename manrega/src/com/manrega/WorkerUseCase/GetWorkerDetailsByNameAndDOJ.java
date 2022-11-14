package com.manrega.WorkerUseCase;

import java.util.Scanner;

import com.manreg.bean.Workers;
import com.manrega.Workerdao.WorkersDao;
import com.manrega.Workerdao.WorkersImpl;
import com.manrega.exception.WorkersException;

public class GetWorkerDetailsByNameAndDOJ {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Enter Workers FirstName and LastName in first-last format");
			String name = sc.next();
			
			System.out.println("Enter Date of Joining in YYYY-MM-DD format");
			String doj = sc.next();
			
			WorkersDao obj = new WorkersImpl();
			
			Workers worker;
			try {
				worker = obj.getDetailsByNameAndJoiningDate(name, doj);
				if(worker != null)
					System.out.println(worker);
			} catch (WorkersException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
