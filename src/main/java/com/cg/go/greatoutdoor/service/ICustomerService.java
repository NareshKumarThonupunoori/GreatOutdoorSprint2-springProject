package com.cg.go.greatoutdoor.service;


import java.util.List;

import com.cg.go.greatoutdoor.entity.Customer;


public interface ICustomerService {


	List<Customer> getAllCustomers();
	Customer addCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	void removeCustomer(Integer customerId);
	public Customer findById(int customerId);
	//Customer viewCustomer(Customer customer);
}
