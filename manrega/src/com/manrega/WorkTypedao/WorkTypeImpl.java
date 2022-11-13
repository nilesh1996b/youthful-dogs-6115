package com.manrega.WorkTypedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.manreg.bean.WorkType;
import com.manrega.util.DBUtil;
import com.marega.exception.WorkTypeException;


public class WorkTypeImpl implements WorkTypeDao {

	@Override
	public String registerWorkType(WorkType work) {
		String message = "Not Registered";
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("insert into workType values(?,?,?)");

			int workId = work.getWorkId();
			ps.setInt(1, workId);
			
			String workName = work.getWorkName();
			ps.setString(2, workName);
			
			int workHours = work.getWorkHours();
			ps.setInt(3, workHours);
			
			
			int x = ps.executeUpdate();
			if(x>0)
			message = "Work registration Done";
		}catch(SQLException e)
		{
			
		}
		
		return message;
	}

	@Override
	public WorkType getWorkByEmpId(int workId) throws WorkTypeException {
		
		WorkType work = null;
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("select * from workType where workId = ?");
			ps.setInt(1, workId);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int i = rs.getInt("workId");
				String n = rs.getString("workName");
				int h = rs.getInt("workHours");

				
				work = new WorkType(i,n,h);
				
			}else
				throw new WorkTypeException("Work does not exist with workID " + workId);

		}catch(SQLException e)
		{
			throw new WorkTypeException(e.getMessage());
		}
		
		return work;		
	}

	@Override
	public WorkType getWorkDetailsByName(String workName) throws WorkTypeException{
		WorkType work = null;
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("select * from workType where workName = ?");
			ps.setString(1, workName);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int i = rs.getInt("workId");
				String n = rs.getString("workName");
				int h = rs.getInt("workHours");
				
				work = new WorkType(i,n,h);
				
			}else
				throw new WorkTypeException("Name of Work is incorrect");

		}catch(SQLException e)
		{
			throw new WorkTypeException(e.getMessage());
		}
		
		return work;
	}

	@Override
	public List<WorkType> getAllWorkList() throws WorkTypeException{
		
		List<WorkType> work = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from workers");
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next())
			{
				int i = rs.getInt("workId");
				String n = rs.getString("workName");
				int h = rs.getInt("workHours");
				
				WorkType list = new WorkType(i,n,h);
				work.add(list);
			}
			
		}catch(SQLException e)
		{
			throw new WorkTypeException(e.getMessage());
		}
		
		if(work.size()==0)
			throw new WorkTypeException("No Worker is Registered");
		
		return work;
	}

}
