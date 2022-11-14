package com.manrega.WorkerUseCase;

import java.util.List;

import com.manreg.bean.Workers;
import com.manrega.Workerdao.WorkersDao;
import com.manrega.Workerdao.WorkersImpl;
import com.manrega.exception.WorkersException;

public class GetAllWorkersDetails {
	public static void main(String[] args) {
		WorkersDao obj = new WorkersImpl();
		
		try {
			List<Workers> worker = obj.getAllDetails();
			worker.forEach(System.out::println);
		} catch (WorkersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
