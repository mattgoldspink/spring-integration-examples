package com.amazinbooks.domain;

public class Customer {

	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String postalAddress;

	public Customer(String firstname, String lastname, String email,
			String postalAddress) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.postalAddress = postalAddress;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	
	@Override
	public String toString() {
		return this.getFirstname() + " " + this.getLastname() + " (" + this.getEmail() + "), " + this.getPostalAddress();
	}
	
}
