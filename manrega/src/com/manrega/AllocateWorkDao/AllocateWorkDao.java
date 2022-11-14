package com.manrega.AllocateWorkDao;

import com.manrega.exception.WorkTypeException;
import com.manrega.exception.WorkersException;

public interface AllocateWorkDao {

	public String WorkAllocationForWorker(int empId, int workId)throws WorkersException, WorkTypeException;
	
}
