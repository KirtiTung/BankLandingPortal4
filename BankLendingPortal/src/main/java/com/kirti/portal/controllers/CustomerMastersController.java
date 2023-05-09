package com.kirti.portal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kirti.portal.payloads.ApiResponse;
import com.kirti.portal.payloads.CustomerMastersDto;
import com.kirti.portal.services.CustomerMastersService;

@Controller
@RestController
@RequestMapping("/api/customers")
public class CustomerMastersController {
	
	@Autowired
	private CustomerMastersService userService;
	
	//Post-create user
	@PostMapping("/new")
	public ResponseEntity<CustomerMastersDto> createNewCustomer( @RequestBody@Valid CustomerMastersDto userDto){
		CustomerMastersDto createUserDto= this.userService.createCustomerMaster(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	//Put- update user
	@PutMapping("{userId}/update")
	public ResponseEntity<CustomerMastersDto> updateCustomer( @RequestBody@Valid CustomerMastersDto userDto,@PathVariable String userId){
		CustomerMastersDto updatedUser = this.userService.updateCustomerMaster(userDto,userId);
		return ResponseEntity.ok(updatedUser);
	}
	
	//Delete - delete user
	@DeleteMapping("{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable String userId){
		ResponseEntity<?> deleteUser=this.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true),HttpStatus.OK);
	}
	
	//GET- user get
	@GetMapping
	public ResponseEntity<List<CustomerMastersDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	//GET- single user
	@GetMapping("{userId}")
	public ResponseEntity<CustomerMastersDto> getSingleUser(@PathVariable String userId){
		
		return ResponseEntity.ok(this.userService.getCustomerMasterById(userId));
	}
}
