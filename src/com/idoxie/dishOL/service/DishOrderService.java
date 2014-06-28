//package com.idoxie.dishOL.service;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import com.idoxie.dishOL.model.Subject;
//import com.idoxie.dishOL.model.DishOrder;
//import com.idoxie.dishOL.util.DB;
//
//public class DishOrderService {
//	public boolean deleteDish(Subject d) {
//		Connection conn = DB.createConn();
//		String sql = "delete from dishorder_dish where dishName = ?";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		try {
//			ps.setString(1, d.getDishName());
//			ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DB.close(ps);
//		DB.close(conn);
//		return true;
//	}
//	
//	public boolean addDish(String orderName,String dishName,int dishNum) {
//		Connection conn = DB.createConn();
//		String sql = "insert into dishorder_dish(orderName,dishName,dishNum) values (?, ?, ?)";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		try {
//			ps.setString(1, orderName);
//			ps.setString(2, dishName);
//			ps.setInt(3, dishNum);
//			ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DB.close(ps);
//		DB.close(conn);
//		return true;
//	}
//	
//	public DishOrder createDishOrder(String orderName,Date createTime,String price,String status) {
//		Connection conn = DB.createConn();
//		String sql = "insert into dishorder values (?, ?, ?, ?)";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		DishOrder d = new DishOrder();
//		d.setCreateTime(createTime);
//		d.setOrderName(orderName);
//		d.setPrice(price);
//		d.setStatus(status);
//		try {
//			ps.setString(1, orderName);
//			ps.setTimestamp(2, new java.sql.Timestamp(createTime.getTime()));
//			ps.setString(3, price);
//			ps.setString(4, status);
//			ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DB.close(ps);
//		DB.close(conn);
//		return d;
//	}
//	
//	public DishOrder createDishOrder(Date createTime,String price,String status) {
//		int i = (int)(Math.random()*2000 + 1);
//		String orderName=Integer.toHexString(i);
//		return createDishOrder(orderName, createTime, price, status);
//	}
//	
//	public DishOrder getDishOrder(String orderName) {
//		Connection conn = DB.createConn();
//		String sql = "select * from dishorder where orderName = ?";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		DishOrder d = new DishOrder();
//		try {
//			ps.setString(1, orderName);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				d.setCreateTime(rs.getTimestamp("createTime"));
//				d.setOrderName(orderName);
//				d.setPrice(rs.getString("price"));
//				d.setStatus(rs.getString("status"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DB.close(ps);
//		DB.close(conn);
//		return d;
//	}
//	
//	public void updateStatus(String orderName,String status) {
//		Connection conn = DB.createConn();
//		String sql = "update dishorder set status = ? where orderName = ?";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		
//		try {
//			ps.setString(1, status);
//			ps.setString(2, orderName);
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
//	public List<DishOrder> list() {
//		Connection conn = DB.createConn();
//		String sql = "select * from dishOrder";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		List<DishOrder> dishOrders = new ArrayList<DishOrder>();
//		
//		try {
//			ResultSet rs = ps.executeQuery();
//			DishOrder d = null;
//			while(rs.next()) {
//				d = new DishOrder();
//				d.setOrderName(rs.getString("orderName"));
//				d.setPrice(rs.getString("price"));
//				d.setStatus(rs.getString("status"));
//				d.setCreateTime(rs.getDate("createTime"));
//				dishOrders.add(d);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DB.close(ps);
//		DB.close(conn);
//		return dishOrders;
//	}
//	
//	public List<Subject> getDishes(String orderName) {
//		Connection conn = DB.createConn();
//		String sql = "select * from dishOrder_dish where orderName = ?";
//		PreparedStatement ps = DB.prepare(conn, sql);
//		List<Subject> dishes = new ArrayList<Subject>();
//		try {
//			ResultSet rs = ps.executeQuery();
//			Subject d = null;
//			while(rs.next()) {
//				String dishName = rs.getString("dishName");
//				String sql_d = "select * from dish where dishName = ?";
//				PreparedStatement ps_d = DB.prepare(conn, sql_d);
//				ps_d.setString(1, dishName);
//				ResultSet rs_d = ps_d.executeQuery();
//				while(rs_d.next()) {
//					d = new Subject();
//					d.setDishName(rs_d.getString("dishName"));
//					d.setDescription(rs_d.getString("description"));
//					d.setNum(rs_d.getInt("num"));
//					d.setPic(rs_d.getString("pic"));
//					d.setPrice(rs_d.getString("price"));
//					d.setType(rs_d.getString("type"));
//					dishes.add(d);
//				}
//				DB.close(ps_d);
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DB.close(ps);
//		DB.close(conn);
//		return dishes;
//	}
//}
//
//
