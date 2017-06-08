package org.crazyit.ajax.service;

import org.apache.catalina.User;
import org.crazyit.ajax.domain.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
//import com.mysql.jdbc.*;

public class EditUserService {

	//EditUserService() {}
	
	Connection conn = null;
	public void connMysql() {
		
		String url = "jdbc:mysql://localhost:3306/votedata";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动");
			conn = DriverManager.getConnection(url,"root","52346940");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean insertUser(UserDataClass _user){
		//注册用户
		Statement stmt = null;
		//ResultSet rs= null;
		try{
			stmt=conn.createStatement();
			String sql="insert into userdata(id,name,phone) values("+ _user.getId() + ",'"+ _user.getName() +"','"+ _user.getPhone() +"')";
			if(stmt.executeUpdate(sql) == 1){
				return true;
			}else {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean searchUser(UserDataClass user) {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from userdata where name='" + user.getName() 
					+ "' and phone='" + user.getPhone() + "'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				//System.out.println("用户存在");
				return true;
			} else {
				//System.out.println("用户不存在");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//return false;
			e.printStackTrace();
			return false;
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}