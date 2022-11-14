package com.manrega.WorkTypeUseCase;

import java.util.Scanner;
import com.manreg.bean.WorkType;
import com.manrega.WorkTypedao.WorkTypeDao;
import com.manrega.WorkTypedao.WorkTypeImpl;

public class RegisterWorkUseCase {

	public static void main(String[] args) {
		

		
			
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter Work Name");
			String workName = sc.next();

			System.out.println("Enter Working Hours");
			int workHours = sc.nextInt();
			
			
			WorkTypeDao ob1 = new WorkTypeImpl();
			String result = ob1.registerWorkType(new WorkType(workName,workHours));
			System.out.println(result );
		}
		
	}
	
}
