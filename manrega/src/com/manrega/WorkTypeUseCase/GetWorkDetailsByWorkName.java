package com.manrega.WorkTypeUseCase;

import java.util.Scanner;
import com.manreg.bean.WorkType;
import com.manrega.WorkTypedao.WorkTypeDao;
import com.manrega.WorkTypedao.WorkTypeImpl;
import com.manrega.exception.WorkTypeException;

public class GetWorkDetailsByWorkName {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Enter Work Name");
			String workName = sc.next();
			
			
			WorkTypeDao obj = new WorkTypeImpl();
			
			WorkType work;
			try {
				work = obj.getWorkDetailsByName(workName);
				if(work != null)
					System.out.println(work);
			} catch (WorkTypeException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
