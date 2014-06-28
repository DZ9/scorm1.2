package com.idoxie.dishOL.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.idoxie.dishOL.model.Subject;
import com.idoxie.dishOL.model.User;
import com.idoxie.dishOL.util.DB;

public class UserService {
	
	/*
	 * 添加用户
	 */
	public void addUser(String stuNum,String userName,String password,String email,Date createTime,String major) {
		Connection conn = DB.createConn();
		String sql = "insert into user values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, stuNum);
			ps.setString(2, userName);
			ps.setString(3, password);
			ps.setString(4, email);
			ps.setTimestamp(5, new java.sql.Timestamp(createTime.getTime()));
			ps.setString(6, major);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}
	
	/*
	 * 判断用户名密码是否正确
	 */
	public String queryUser(String username,String password) {
		Connection conn = DB.createConn();
		String sql = "select * from user where userName = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		String str = null;
		try {
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("password").equals(password)) {
					str = "true";
				}else{
					str = "false";
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		return str;
	}
	
	/*
	 * 为对应User添加DishOrder
	 */
	public void addSubject(String userName,String subjectName) {
		Connection conn = DB.createConn();
		String sql = "insert into user_subject(userName,subjectName) values (?, ?)";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, userName);
			ps.setString(2, subjectName);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}
	
	/*
	 * 根据用户名得到user对象
	 */
	public User getUser(String userName) {
		Connection conn = DB.createConn();
		String sql = "select * from user where userName = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		User u = new User();
		try {
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u.setStuNum(rs.getString("stuNum"));
				u.setMajor(rs.getString("major"));
				u.setUsername(userName);
				u.setEmail(rs.getString("email"));
				u.setRegisterTime(rs.getTimestamp("registerTime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		return u;
	}
	
	/*
	 * 判断当前用户名是否存在
	 */
	public boolean isExist(String userName) {
		Connection conn = DB.createConn();
		String sql = "select * from user where userName = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		boolean b = false;
		
		try {
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	
	/*
	 * 返回user的所有subjects
	 */
	public List<Subject> listSubject(String userName) {
		Connection conn = DB.createConn();
		String sql = "select * from user_subject where userName = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		List<Subject> list = new ArrayList();
		
		try {
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String subjectName = rs.getString("subjectName");
				SubjectService ss = new SubjectService();
				Subject s = ss.getSubject(subjectName);
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		return list;
	}
}
