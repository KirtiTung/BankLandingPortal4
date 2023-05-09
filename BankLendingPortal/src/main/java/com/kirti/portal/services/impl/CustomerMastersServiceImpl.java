package com.kirti.portal.services.impl;
import com.kirti.portal.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.kirti.portal.entities.CustomerMasters;
import com.kirti.portal.payloads.CustomerMastersDto;
import com.kirti.portal.repositories.CustomerMastersRepo;
import com.kirti.portal.services.CustomerMastersService;

@Service
public class CustomerMastersServiceImpl implements CustomerMastersService {
	
	@Autowired
	private CustomerMastersRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<CustomerMastersDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<CustomerMasters> users=this.userRepo.findAll();
		List<CustomerMastersDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		 
		return userDtos;
	}
 
	@Override
	public CustomerMastersDto createCustomerMaster(CustomerMastersDto userDto) {
		// TODO Auto-generated method stub
		CustomerMasters user=this.dtoTOUser(userDto);
		CustomerMasters savedUser=this.userRepo.save(user);
		
		return this.userToDto(savedUser) ;
	}

	@Override
	public CustomerMastersDto updateCustomerMaster(CustomerMastersDto userDto, String userId) {
		// TODO Auto-generated method stub
		CustomerMasters user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		
		user.setCust_First_Name(userDto.getCust_First_Name());
		user.setCust_Last_Name(userDto.getCust_Last_Name());
		user.setAddress(userDto.getAddress());
		user.setCity(userDto.getCity());
		user.setState(userDto.getState());
		user.setContactNo(userDto.getContactNo());
		user.setAdharCard(userDto.getAdharCard());
		user.setEmailId(userDto.getEmailId());
		user.setBirthDate(userDto.getBirthDate());
		user.setMonthlySalary(userDto.getMonthlySalary());
		
		CustomerMasters updatedUser=this.userRepo.save(user);
		CustomerMastersDto userToDto1 = this.userToDto(updatedUser);
		
		return userToDto1;
	}

	@Override
	public CustomerMastersDto getCustomerMasterById(String userId) {
		// TODO Auto-generated method stub
		CustomerMasters user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		return this.userToDto(user);
	}

	@Override
	public void deleteCustomerMasterById(String userId) {
		// TODO Auto-generated method stub
		CustomerMasters user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		this.userRepo.delete(user);

	}
	
	
	public CustomerMasters dtoTOUser(CustomerMastersDto userDto) {

		CustomerMasters user=this.modelMapper.map(userDto,CustomerMasters.class);
		
		//		CustomerMasters user=new CustomerMasters();
//		user.setPk_Customer_Master(userDto.getPk_Customer_Master());
//		user.setCust_First_Name(userDto.getCust_First_Name());
//		user.setCust_Last_Name(userDto.getCust_Last_Name());
//		user.setAddress(userDto.getAddress());
//		user.setCity(userDto.getCity());
//		user.setState(userDto.getState());
//		user.setContactNo(userDto.getContactNo());
//		user.setAdharCard(userDto.getAdharCard());
//		user.setEmailId(userDto.getEmailId());
//		user.setBirthDate(userDto.getBirthDate());
//		user.setMonthlySalary(userDto.getMonthlySalary());
		
		return user;
	}
	
	public CustomerMastersDto userToDto(CustomerMasters user) {

		CustomerMastersDto userDto=this.modelMapper.map(user,CustomerMastersDto.class);
		
		//		CustomerMastersDto userDto=new CustomerMastersDto();
//		userDto.setPk_Customer_Master(user.getPk_Customer_Master());
//		userDto.setCust_First_Name(user.getCust_First_Name());
//		userDto.setCust_Last_Name(user.getCust_Last_Name());
//		userDto.setAddress(user.getAddress());
//		userDto.setCity(user.getCity());
//		userDto.setState(user.getState());
//		userDto.setContactNo(user.getContactNo());
//		userDto.setAdharCard(user.getAdharCard());
//		userDto.setEmailId(user.getEmailId());
//		userDto.setBirthDate(user.getBirthDate());
//		userDto.setMonthlySalary(user.getMonthlySalary());
		
		return userDto;
	}
	
}
