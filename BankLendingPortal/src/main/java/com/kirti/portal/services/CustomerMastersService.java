package com.kirti.portal.services;

import java.util.List;

import com.kirti.portal.entities.CustomerMasters;
import com.kirti.portal.payloads.CustomerMastersDto;

public interface CustomerMastersService {
	//Return list of customers
	public List<CustomerMastersDto> getAllUsers();
	//Add new customer
	public CustomerMastersDto createCustomerMaster(CustomerMastersDto userz);
	//Update existing customer
	public CustomerMastersDto updateCustomerMaster(CustomerMastersDto user,String userId);
	//get customer by id
	public CustomerMastersDto getCustomerMasterById(String userId);
	//delete customer by id
	public void deleteCustomerMasterById(String userId);
	
	
	
}
