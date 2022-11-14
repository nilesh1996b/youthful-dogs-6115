package com.manrega.WorkTypeUseCase;

import java.util.List;

import com.manreg.bean.WorkType;
import com.manrega.WorkTypedao.WorkTypeDao;
import com.manrega.WorkTypedao.WorkTypeImpl;
import com.manrega.exception.WorkTypeException;

public class GetAllWorkTypeDetails {
	
	public static void print(){
	WorkTypeDao obj = new WorkTypeImpl();
	
	try {
		List<WorkType> work = obj.getAllWorkList();
		work.forEach(System.out::println);
	} catch (WorkTypeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		print();
	}
}
