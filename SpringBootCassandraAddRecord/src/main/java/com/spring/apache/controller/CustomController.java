package com.spring.apache.controller;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.apache.VO.CustomerVO;
import com.spring.apache.service.CustomerInfoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CustomController {
	
	@Autowired
	private CustomerInfoService service;
	@Autowired
	private CustomerVO customer;

	@ApiOperation(value = "This method is used for Adding the Customer Information!. ")
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Customer Information is added Sucessfully!"),
			@ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Error Occurred while processing the request! ") })
	@PostMapping(value = "/api-service/v1/customers/customer/add", produces = "application/json")
	public ResponseEntity<?> addRecord(@RequestBody(required=true) CustomerVO customer) {
		if (customer != null)
			try {
				customer =service.saveCustomerInfo(customer);
				return new ResponseEntity(customer, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity("Cannot Add!", HttpStatus.BAD_REQUEST);
			}
		return null;
	}

	@ApiOperation(value = "This method is used for Updating the Customer Information!. ")
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Customer Information is updated Sucessfully!"),
			@ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Error Occurred while processing the request! ") })
	@PutMapping(value = "/api-service/v1/customers/customer/update", produces = "application/json")
	public ResponseEntity<?> updateRecord(@RequestBody(required=true) CustomerVO customer) {
		if (customer != null && customer.getCustomerId() != null)
			try {
				customer = service.updateCustomerInfo(customer);
				return new ResponseEntity(customer, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity("Cannot Update!", HttpStatus.BAD_REQUEST);
			}
		return null;
	}
}
