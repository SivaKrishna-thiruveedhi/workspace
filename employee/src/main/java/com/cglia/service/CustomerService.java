package com.cglia.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

import com.cglia.dao.CustomerDao;
import com.cglia.dto.Customer;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	@Autowired
	Customer customer;
//	@Autowired
//	CustomerRepo customerRepo;
//	
	public Customer saveCustomer(Customer customer){
		return customerDao.create(customer);
	}
	
	public Customer getCustomer(int id) {
		customer = customerDao.get(id);
		if (customer.getCustomerId() == 0) {
			return null;
		} else {
			return customer;
		}
	}
	public Customer getCustomerByNameAndId(int id, String name) {
		customer = customerDao.getByNameAndId(id, name);
		if (customer.getCustomerId() == 0) {
			return null;
		} else {
			return customer;
		}
	}
	
	public Customer updateAndReturn(Customer customer, int id) {
		return customerDao.update(customer,id);
	}
	
	public String deleteCustomer(int id) {
		int x = customerDao.delete(id);
		if (x != 0) {
			return "Customer removed Successfully";
		} else {
			return "Customer is not removed";
		}
	}
}
