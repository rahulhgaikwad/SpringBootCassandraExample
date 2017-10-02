package com.spring.apache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;
import com.spring.apache.DTO.CustomerDAORepository;
import com.spring.apache.VO.CustomerVO;
@Service
public class CustomerInfoService {
	
	@Autowired
	private CustomerDAORepository repository;
	
	public CustomerVO saveCustomerInfo(CustomerVO customer) {
		customer.setCustomerId(UUIDs.timeBased());
		CustomerVO cust = repository.save(customer);
			return cust;
	}
	
	public CustomerVO updateCustomerInfo(CustomerVO customer) {
		CustomerVO cust = repository.save(customer);
			return cust;
	}
}
