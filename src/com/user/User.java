package com.user;

public class User {
	protected String firstName;
//	protected String middleName1;
//	protected String middleName2;
	protected String lastName;
//	protected int age;
//	prote/cted String phoneNumber;
//	protected String email;
//	protected Address address;
	protected String userType;
	
	public User() {};
	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
//	public String getMiddleName1() {
//		return middleName1;
//	}
//	public void setMiddleName1(String middleName1) {
//		this.middleName1 = middleName1;
//	}
//	public String getMiddleName2() {
//		return middleName2;
//	}
//	public void setMiddleName2(String middleName2) {
//		this.middleName2 = middleName2;
//	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getPhoneNumber() {
//		return phoneNumber;
//	}
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public Address getAddress() {
//		return address;
//	}
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//	
//	public String getUserType() {
//		return userType;
//	}
//	public void setUserType(String userType) {
//		this.userType = userType;
//	}
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	
	

	

	
}
