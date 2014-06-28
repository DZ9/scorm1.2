package com.idoxie.dishOL.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.idoxie.dishOL.model.Subject;
import com.idoxie.dishOL.util.DB;

public class SubjectService {
	public Subject getSubject(String subjectName) {
		
		Connection conn = DB.createConn();
		String sql = "select * from subject where subjectName = ?";
		PreparedStatement ps = DB.prepare(conn, sql);

		try {
//			String dName = new String(dishName.getBytes("ISO-8859-1"),"utf-8");
//System.out.println("dishName"+dName);
			ps.setString(1, subjectName);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Subject s = new Subject();
				String type = rs.getString("type");
				int num = rs.getInt("totalnum");
				String description = rs.getString("description");
				String pic = rs.getString("pic");
				String subjectBagName = rs.getString("subjectBagName");
				s.setSubjectName(subjectName);
//				s.setPrice(price);
				s.setNum(num);
				s.setDescription(description);
				s.setType(type);
				s.setPic(pic);
				s.setSubjectBagName(subjectBagName);
				return s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		DB.close(ps);
		DB.close(conn);
		return null;

	}
	
//	public boolean createSubject(Subject d) {
//		Connection conn = DB.createConn();
//		String sql = "insert into dish values (?,?,?,?,?,?)";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		
//		try {
//			ps.setString(1, d.getSubjectName());
//			ps.setString(2, d.getType());
//			ps.setInt(3, d.getNum());
//			ps.setString(4, d.getDescription());
//			ps.setString(5, d.getPic());
//			ps.setString(6, d.getSubjectBagName());
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DB.close(ps);
//		DB.close(conn);
//		return false;
//	}
	
	public boolean deleteSubject(String subjectName) {
		Connection conn = DB.createConn();
		String sql1 = "delete from subject where subjectName = ?";
		String sql2 = "delete from user_subject where subjectName = ?";
		PreparedStatement ps = DB.prepare(conn, sql1);
		
		try {
			ps.setString(1, subjectName);
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps = DB.prepare(conn, sql2);
		try {
			ps.setString(1, subjectName);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DB.close(ps);
		DB.close(conn);
		return true;
	}
	
//	public boolean updateDish(String dishName,String price,String type,int num,String description,String pic) {
//		Connection conn = DB.createConn();
//		String sql = "update dish set price = ?, type = ?, num = ?, description = ?, pic = ? where dishName = ?";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		
//		try {
//			ps.setString(1,price);
//			ps.setString(2,type);
//			ps.setInt(3,num);
//			ps.setString(4,description);
//			ps.setString(5, pic);
//			ps.setString(6, dishName);
//			ps.executeUpdate();
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DB.close(ps);
//		DB.close(conn);
//		return false;
//	}
	
	
	public void addSubject(String subjectName,String type,int num,String desc,String pic,String subjectBagName) {
		Connection conn = DB.createConn();
		String sql = "insert into subject values (?,?,?,?,?,?,?)";
		PreparedStatement ps = DB.prepare(conn, sql);
		
		try {
			ps.setString(1, subjectName);
			ps.setString(2, type);
			ps.setInt(3,num);
			ps.setString(4, desc);
			ps.setString(5, pic);
			ps.setString(6, subjectBagName);
			ps.setInt(7, 1);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isExist(String subjectName) {
		Connection conn = DB.createConn();
		String sql = "select * from subject where subjectName = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		boolean b = false;
		
		try {
			ps.setString(1, subjectName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		return b;
		
	}
	public List<Subject> list() {
		Connection conn = DB.createConn();
		String sql = "select * from subject";
		PreparedStatement ps = DB.prepare(conn, sql);
		List<Subject> subjects = new ArrayList<Subject>();
		
		try {
			ResultSet rs = ps.executeQuery();
			Subject s = null;
			while(rs.next()) {
				s = new Subject();
				s.setSubjectName(rs.getString("subjectName"));
				s.setDescription(rs.getString("description"));
				s.setNum(rs.getInt("totalNum"));
				s.setPic(rs.getString("pic"));
				s.setSubjectBagName(rs.getString("subjectBagName"));
				s.setType(rs.getString("type"));
				subjects.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		return subjects;
	}
	
	public List<Subject> listByType(String type) throws UnsupportedEncodingException {
		Connection conn = DB.createConn();
		//type=new String(type.getBytes("utf-8"),"utf-8");
		String sql = "select * from subject where type = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		List<Subject> subjects = new ArrayList<Subject>();
		
		try {
System.out.println(sql);
System.out.println(type);
			//ps.setString(1, type);
			
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			Subject s = null;
			while(rs.next()) {
				System.out.println("rs存在");
				s = new Subject();
				s.setSubjectName(rs.getString("subjectName"));
				s.setDescription(rs.getString("description"));
				s.setNum(rs.getInt("totalNum"));
				s.setPic(rs.getString("pic"));
				s.setSubjectBagName(rs.getString("subjectBagName"));
				s.setType(rs.getString("type"));
				subjects.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		return subjects;
	}
}
