package com.manrega.AllocateWorkDao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.manrega.exception.WorkTypeException;
import com.manrega.exception.WorkersException;
import com.manrega.util.DBUtil;


public class AllocateWorkImpDao implements AllocateWorkDao{

	@Override
	public String WorkAllocationForWorker(int empId, int workId) throws WorkersException, WorkTypeException {
		
		String message = "Not Allocated";
		
			try (Connection conn = DBUtil.provideConnection()){
				
				PreparedStatement ps = conn.prepareStatement("select * from workers where empId = ?");
				ps.setInt(1,empId);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next())
				{
					PreparedStatement ps2 = conn.prepareStatement("select * from workType where workId = ?");
					ps2.setInt(1,workId);
					ResultSet rs2 = ps.executeQuery();
					if(rs2.next())
					{
						PreparedStatement ps3 = conn.prepareStatement("insert into workers_worktype values(?,?)");
						ps3.setInt(1,empId);
						ps3.setInt(2,workId);
						int x =  ps3.executeUpdate();
						if(x >0)
						{
							message = "Worker with " + empId + " Allocated to Work ID " + workId;
						}else
							throw new WorkersException("Technical Error");
						
					}else
					{
						throw new WorkTypeException("There is no Work available with Work Id " + workId);
					}
					
				}else
				{
					throw new WorkersException("There is no Worker available with Employee Id " + empId);
				}
				
			} catch (SQLException e) {
				throw new WorkersException(e.getMessage());
			}
			
		
		return message;
	}

}
