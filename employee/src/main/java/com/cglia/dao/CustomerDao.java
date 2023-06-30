package com.cglia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cglia.dto.Customer;

@Component
public class CustomerDao {
	
	@Autowired
	Customer customer;
	
	
	public Customer create(Customer customer)
	{
		Connection con = ConnectionDao.getConnection();
		String sql = "insert into CUSTOMER(customername, customerEmail, status, createdBy, modifiedTime) values(?,?,?,?,?)";
		int status = 1;
		String createdBy ="SK";
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentDateTimeString = currentDateTime.format(formatter);
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, customer.getCustomername());
			ps.setString(2, customer.getCustomerEmail());
			ps.setInt(3, status);
			ps.setString(4, createdBy);
			ps.setString(5, currentDateTimeString);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
	public Customer get(int id)
	{
		Connection con = ConnectionDao.getConnection();
		String sql = "select * from CUSTOMER where customerid = ? and status=1";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer.setCustomerId(rs.getInt(1));
				customer.setCustomername(rs.getString(2));
				customer.setCustomerEmail(rs.getString(3));
				customer.setStatus(rs.getInt(4));
				customer.setCreatedBy(rs.getString(5));
				customer.setModifiedTime(rs.getString(6));
				customer.setModifiedBy(rs.getString(7));
			}	
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	public Customer getByNameAndId(int id, String name)
	{
		Connection con = ConnectionDao.getConnection();
		String sql = "select * from CUSTOMER where customerid = ? and customername=? and status=1";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer.setCustomerId(rs.getInt(1));
				customer.setCustomername(rs.getString(2));
				customer.setCustomerEmail(rs.getString(3));
				customer.setStatus(rs.getInt(4));
				customer.setCreatedBy(rs.getString(5));
				customer.setModifiedTime(rs.getString(6));
				customer.setModifiedBy(rs.getString(7));
			}	
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	
	public Customer update(Customer customer1, int id) {
		Connection con = ConnectionDao.getConnection();
		String sql = "update CUSTOMER set customername = ?, customerEmail = ?, modifiedTime = ?, modifiedBy=?  where customerid = ?";
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentDateTimeString = currentDateTime.format(formatter);
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, customer1.getCustomername());
			ps.setString(2, customer1.getCustomerEmail());
			ps.setString(3, currentDateTimeString);
			ps.setString(4, customer1.getModifiedBy());
			ps.setInt(5, id);
			if (ps.executeUpdate() != 0) {
				return get(id);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int delete(int id) {
		
		Connection con = ConnectionDao.getConnection();
		String sql = "update CUSTOMER set status= 0 where customerid=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int x = ps.executeUpdate();
			if (x != 0) {
				return x;
			}else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}



























