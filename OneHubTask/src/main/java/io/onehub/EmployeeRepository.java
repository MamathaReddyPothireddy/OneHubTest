package io.onehub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class EmployeeRepository {
	
	Connection con=null;
	
	public EmployeeRepository() {
		//System.out.println("in constructor");
		String url="jdbc:mysql://192.168.0.5:3306/restdb";
		String username="root";
		String password="mr$mysql";
		try {	
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	public Employee addEmployee(Employee b1) {
		String sql="insert into employees(title,firstname,surname,dob,gender,email,address) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			//stmt.setInt(1, b1.getId());
			stmt.setString(1, b1.getTitle());
			stmt.setString(2, b1.getFirstName());
			stmt.setString(3, b1.getSurname());
			stmt.setString(4, b1.getDob());
			stmt.setString(5, b1.getGender());
			stmt.setString(6, b1.getEmail());
			stmt.setString(7, b1.getAddress());
			stmt.executeUpdate();
			
			String sql2="SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME='employees'";
			Statement stmt2 = con.createStatement();
			ResultSet rs = stmt2.executeQuery(sql2);
			
			if(rs.next()) {
				
				b1.setEmployeeNo((rs.getInt(1)-1));
			}
			System.out.println(b1);
			
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return b1;
	}

}
