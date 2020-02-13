package com.appl;

import javax.servlet.http.HttpServlet;

public class ContactList {
	String name;
	String PhoneNumber;
	String address;
	String email;

	public ContactList(String name, String phoneNumber, String email, String address) {
		this.name = name;
		this.PhoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}

	public String toString() {
		return name + " " + PhoneNumber + " " + " " + address;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name1) {
		name = name1;
	}

	public void setAddress(String addr) {
		address = addr;
	}

	public void setNumber(String number) {
		PhoneNumber = number;
	}

	public void setEmail(String email1) {
		email = email1;
	}

}
