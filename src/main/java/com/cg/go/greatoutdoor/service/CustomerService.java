package com.cg.go.greatoutdoor.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.greatoutdoor.dao.ICustomerRepository;
import com.cg.go.greatoutdoor.entity.Customer;
import com.cg.go.greatoutdoor.exception.CustomerException;
import com.cg.go.greatoutdoor.exception.ProductException;

@Service
@Transactional
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list=customerRepository.findAll();
		return list;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		boolean exists=customer.getCustomerId()!=null && customerRepository.existsById(customer.getCustomerId());
        if(exists){
            throw new CustomerException("Product already exists for id="+customer.getCustomerId());
        }
		customer=customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		boolean exists=customer.getCustomerId()!=null && customerRepository.existsById(customer.getCustomerId());
        if(!exists){
            throw new CustomerException("Product does not exists for id="+customer.getCustomerId());
        }
		customer=customerRepository.save(customer);
		return customer;
	}

	@Override
	public void removeCustomer(Integer customerId) {
		Customer customer=findById(customerId);
		customerRepository.delete(customer);
	}

	/*@Override
	public Customer viewCustomer(Customer customer) {
		customer=findById(customer.getCustomerId());
		return customer;
	}*/
	
	@Override
	public Customer findById(int customerId) {
		Optional<Customer> optional=customerRepository.findById(customerId);
		if(!optional.isPresent()){
            throw new CustomerException("Customer not found for id="+customerId);
		}
		Customer customer=optional.get();
		return customer;
	}

}
