package com.manrega.WorkerUseCase;

import java.util.Scanner;

import com.manreg.bean.Workers;
import com.manrega.Workerdao.WorkersDao;
import com.manrega.Workerdao.WorkersImpl;
import com.manrega.exception.WorkersException;

public class GetWorkerByEmpID {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Workers empID");
			int empId = sc.nextInt();
			
			WorkersDao obj = new WorkersImpl();
			
			Workers worker;
			try {
				worker = obj.getWorkerByEmpId(empId);
				if(worker != null)
					System.out.println(worker);
			} catch (WorkersException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
