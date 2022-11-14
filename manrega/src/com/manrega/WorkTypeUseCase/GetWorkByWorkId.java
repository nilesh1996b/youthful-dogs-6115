package com.manrega.WorkTypeUseCase;

import java.util.Scanner;

import com.manreg.bean.WorkType;
import com.manrega.WorkTypedao.WorkTypeDao;
import com.manrega.WorkTypedao.WorkTypeImpl;
import com.manrega.exception.WorkTypeException;

public class GetWorkByWorkId {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Work ID");
			int workId = sc.nextInt();
			
			WorkTypeDao obj = new WorkTypeImpl();
			
			WorkType work;
			try {
				work= obj.getWorkByEmpId(workId);
				if(work != null)
					System.out.println(work);
			} catch (WorkTypeException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
