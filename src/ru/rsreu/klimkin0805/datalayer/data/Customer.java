package ru.rsreu.klimkin0805.datalayer.data;

import com.prutzkow.resourcer.Resourcer;

public class Customer {
	private String name;
	private String address;
	private String phone;
	private String surnameContactPerson;

	public Customer(String name, String address, String phone, String surnameContactPerson) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.surnameContactPerson = surnameContactPerson;
	}

	public String toString() {
		return String.format(Resourcer.getString("customer.format"), name, address, phone, surnameContactPerson);
	}
}
