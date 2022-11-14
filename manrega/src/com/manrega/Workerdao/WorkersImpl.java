package com.manrega.Workerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manreg.bean.Workers;
import com.manrega.exception.WorkersException;
import com.manrega.util.DBUtil;

public class WorkersImpl implements WorkersDao {

	@Override
	public String registerWorker(Workers worker) {
		String message = "Not Registered";
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("insert into workers values(?,?,?,?,?)");

			int empId = worker.getEmpId();
			ps.setInt(1, empId);
			
			String name = worker.getName();
			ps.setString(2, name);
			
			int salary = worker.getSalary();
			ps.setInt(3, salary);
			
			String email = worker.getEmail();
			ps.setString(4, email);
			
			String dateOfJoin = worker.getDateOfJoin();
			ps.setString(5, dateOfJoin);
		

			
			int x = ps.executeUpdate();
			if(x>0)
			message = "Worker registration Done";
		}catch(SQLException e)
		{
			
		}
		
		return message;
	}

	@Override
	public Workers getWorkerByEmpId(int empId) throws WorkersException {
		
		Workers worker = null;
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("select * from workers where empId = ?");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int i = rs.getInt("empId");
				String n = rs.getString("empName");
				int s = rs.getInt("salary");
				String e = rs.getString("empEmail");
				String d = rs.getString("dateOfJoining");
				
				worker = new Workers(i,n,s,e,d);
				
			}else
				throw new WorkersException("Worker does not exist with empID " + empId);

		}catch(SQLException e)
		{
			throw new WorkersException(e.getMessage());
		}
		
		return worker;		
	}

	@Override
	public Workers getDetailsByNameAndJoiningDate(String empName, String dateOfJoining) throws WorkersException {
		Workers worker = null;
		
		try(Connection conn = DBUtil.provideConnection())
		{
			PreparedStatement ps = conn.prepareStatement("select * from workers where empName = ? and dateOfJoining = ?");
			ps.setString(1, empName);
			ps.setString(2, dateOfJoining);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int i = rs.getInt("empId");
				String n = rs.getString("empName");
				int s = rs.getInt("salary");
				String e = rs.getString("empEmail");
				String d = rs.getString("dateOfJoining");
				
				worker = new Workers(i,n,s,e,d);
				
			}else
				throw new WorkersException("Name or Date Of Joining is incorrect");

		}catch(SQLException e)
		{
			throw new WorkersException(e.getMessage());
		}
		
		return worker;
	}

	@Override
	public List<Workers> getAllDetails() throws WorkersException {
		
		List<Workers> worker = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from workers");
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next())
			{
				int i = rs.getInt("empId");
				String n = rs.getString("empName");
				int s = rs.getInt("salary");
				String e = rs.getString("empEmail");
				String d = rs.getString("dateOfJoining");
				
				Workers list = new Workers(i,n,s,e,d);
				worker.add(list);
			}
			
		}catch(SQLException e)
		{
			throw new WorkersException(e.getMessage());
		}
		
		if(worker.size()==0)
			throw new WorkersException("No Worker is Registered");
		
		return worker;
	}

}
