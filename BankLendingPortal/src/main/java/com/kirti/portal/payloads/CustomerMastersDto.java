package com.kirti.portal.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CustomerMastersDto {
	
	private String Pk_Customer_Master;
	@NotEmpty
	@Pattern(regexp = "[A-Za-z]+$")
	private String Cust_First_Name;
	private String Cust_Last_Name;
	private String Address;
	private String City;
	private String State;
	@Size(max=10,min=10)
	private String ContactNo;
	private String AdharCard;
	@Email(message="Email is not valid",regexp="^[A-Za-z0-9+_.-]+@cognizant.com$")
	@NotEmpty
	private String EmailId;
	private String BirthDate;
	private int MonthlySalary;
	private String password;
	public String getPk_Customer_Master() {
		return Pk_Customer_Master;
	}
	public void setPk_Customer_Master(String pk_Customer_Master) {
		Pk_Customer_Master = pk_Customer_Master;
	}
	public String getCust_First_Name() {
		return Cust_First_Name;
	}
	public void setCust_First_Name(String cust_First_Name) {
		Cust_First_Name = cust_First_Name;
	}
	public String getCust_Last_Name() {
		return Cust_Last_Name;
	}
	public void setCust_Last_Name(String cust_Last_Name) {
		Cust_Last_Name = cust_Last_Name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	public String getAdharCard() {
		return AdharCard;
	}
	public void setAdharCard(String adharCard) {
		AdharCard = adharCard;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}
	public int getMonthlySalary() {
		return MonthlySalary;
	}
	public void setMonthlySalary(int monthlySalary) {
		MonthlySalary = monthlySalary;
	}
	public CustomerMastersDto(String pk_Customer_Master,
			@NotEmpty @Pattern(regexp = "[A-Za-z]+$") String cust_First_Name, String cust_Last_Name, String address,
			String city, String state, @Size(max = 10, min = 10) String contactNo, String adharCard,
			@Email(message = "Email is not valid", regexp = "^[A-Za-z0-9+_.-]+@cognizant.com$") @NotEmpty String emailId,
			String birthDate, int monthlySalary) {
		super();
		Pk_Customer_Master = pk_Customer_Master;
		Cust_First_Name = cust_First_Name;
		Cust_Last_Name = cust_Last_Name;
		Address = address;
		City = city;
		State = state;
		ContactNo = contactNo;
		AdharCard = adharCard;
		EmailId = emailId;
		BirthDate = birthDate;
		MonthlySalary = monthlySalary;
	}
	public CustomerMastersDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
