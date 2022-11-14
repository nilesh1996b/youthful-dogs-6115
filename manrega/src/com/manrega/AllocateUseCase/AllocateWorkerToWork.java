package com.manrega.AllocateUseCase;

import java.util.Scanner;

import com.manrega.AllocateWorkDao.AllocateWorkDao;
import com.manrega.AllocateWorkDao.AllocateWorkImpDao;
import com.manrega.exception.WorkTypeException;
import com.manrega.exception.WorkersException;

public class AllocateWorkerToWork {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter the Employee Id");
			int empId = sc.nextInt();

			System.out.println("Enter the Work Id");
			int workId = sc.nextInt();
			
			AllocateWorkDao awd = new AllocateWorkImpDao();
			try {
				String check = awd.WorkAllocationForWorker(empId, workId);
				System.out.println(check);
			} catch (WorkersException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WorkTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
