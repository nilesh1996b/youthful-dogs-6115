
package com.manrega.WorkTypedao;

import java.util.List;

import com.manreg.bean.WorkType;
import com.manrega.exception.WorkTypeException;

public interface WorkTypeDao {

	public String registerWorkType(WorkType worker);
	public WorkType getWorkByEmpId(int workId) throws WorkTypeException;
	public WorkType getWorkDetailsByName(String workName) throws WorkTypeException;
	public List<WorkType> getAllWorkList() throws WorkTypeException;
}
