package com.marega.WorkTypeUseCase;

import java.util.List;
import com.manreg.bean.WorkType;
import com.manrega.WorkTypedao.WorkTypeDao;
import com.manrega.WorkTypedao.WorkTypeImpl;
import com.marega.exception.WorkTypeException;

public class GetAllWorkTypeDetails {
	public static void main(String[] args) {
		WorkTypeDao obj = new WorkTypeImpl();
		
		try {
			List<WorkType> work = obj.getAllWorkList();
			work.forEach(System.out::println);
		} catch (WorkTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
