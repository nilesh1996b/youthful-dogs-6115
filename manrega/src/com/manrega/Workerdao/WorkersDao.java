
package com.manrega.Workerdao;

import java.util.List;

import com.manreg.bean.Workers;
import com.manrega.exception.WorkersException;

public interface WorkersDao {

	public String registerWorker(Workers worker);
	public Workers getWorkerByEmpId(int empId) throws WorkersException;
	public Workers getDetailsByNameAndJoiningDate(String empName, String dateOfJoining) throws WorkersException;
	public List<Workers> getAllDetails() throws WorkersException;
}
