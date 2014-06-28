//package com.idoxie.dishOL.service;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.idoxie.dishOL.model.Subject;
//import com.idoxie.dishOL.util.DB;
//
//public class ShoppingCartService {
//	public void addDish(String userName,String dishName,int count) {
//		Connection conn = DB.createConn();
//		String sql = "insert into shoppingcart values (?, ?, ?,?)";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		SubjectService ds = new SubjectService();
//System.out.println(1);
//		Subject d = ds.getDish(dishName);
//System.out.println(2);		
//		try {
//			ps.setString(1, userName);
//			ps.setString(2,dishName);
//			ps.setString(3, d.getPrice());
//			ps.setInt(4, count);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DB.close(ps);
//		DB.close(conn);
//		
//	}
//	
//	public void updateDish(String userName ,String dishName,int count) {
//		Connection conn = DB.createConn();
//		String sql = "update shoppingcart set count = ? where userName = ? and dishName = ?";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		int preCount = isExist(userName,dishName);
//		
//		try {
//			ps.setInt(1, count+preCount);
//			ps.setString(2, userName);
//			ps.setString(3,dishName);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DB.close(ps);
//		DB.close(conn);
//	}
//	public void deleteDish(String userName ,String dishName) {
//		Connection conn = DB.createConn();
//		String sql = "delete from shoppingcart where dishName = ? and userName = ?";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		
//		try {
//			ps.setString(1, dishName);
//			ps.setString(2, userName);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		DB.close(ps);
//		DB.close(conn);
//		
//	}
//
//	public void deleteAll(String userName) {
//		Connection conn = DB.createConn();
//		String sql = "delete from shoppingcart where userName = ?";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		
//		try {
//			ps.setString(1, userName);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public List<Subject> list(String userName) {
//		Connection conn = DB.createConn();
//		String sql = "select * from shoppingcart where userName = ?";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		List<Subject> dishes = new ArrayList<Subject>();
//		
//		try {
//			ps.setString(1, userName);
//			ResultSet rs = ps.executeQuery();
//			
//			Subject d = null;
//			while(rs.next()) {
//				d = new Subject();
//				d.setDishName(rs.getString("dishName"));
//				d.setPrice(rs.getString("dishPrice"));
//				d.setNum(rs.getInt("count"));
//				dishes.add(d);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DB.close(ps);
//		DB.close(conn);
//		return dishes;
//	}
//	
//	public int isExist(String userName,String dishName) {
//		Connection conn = DB.createConn();
//		String sql = "select * from shoppingcart where userName = ? and dishName = ?";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		boolean b = false;
//		int i = 0;
//		try {
//			ps.setString(1, userName);
//			ps.setString(2, dishName);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				i = rs.getInt("count");
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DB.close(ps);
//		DB.close(conn);
//		return i;
//	}
//	
//}
